package com.runapp.profileservice.staticObject;

import com.runapp.profileservice.dto.request.UserRequest;
import com.runapp.profileservice.dto.response.UserResponse;
import com.runapp.profileservice.model.UserModel;
import com.runapp.profileservice.utill.RoleEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class StaticUser {

    public static UserModel userModel1(){
        UserModel userModel = new UserModel();
        userModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel.setEmail("jane.doe@example.org");
        userModel.setFirstName("Jane");
        userModel.setGoalModelList(new ArrayList<>());
        userModel.setId(1);
        userModel.setLastName("Doe");
        userModel.setRole(RoleEnum.GUEST);
        userModel.setUserImageUrl("https://example.org/example");
        userModel.setUsername("janedoe");
        return userModel;
    }

    public static UserRequest invalidUserRequest1(){
        UserRequest userRequest = new UserRequest();

        userRequest.setUsername("1");
        userRequest.setPassword("password123");
        userRequest.setFirstName("Aaaaaaaaaa");
        userRequest.setLastName("Bbbbbbbbb");
        userRequest.setEmail("invalid@gmail.com");
        userRequest.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        return userRequest;
    }

    public static UserRequest userRequest1(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("John Doe");
        userRequest.setPassword("password123");
        userRequest.setFirstName("Aaaaaaaaaa");
        userRequest.setLastName("Bbbbbbbbb");
        userRequest.setEmail("invalid@gmail.com");
        return userRequest;
    }

    public static UserRequest actualUserRequest(){
        UserRequest actualUserRequest = new UserRequest();
        actualUserRequest.setEmail("jane.doe@example.org");
        actualUserRequest.setFirstName("Jane");
        actualUserRequest.setLastName("Doe");
        actualUserRequest.setUserImageUrl("https://example.org/example");
        actualUserRequest.setUsername("janedoe");
        actualUserRequest.setPassword("password");
        return actualUserRequest;
    }

    public static UserResponse actualUserResponse(){
        UserResponse actualUserResponse = new UserResponse();
        actualUserResponse.setEmail("jane.doe@example.org");
        actualUserResponse.setFirstName("Jane");
        actualUserResponse.setId(1);
        actualUserResponse.setLastName("Doe");
        actualUserResponse.setRole(null);
        actualUserResponse.setUserImageUrl("https://example.org/example");
        actualUserResponse.setUsername("janedoe");
        actualUserResponse.setPassword("password");
        return actualUserResponse;
    }

    public static UserRequest userRequest2(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("1");
        userRequest.setPassword("password123");
        userRequest.setFirstName("Aaaaaaaaaa");
        userRequest.setLastName("Bbbbbbbbb");
        userRequest.setEmail("invalid@gmail.com");
        return userRequest;
    }
}
