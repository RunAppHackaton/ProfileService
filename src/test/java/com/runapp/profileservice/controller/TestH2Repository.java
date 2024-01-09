package com.runapp.profileservice.controller;

import com.runapp.profileservice.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2Repository extends JpaRepository<UserModel, Integer> {
}
