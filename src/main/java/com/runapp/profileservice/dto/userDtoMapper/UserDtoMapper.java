package com.runapp.profileservice.dto.userDtoMapper;

import com.runapp.profileservice.dto.request.UserRequest;
import com.runapp.profileservice.dto.response.UserResponse;
import com.runapp.profileservice.model.UserModel;
import com.runapp.profileservice.utill.RoleEnum;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {

    public UserModel toModel(UserRequest userRequest) {
        UserModel userModel = new UserModel();
        userModel.setUsername(userRequest.getUsername());
        userModel.setFirstName(userModel.getFirstName());
        userModel.setLastName(userRequest.getLastName());
        userModel.setEmail(userRequest.getEmail());
        userModel.setCreateDate(userRequest.getCreateDate());
        userModel.setUserImageUrl("DEFAULT");
        userModel.setRole(RoleEnum.USER);
        return userModel;
    }

    public UserResponse toResponse(UserModel userModel) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userModel.getId());
        userResponse.setUsername(userModel.getUsername());
        userResponse.setFirstName(userModel.getFirstName());
        userResponse.setLastName(userModel.getLastName());
        userResponse.setRole(userModel.getRole());
        userResponse.setEmail(userModel.getEmail());
        userResponse.setCreateDate(userModel.getCreateDate());
        userResponse.setUserImageUrl(userModel.getUserImageUrl());
        return userResponse;
    }
}
