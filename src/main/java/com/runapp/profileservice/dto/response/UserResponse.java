package com.runapp.profileservice.dto.response;

import com.runapp.profileservice.utill.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private Enum<RoleEnum> role;
    private String email;
    private LocalDateTime createDate;
    private String userImageUrl;
}
