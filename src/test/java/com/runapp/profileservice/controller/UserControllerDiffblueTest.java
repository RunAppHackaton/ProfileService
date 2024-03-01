package com.runapp.profileservice.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.profileservice.dto.request.*;
import com.runapp.profileservice.dto.response.UserResponse;
import com.runapp.profileservice.dto.userDtoMapper.UserDtoMapper;
import com.runapp.profileservice.exceptions.GlobalExceptionHandler;
import com.runapp.profileservice.feignClient.StorageServiceClient;
import com.runapp.profileservice.model.*;
import com.runapp.profileservice.repository.*;
import com.runapp.profileservice.service.UserService;
import com.runapp.profileservice.staticObject.StaticDistanceGoal;
import com.runapp.profileservice.staticObject.StaticGoal;
import com.runapp.profileservice.staticObject.StaticUser;
import com.runapp.profileservice.staticObject.StaticWeightGoal;
import com.runapp.profileservice.utill.GoalTypeEnum;
import com.runapp.profileservice.utill.RoleEnum;
import feign.FeignException;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = {UserController.class})
@WebMvcTest(UserController.class)
@ExtendWith(SpringExtension.class)
class UserControllerDiffblueTest {
    @MockBean
    private StorageServiceClient storageServiceClient;

    @Autowired
    private UserController userController;

    @MockBean
    private UserDtoMapper userDtoMapper;

    @MockBean
    private UserService userService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;
    private MockMvc mockMvc;
    @MockBean
    private UserRepository userRepository;
    @BeforeEach
    void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }
    @Test
    void testCreateUser() {
        UserModel userModel = StaticUser.userModel1();
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.save(Mockito.<UserModel>any())).thenReturn(userModel);
        UserService userService = new UserService(userRepository, mock(GoalRepository.class),
                mock(DistanceGoalRepository.class), mock(DurationGoalRepository.class), mock(WeightGoalRepository.class), passwordEncoder);

        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        UserRequest userRequest = new UserRequest();
        ResponseEntity<Object> actualCreateUserResult = userController.createUser(userRequest);
        verify(userRepository).save(Mockito.<UserModel>any());
        assertTrue(((UserResponse) actualCreateUserResult.getBody()).getRole() instanceof RoleEnum);
        assertEquals("00:00", ((UserResponse) actualCreateUserResult.getBody()).getCreateDate().toLocalTime().toString());
        assertEquals("Doe", ((UserResponse) actualCreateUserResult.getBody()).getLastName());
        assertEquals("Jane", ((UserResponse) actualCreateUserResult.getBody()).getFirstName());
        assertEquals("https://example.org/example", ((UserResponse) actualCreateUserResult.getBody()).getUserImageUrl());
        assertEquals("jane.doe@example.org", ((UserResponse) actualCreateUserResult.getBody()).getEmail());
        assertEquals("janedoe", ((UserResponse) actualCreateUserResult.getBody()).getUsername());
        assertEquals(1, ((UserResponse) actualCreateUserResult.getBody()).getId());
        assertEquals(201, actualCreateUserResult.getStatusCodeValue());
        assertTrue(actualCreateUserResult.hasBody());
        assertTrue(actualCreateUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link UserController#createUser(UserRequest, BindingResult)}
     */
    @Test
    void testCreateUser2() {
        UserModel userModel = StaticUser.userModel1();
        UserService userService = mock(UserService.class);
        when(userService.createUser(Mockito.<UserModel>any())).thenReturn(userModel);
        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        UserRequest userRequest = new UserRequest();
        ResponseEntity<Object> actualCreateUserResult = userController.createUser(userRequest);
        verify(userService).createUser(Mockito.<UserModel>any());
        assertTrue(((UserResponse) actualCreateUserResult.getBody()).getRole() instanceof RoleEnum);
        assertEquals("00:00", ((UserResponse) actualCreateUserResult.getBody()).getCreateDate().toLocalTime().toString());
        assertEquals("Doe", ((UserResponse) actualCreateUserResult.getBody()).getLastName());
        assertEquals("Jane", ((UserResponse) actualCreateUserResult.getBody()).getFirstName());
        assertEquals("https://example.org/example", ((UserResponse) actualCreateUserResult.getBody()).getUserImageUrl());
        assertEquals("jane.doe@example.org", ((UserResponse) actualCreateUserResult.getBody()).getEmail());
        assertEquals("janedoe", ((UserResponse) actualCreateUserResult.getBody()).getUsername());
        assertEquals(1, ((UserResponse) actualCreateUserResult.getBody()).getId());
        assertEquals(201, actualCreateUserResult.getStatusCodeValue());
        assertTrue(actualCreateUserResult.hasBody());
        assertTrue(actualCreateUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link UserController#createUser(UserRequest, BindingResult)}
     */
    @Test
    void testCreateUser3() {

        UserModel userModel = StaticUser.userModel1();
        UserService userService = mock(UserService.class);
        when(userService.createUser(Mockito.<UserModel>any())).thenReturn(userModel);

        UserModel userModel2 = StaticUser.userModel1();
        UserDtoMapper userDtoMapper = mock(UserDtoMapper.class);
        when(userDtoMapper.toResponse(Mockito.<UserModel>any())).thenReturn(new UserResponse());
        when(userDtoMapper.toModel(Mockito.<UserRequest>any())).thenReturn(userModel2);
        UserController userController = new UserController(userService, userDtoMapper, storageServiceClient);
        UserRequest userRequest = new UserRequest();
        ResponseEntity<Object> actualCreateUserResult = userController.createUser(userRequest);
        verify(userDtoMapper).toModel(Mockito.<UserRequest>any());
        verify(userDtoMapper).toResponse(Mockito.<UserModel>any());
        verify(userService).createUser(Mockito.<UserModel>any());
        assertEquals(201, actualCreateUserResult.getStatusCodeValue());
        assertTrue(actualCreateUserResult.hasBody());
        assertTrue(actualCreateUserResult.getHeaders().isEmpty());
    }
    /**
     * Method under test:
     * {@link UserController#createUser(UserRequest, BindingResult)}
     */
    @Test
    void testCreateUser4() throws Exception {

        UserController userController = new UserController(mock(UserService.class), mock(UserDtoMapper.class), storageServiceClient);
        UserRequest userRequest = StaticUser.userRequest1();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        // Perform the request and assert the response
        mockMvc.perform(post("/users/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    /**
     * Method under test: {@link UserController#getUserById(int)}
     */
    @Test
    void testGetUserById() throws Exception {
        UserModel userModel = StaticUser.userModel1();
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(userService.getUserById(anyInt())).thenReturn(ofResult);
        when(userDtoMapper.toResponse(Mockito.<UserModel>any())).thenReturn(new UserResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}", 1);
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content()
                        .string(
                                "{\"id\":0,\"username\":null,\"password\":null,\"firstName\":null,\"lastName\":null,\"role\":null,\"email\":null,\"createDate\":null,"
                                        + "\"userImageUrl\":null}"));
    }

    /**
     * Method under test: {@link UserController#getUserById(int)}
     */
    @Test
    void testGetUserById2() throws Exception {
        Optional<UserModel> emptyResult = Optional.empty();
        when(userService.getUserById(anyInt())).thenReturn(emptyResult);
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(userDtoMapper.toResponse(Mockito.<UserModel>any())).thenThrow(feignException);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users/{userId}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(new GlobalExceptionHandler()).build().perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound());
    }

    /**
     * Method under test: {@link UserController#getAllUsers()}
     */
    @Test
    void testGetAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");
        MockMvcBuilders.standaloneSetup(userController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string("[]"));
    }

    @Test
    public void testUpdateUser_ValidRequest() throws Exception {
        int userId = 1;

        // Mock the behavior of userService.updateUser
        UserModel updatedUser = StaticUser.userModel1();
        updatedUser.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        Mockito.when(userService.updateUser(userId, userDtoMapper.toModel(Mockito.any(UserRequest.class))))
                .thenReturn(updatedUser);

        UserRequest userRequest = StaticUser.userRequest1();
        // Populate other fields as needed
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        // Perform the request and assert the response
        mockMvc.perform(put("/users/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUser_UserNotFound() throws Exception {
        int userId = 1;

        // Mock the behavior of userService.updateUser when the user is not found
        Mockito.when(userService.updateUser(userId, userDtoMapper.toModel(Mockito.any(UserRequest.class))))
                .thenReturn(null);

        // Prepare a valid UserRequest
        UserRequest userRequest = StaticUser.userRequest1();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        // Perform the request and assert the response
        mockMvc.perform(put("/users/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userRequest)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateUser_InvalidRequest() throws Exception {
        int userId = 1;
        UserRequest invalidUserRequest = StaticUser.invalidUserRequest1();

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
        // Perform the request and assert the response
        mockMvc.perform(put("/users/{userId}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidUserRequest)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].defaultMessage", containsString("The 'username' length must be between 3 and 15 characters.")));
    }

    /**
     * Method under test: {@link UserController#deleteUser(int)}
     */
    @Test
    void testDeleteUser() throws Exception {
        UserModel userModel = StaticUser.userModel1();
        Optional<UserModel> ofResult = Optional.of(userModel);
        doNothing().when(userService).deleteUser(anyInt());
        when(userService.getUserById(anyInt())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/{userId}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController).build().perform(requestBuilder);
        actualPerformResult.andExpect(status().isNoContent());
    }

    /**
     * Method under test: {@link UserController#deleteUser(int)}
     */
    @Test
    void testDeleteUser2() throws Exception {
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        doThrow(feignException).when(userService).deleteUser(anyInt());
        Optional<UserModel> emptyResult = Optional.empty();
        when(userService.getUserById(anyInt())).thenReturn(emptyResult);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/{userId}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound());
    }

    /**
     * Method under test: {@link UserController#uploadImage(MultipartFile, int)}
     */
    @Test
    void testUploadImage() throws Exception {
        // Mock the behavior when findById is called
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        // Perform the request
        mockMvc.perform(multipart("/users/{userId}/upload-image", 1)
                        .file(new MockMultipartFile("file", "Name", "text/plain", "AXAXAXAX".getBytes())))
                .andExpect(status().isNotFound());
        // Ensure that save is not called
        verify(userRepository, never()).save(any(UserModel.class));
    }

    /**
     * Method under test:
     * {@link UserController#addDistanceGoalToUser(CreateDistanceGoalRequest)}
     */
    @Test
    void testAddDistanceGoalToUser() {
        UserModel userModel = StaticUser.userModel1();
        Optional<UserModel> ofResult = Optional.of(userModel);
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel13 = StaticGoal.goalModel13();

        GoalRepository goalRepository = mock(GoalRepository.class);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        GoalModel goalModel17 = StaticGoal.goalModel17();

        DistanceGoalModel distanceGoalModel = StaticDistanceGoal.distanceGoalModel1();
        distanceGoalModel.setGoalModel(goalModel17);

        DistanceGoalRepository distanceGoalRepository = mock(DistanceGoalRepository.class);
        when(distanceGoalRepository.save(Mockito.<DistanceGoalModel>any())).thenReturn(distanceGoalModel);
        UserService userService = new UserService(userRepository, goalRepository, distanceGoalRepository,
                mock(DurationGoalRepository.class), mock(WeightGoalRepository.class), passwordEncoder);

        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        ResponseEntity<DistanceGoalModel> actualAddDistanceGoalToUserResult = userController
                .addDistanceGoalToUser(new CreateDistanceGoalRequest());
        verify(userRepository).findById(Mockito.<Integer>any());
        verify(distanceGoalRepository).save(Mockito.<DistanceGoalModel>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        assertEquals(201, actualAddDistanceGoalToUserResult.getStatusCodeValue());
        assertTrue(actualAddDistanceGoalToUserResult.hasBody());
        assertTrue(actualAddDistanceGoalToUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link UserController#addDurationGoalToUser(CreateDurationGoalRequest)}
     */
    @Test
    void testAddDurationGoalToUser() {
        UserModel userModel = StaticUser.userModel1();
        Optional<UserModel> ofResult = Optional.of(userModel);
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel13 = StaticGoal.goalModel13();
        GoalRepository goalRepository = mock(GoalRepository.class);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        GoalModel goalModel17 = StaticGoal.goalModel17();

        DurationGoalModel durationGoalModel = new DurationGoalModel();
        durationGoalModel.setGoalModel(goalModel17);
        durationGoalModel.setId(1L);
        DurationGoalRepository durationGoalRepository = mock(DurationGoalRepository.class);
        when(durationGoalRepository.save(Mockito.<DurationGoalModel>any())).thenReturn(durationGoalModel);
        UserService userService = new UserService(userRepository, goalRepository, mock(DistanceGoalRepository.class),
                durationGoalRepository, mock(WeightGoalRepository.class), passwordEncoder);

        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        ResponseEntity<DurationGoalModel> actualAddDurationGoalToUserResult = userController
                .addDurationGoalToUser(new CreateDurationGoalRequest());
        verify(userRepository).findById(Mockito.<Integer>any());
        verify(durationGoalRepository).save(Mockito.<DurationGoalModel>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        assertEquals(201, actualAddDurationGoalToUserResult.getStatusCodeValue());
        assertTrue(actualAddDurationGoalToUserResult.hasBody());
        assertTrue(actualAddDurationGoalToUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link UserController#addWeightGoalToUser(CreateWeightGoalRequest)}
     */
    @Test
    void testAddWeightGoalToUser() {
        UserModel userModel = StaticUser.userModel1();
        Optional<UserModel> ofResult = Optional.of(userModel);
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel13 = StaticGoal.goalModel13();
        GoalRepository goalRepository = mock(GoalRepository.class);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);


        GoalModel goalModel17 = StaticGoal.goalModel17();

        WeightGoalModel weightGoalModel = StaticWeightGoal.weightGoalModel1();
        weightGoalModel.setGoalModel(goalModel17);
        WeightGoalRepository weightGoalRepository = mock(WeightGoalRepository.class);
        when(weightGoalRepository.save(Mockito.<WeightGoalModel>any())).thenReturn(weightGoalModel);
        UserService userService = new UserService(userRepository, goalRepository, mock(DistanceGoalRepository.class),
                mock(DurationGoalRepository.class), weightGoalRepository, passwordEncoder);

        UserController userController = new UserController(userService, new UserDtoMapper(), storageServiceClient);
        ResponseEntity<WeightGoalModel> actualAddWeightGoalToUserResult = userController
                .addWeightGoalToUser(new CreateWeightGoalRequest());
        verify(userRepository).findById(Mockito.<Integer>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        verify(weightGoalRepository).save(Mockito.<WeightGoalModel>any());
        assertEquals(201, actualAddWeightGoalToUserResult.getStatusCodeValue());
        assertTrue(actualAddWeightGoalToUserResult.hasBody());
        assertTrue(actualAddWeightGoalToUserResult.getHeaders().isEmpty());
    }

    /**
     * Method under test: {@link UserController#deleteImage(UserDeleteRequest)}
     */
    @Test
    void testDeleteImage() throws Exception {
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(storageServiceClient.deleteFile(Mockito.<DeleteStorageRequest>any())).thenThrow(feignException);
        FeignException feignException2 = mock(FeignException.class);
        when(feignException2.getCause()).thenReturn(new Throwable());
        when(userService.updateUser(anyInt(), Mockito.<UserModel>any())).thenThrow(feignException2);
        Optional<UserModel> emptyResult = Optional.empty();
        when(userService.getUserById(anyInt())).thenReturn(emptyResult);

        UserDeleteRequest userDeleteRequest = new UserDeleteRequest();
        userDeleteRequest.setFile_uri("File uri");
        userDeleteRequest.setUser_id(1);
        String content = (new ObjectMapper()).writeValueAsString(userDeleteRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/users/delete-image")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = mockMvc.perform(requestBuilder);
        actualPerformResult.andExpect(status().isNotFound())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("User with id 1 not found"));
    }
}
