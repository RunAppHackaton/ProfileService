package com.runapp.profileservice.controller;

import com.runapp.profileservice.dto.request.UserRequest;
import com.runapp.profileservice.dto.response.UserResponse;
import com.runapp.profileservice.dto.userDtoMapper.UserDtoMapper;
import com.runapp.profileservice.exceptions.GlobalExceptionHandler;
import com.runapp.profileservice.feignClient.StorageServiceClient;
import com.runapp.profileservice.model.UserModel;
import com.runapp.profileservice.service.UserService;
import com.runapp.profileservice.utill.RoleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.ResponseActions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Optional;

import static jakarta.ws.rs.core.Response.status;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserDtoMapper userDtoMapper;

    @Mock
    private StorageServiceClient storageServiceClient;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void createUser_ValidUserRequest_ReturnsCreatedUserResponse() {
        // Arrange
        UserRequest userRequest = getTestUserRequest();
        UserModel userModel = getTestUserModel();
        UserResponse userResponse = getTestUserResponse();
        when(userDtoMapper.toModel(userRequest)).thenReturn(userModel);
        when(userService.createUser(userModel)).thenReturn(userModel);
        when(userDtoMapper.toResponse(userModel)).thenReturn(userResponse);

        // Act
        ResponseEntity<Object> response = userController.createUser(userRequest);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(userResponse, response.getBody());
    }

    @Test
    void getUserById_ExistingUserId_ReturnsUserResponse() {
        // Arrange
        int userId = 1;
        UserModel userModel = new UserModel();
        UserResponse userResponse = new UserResponse();
        when(userService.getUserById(userId)).thenReturn(Optional.of(userModel));
        when(userDtoMapper.toResponse(userModel)).thenReturn(userResponse);

        // Act
        ResponseEntity<UserResponse> response = userController.getUserById(userId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResponse, response.getBody());
    }

    @Test
    void getUserById_NonExistingUserId_ReturnsNotFound() throws Exception {
        // Arrange
        int userId = 1;
        when(userService.getUserById(userId)).thenReturn(Optional.empty());
        // Act
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/users/1"));
        resultActions.andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    UserRequest getTestUserRequest(){
        return new UserRequest("Jack", "password123", "Jackson", "Doe", "jackmail@gmail.com", LocalDateTime.of(2022, 1, 1, 12, 30), "something");
    }
    UserResponse getTestUserResponse(){
        return new UserResponse(1, "Jack", "password123", "Jackson", "Doe", RoleEnum.USER,"jackmail@gmail.com", LocalDateTime.of(2022, 1, 1, 12, 30), "something");
    }
    UserModel getTestUserModel(){
        return new UserModel(1, "Jack", "password123", "Jackson", "Doe", RoleEnum.USER, "jackmail@gmail.com", LocalDateTime.of(2022, 1, 1, 12, 30), "something", null);
    }
}