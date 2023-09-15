package com.runapp.profileservice.service;

import com.runapp.profileservice.repository.UserRepository;
import com.runapp.profileservice.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }
    public Optional<UserModel> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel updateUser(int userId, UserModel updatedUser) {
        if (userRepository.existsById(userId)) {
            updatedUser.setId(userId);
            return userRepository.save(updatedUser);
        } else {
            return null;
        }
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}
