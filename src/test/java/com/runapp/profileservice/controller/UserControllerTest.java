package com.runapp.profileservice.controller;

import com.runapp.profileservice.dto.request.UserRequest;
import com.runapp.profileservice.dto.response.UserResponse;
import com.runapp.profileservice.model.UserModel;
import com.runapp.profileservice.service.UserService;
import com.runapp.profileservice.dto.userDtoMapper.UserDtoMapper;
import com.runapp.profileservice.feignClient.StorageServiceClient;
import com.runapp.profileservice.utill.RoleEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserDtoMapper userDtoMapper;

    @Mock
    private StorageServiceClient storageServiceClient;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
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
        ResponseEntity<Object> response = userController.createUser(userRequest, mock(BindingResult.class));

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
    void getUserById_NonExistingUserId_ReturnsNotFound() {
        // Arrange
        int userId = 1;
        when(userService.getUserById(userId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<UserResponse> response = userController.getUserById(userId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
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