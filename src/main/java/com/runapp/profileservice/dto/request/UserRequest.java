package com.runapp.profileservice.dto.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotEmpty(message = "The 'username' field must not be empty.")
    @Length(min = 3, max = 15, message = "The 'username' length must be between 3 and 15 characters.")
    private String username;

    @NotEmpty(message = "The 'firstName' field must not be empty.")
    @Length(min = 3, max = 15, message = "The 'firstName' length must be between 3 and 15 characters.")
    private String firstName;

    @NotEmpty(message = "The 'lastName' field must not be empty.")
    @Length(min = 3, max = 15, message = "The 'lastName' length must be between 3 and 15 characters.")
    private String lastName;

    @NotEmpty(message = "The 'email' field must not be empty.")
    @Email(message = "Invalid email format.")
    private String email;

    @Past(message = "The creation date must be in the past.")
    private LocalDateTime createDate;

    private String userImageUrl;
}
