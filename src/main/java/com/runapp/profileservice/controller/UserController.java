package com.runapp.profileservice.controller;

import com.runapp.profileservice.dto.request.*;
import com.runapp.profileservice.dto.response.DeleteResponse;
import com.runapp.profileservice.dto.response.UserResponse;
import com.runapp.profileservice.dto.userDtoMapper.UserDtoMapper;
import com.runapp.profileservice.feignClient.StorageServiceClient;
import com.runapp.profileservice.model.DistanceGoalModel;
import com.runapp.profileservice.model.DurationGoalModel;
import com.runapp.profileservice.model.UserModel;
import com.runapp.profileservice.model.WeightGoalModel;
import com.runapp.profileservice.service.UserService;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@Tag(name = "User Management", description = "Operations related to users")
public class UserController {

    private final UserService userService;
    private final UserDtoMapper userDtoMapper;

    @Value("${storage-directory}")
    private String storageDirectory;

    @Autowired
    private StorageServiceClient storageServiceClient;

    @Autowired
    public UserController(UserService userService, UserDtoMapper userDtoMapper) {
        this.userService = userService;
        this.userDtoMapper = userDtoMapper;
        this.storageServiceClient = storageServiceClient;
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user with the provided data")
    @ApiResponse(responseCode = "201", description = "User created", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public ResponseEntity<Object> createUser(
            @RequestBody @Valid UserRequest userRequest,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> validationErrors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
        }

        UserModel createdUser = userService.createUser(userDtoMapper.toModel(userRequest));
        UserResponse userResponse = userDtoMapper.toResponse(createdUser);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get a user by ID", description = "Retrieve a user by their ID")
    @ApiResponse(responseCode = "200", description = "User found", content = @Content(schema = @Schema(implementation = UserModel.class)))
    @ApiResponse(responseCode = "404", description = "User not found")
    public ResponseEntity<UserResponse> getUserById(
            @Parameter(description = "User ID", required = true)
            @PathVariable int userId) {
        Optional<UserModel> user = userService.getUserById(userId);
        return user.map(value -> new ResponseEntity<>(userDtoMapper.toResponse(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
    @ApiResponse(responseCode = "200", description = "Users found", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserModel> users = userService.getAllUsers();
        List<UserResponse> userResponses = users.stream()
                .map(userDtoMapper::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(userResponses, HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    @Operation(summary = "Update a user", description = "Update an existing user with the provided data")
    @ApiResponse(responseCode = "200", description = "User updated", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "User not found")
    public ResponseEntity<Object> updateUser(
            @Parameter(description = "User ID", required = true)
            @PathVariable int userId,
            @Valid @RequestBody UserRequest userRequest,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> validationErrors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
        }

        UserModel updated = userService.updateUser(userId, userDtoMapper.toModel(userRequest));
        if (updated != null) {
            UserResponse userResponse = userDtoMapper.toResponse(updated);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Delete a user by ID", description = "Delete a user by their ID")
    @ApiResponse(responseCode = "204", description = "User deleted")
    @ApiResponse(responseCode = "404", description = "User not found")
    public ResponseEntity<Void> deleteUser(
            @Parameter(description = "User ID", required = true)
            @PathVariable int userId) {
        Optional<UserModel> userModel = userService.getUserById(userId);
        if (userModel.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/upload-image")
    @Operation(summary = "Upload an image for a story", description = "Upload an image file for a specific story by providing the file and story ID.")
    @ApiResponse(responseCode = "200", description = "Image uploaded successfully", content = @Content(schema = @Schema(implementation = UserModel.class), mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Story not found")
    public ResponseEntity<Object> uploadImage(
            @Parameter(description = "Image file to upload", required = true) @RequestParam("file") MultipartFile file,
            @Parameter(description = "ID of the story to associate with the uploaded image", required = true) @RequestParam("user_id") int userId) {
        Optional<UserModel> optionalUserModel = userService.getUserById(userId);
        if (optionalUserModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + userId + " not found");
        } else {
            UserModel userModel = optionalUserModel.orElse(null);
            userModel.setUserImageUrl(storageServiceClient.uploadFile(file, storageDirectory).getFile_uri());
            userService.updateUser(userId, userModel);
            return ResponseEntity.ok().body(userDtoMapper.toResponse(userModel));
        }
    }

    @DeleteMapping("/delete-image")
    @Operation(summary = "Delete an image associated with a story", description = "Delete the image associated with a story by providing the image URI and story details.")
    @ApiResponse(responseCode = "200", description = "Image deleted successfully")
    @ApiResponse(responseCode = "404", description = "Story not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<Object> deleteImage(@Parameter(description = "Request body containing story ID and image URI", required = true) @RequestBody UserDeleteRequest userDeleteRequest) {
        Optional<UserModel> optionalUserModel = userService.getUserById(userDeleteRequest.getUser_id());
        if (optionalUserModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with id " + userDeleteRequest.getUser_id() + " not found");
        }
        UserModel userModel = optionalUserModel.orElse(null);
        userModel.setUserImageUrl("DEFAULT");
        userService.updateUser(userDeleteRequest.getUser_id(), userModel);
        try {
            storageServiceClient.deleteFile(new DeleteStorageRequest(userDeleteRequest.getFile_uri(), storageDirectory));
            // Обработка успешного удаления
            return ResponseEntity.ok().build();
        } catch (FeignException.InternalServerError e) {
            // Обработка исключения, которое может возникнуть при вызове deleteFile
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DeleteResponse("the image does not exist or the data was transferred incorrectly"));
        }
    }

    @PostMapping("/distance-goals")
    @Operation(summary = "Add a distance goal to a user", description = "Add a distance goal to a user by their ID")
    @ApiResponse(responseCode = "201", description = "Distance goal added", content = @Content(schema = @Schema(implementation = DistanceGoalModel.class)))
    @ApiResponse(responseCode = "404", description = "User not found")
    public ResponseEntity<DistanceGoalModel> addDistanceGoalToUser(
            @RequestBody @Valid CreateDistanceGoalRequest createDistanceGoalRequest) {
        DistanceGoalModel distanceGoal = userService.addDistanceGoalToUser(createDistanceGoalRequest);
        if (distanceGoal != null) {
            return new ResponseEntity<>(distanceGoal, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/duration-goals")
    @Operation(summary = "Add a duration goal to a user", description = "Add a duration goal to a user by their ID")
    @ApiResponse(responseCode = "201", description = "Duration goal added", content = @Content(schema = @Schema(implementation = DurationGoalModel.class)))
    @ApiResponse(responseCode = "404", description = "User not found")
    public ResponseEntity<DurationGoalModel> addDurationGoalToUser(
            @RequestBody @Valid CreateDurationGoalRequest createDurationGoalRequest) {
        DurationGoalModel durationGoal = userService.addDurationGoalToUser(createDurationGoalRequest);
        if (durationGoal != null) {
            return new ResponseEntity<>(durationGoal, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/weight-goals")
    @Operation(summary = "Add a weight goal to a user", description = "Add a weight goal to a user by their ID")
    @ApiResponse(responseCode = "201", description = "Weight goal added", content = @Content(schema = @Schema(implementation = WeightGoalModel.class)))
    @ApiResponse(responseCode = "404", description = "User not found")
    public ResponseEntity<WeightGoalModel> addWeightGoalToUser(
            @RequestBody @Valid CreateWeightGoalRequest createWeightGoalRequest) {
        WeightGoalModel weightGoal = userService.addWeightGoalToUser(createWeightGoalRequest);
        if (weightGoal != null) {
            return new ResponseEntity<>(weightGoal, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

