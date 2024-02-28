package com.runapp.profileservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.profileservice.dto.request.CreateDistanceGoalRequest;
import com.runapp.profileservice.dto.request.CreateDurationGoalRequest;
import com.runapp.profileservice.dto.request.CreateWeightGoalRequest;
import com.runapp.profileservice.model.DistanceGoalModel;
import com.runapp.profileservice.model.DurationGoalModel;
import com.runapp.profileservice.model.GoalModel;
import com.runapp.profileservice.model.UserModel;
import com.runapp.profileservice.model.WeightGoalModel;
import com.runapp.profileservice.repository.DistanceGoalRepository;
import com.runapp.profileservice.repository.DurationGoalRepository;
import com.runapp.profileservice.repository.GoalRepository;
import com.runapp.profileservice.repository.UserRepository;
import com.runapp.profileservice.repository.WeightGoalRepository;
import com.runapp.profileservice.staticObject.StaticDistanceGoal;
import com.runapp.profileservice.staticObject.StaticGoal;
import com.runapp.profileservice.staticObject.StaticUser;
import com.runapp.profileservice.utill.GoalTypeEnum;
import com.runapp.profileservice.utill.RoleEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceDiffblueTest {
    @MockBean
    private DistanceGoalRepository distanceGoalRepository;

    @MockBean
    private DurationGoalRepository durationGoalRepository;

    @MockBean
    private GoalRepository goalRepository;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @MockBean
    private WeightGoalRepository weightGoalRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    /**
     * Method under test: {@link UserService#createUser(UserModel)}
     */

    @BeforeEach
    void setUp() {
        //sets PasswordEncoder as a BCryptPasswordEncoder *have no idea I have to do that*
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        when(passwordEncoder.encode(Mockito.anyString())).thenAnswer(invocation -> {
            String rawPassword = invocation.getArgument(0);
            return encoder.encode(rawPassword);
        });
    }

    @Test
    void testCreateUser() {
        UserModel userModel = StaticUser.userModel1();
        userModel.setPassword("password");

        // Create a single instance of BCryptPasswordEncoder
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        when(userRepository.save(Mockito.<UserModel>any())).thenReturn(userModel);

        // Act
        UserModel actualCreateUserResult = userService.createUser(userModel);

        // Assert
        assertSame(userModel, actualCreateUserResult);

        // Compare passwords if encoded with BCryptPasswordEncoder
        assertTrue(encoder.matches("password", actualCreateUserResult.getPassword()));


    }

    /**
     * Method under test: {@link UserService#getUserById(int)}
     */
    @Test
    void testGetUserById() {
        UserModel userModel = StaticUser.userModel1();
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Optional<UserModel> actualUserById = userService.getUserById(1);
        verify(userRepository).findById(Mockito.<Integer>any());
        assertTrue(actualUserById.isPresent());
        assertSame(ofResult, actualUserById);
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers() {
        ArrayList<UserModel> userModelList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userModelList);
        List<UserModel> actualAllUsers = userService.getAllUsers();
        verify(userRepository).findAll();
        assertTrue(actualAllUsers.isEmpty());
        assertSame(userModelList, actualAllUsers);
    }

    /**
     * Method under test: {@link UserService#updateUser(int, UserModel)}
     */
    @Test
    void testUpdateUser() {
        UserModel userModel = StaticUser.userModel1();
        userModel.setPassword(passwordEncoder.encode("password"));
        when(userRepository.save(Mockito.<UserModel>any())).thenReturn(userModel);
        when(userRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

        UserModel updatedUser = StaticUser.userModel1();
        updatedUser.setPassword("password");
        UserModel actualUpdateUserResult = userService.updateUser(1, updatedUser);
        verify(userRepository).existsById(Mockito.<Integer>any());
        verify(userRepository).save(Mockito.<UserModel>any());
        assertEquals(1, updatedUser.getId());
        assertSame(userModel, actualUpdateUserResult);

        // Compare passwords if encoded with BCryptPasswordEncoder
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        assertTrue(encoder.matches("password", actualUpdateUserResult.getPassword()));
    }

    /**
     * Method under test: {@link UserService#updateUser(int, UserModel)}
     */
    @Test
    void testUpdateUser2() {
        when(userRepository.existsById(Mockito.<Integer>any())).thenReturn(false);

        UserModel updatedUser = StaticUser.userModel1();
        updatedUser.setPassword("password");
        UserModel actualUpdateUserResult = userService.updateUser(1, updatedUser);
        verify(userRepository).existsById(Mockito.<Integer>any());
        assertNull(actualUpdateUserResult);
    }

    /**
     * Method under test: {@link UserService#deleteUser(int)}
     */
    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(Mockito.<Integer>any());
        userService.deleteUser(1);
        verify(userRepository).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link UserService#addDistanceGoalToUser(CreateDistanceGoalRequest)}
     */
    @Test
    void testAddDistanceGoalToUser() {
        UserModel userModel = StaticUser.userModel1();
        userModel.setPassword("password");
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel13 = StaticGoal.goalModel13();
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        GoalModel goalModel17 = StaticGoal.goalModel17();

        DistanceGoalModel distanceGoalModel = StaticDistanceGoal.distanceGoalModel1();
        distanceGoalModel.setGoalModel(goalModel17);
        distanceGoalModel.setId(1L);
        when(distanceGoalRepository.save(Mockito.<DistanceGoalModel>any())).thenReturn(distanceGoalModel);
        DistanceGoalModel actualAddDistanceGoalToUserResult = userService
                .addDistanceGoalToUser(new CreateDistanceGoalRequest());
        verify(userRepository).findById(Mockito.<Integer>any());
        verify(distanceGoalRepository).save(Mockito.<DistanceGoalModel>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        assertSame(distanceGoalModel, actualAddDistanceGoalToUserResult);
    }

    /**
     * Method under test:
     * {@link UserService#addDurationGoalToUser(CreateDurationGoalRequest)}
     */
    @Test
    void testAddDurationGoalToUser() {
        UserModel userModel = StaticUser.userModel1();
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel13 = StaticGoal.goalModel13();
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        GoalModel goalModel17 = StaticGoal.goalModel17();

        DurationGoalModel durationGoalModel = new DurationGoalModel();
        durationGoalModel.setGoalModel(goalModel17);
        durationGoalModel.setId(1L);
        when(durationGoalRepository.save(Mockito.<DurationGoalModel>any())).thenReturn(durationGoalModel);
        DurationGoalModel actualAddDurationGoalToUserResult = userService
                .addDurationGoalToUser(new CreateDurationGoalRequest());
        verify(userRepository).findById(Mockito.<Integer>any());
        verify(durationGoalRepository).save(Mockito.<DurationGoalModel>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        assertSame(durationGoalModel, actualAddDurationGoalToUserResult);
    }

    /**
     * Method under test:
     * {@link UserService#addWeightGoalToUser(CreateWeightGoalRequest)}
     */
    @Test
    void testAddWeightGoalToUser() {
        UserModel userModel = StaticUser.userModel1();
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel13 = StaticGoal.goalModel13();
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        GoalModel goalModel17 = StaticGoal.goalModel17();

        WeightGoalModel weightGoalModel = new WeightGoalModel();
        weightGoalModel.setCurrentWeight(3);
        weightGoalModel.setGoalModel(goalModel17);
        weightGoalModel.setId(1L);
        weightGoalModel.setTargetWeight(3);
        when(weightGoalRepository.save(Mockito.<WeightGoalModel>any())).thenReturn(weightGoalModel);
        WeightGoalModel actualAddWeightGoalToUserResult = userService.addWeightGoalToUser(new CreateWeightGoalRequest());
        verify(userRepository).findById(Mockito.<Integer>any());
        verify(goalRepository).save(Mockito.<GoalModel>any());
        verify(weightGoalRepository).save(Mockito.<WeightGoalModel>any());
        assertSame(weightGoalModel, actualAddWeightGoalToUserResult);
    }
}
