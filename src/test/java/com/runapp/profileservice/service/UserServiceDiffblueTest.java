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
import com.runapp.profileservice.utill.GoalTypeEnum;
import com.runapp.profileservice.utill.RoleEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    /**
     * Method under test: {@link UserService#createUser(UserModel)}
     */
    @Test
    void testCreateUser() {
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
        when(userRepository.save(Mockito.<UserModel>any())).thenReturn(userModel);

        UserModel user = new UserModel();
        user.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setGoalModelList(new ArrayList<>());
        user.setId(1);
        user.setLastName("Doe");
        user.setRole(RoleEnum.GUEST);
        user.setUserImageUrl("https://example.org/example");
        user.setUsername("janedoe");
        UserModel actualCreateUserResult = userService.createUser(user);
        verify(userRepository).save(Mockito.<UserModel>any());
        assertSame(userModel, actualCreateUserResult);
    }

    /**
     * Method under test: {@link UserService#getUserById(int)}
     */
    @Test
    void testGetUserById() {
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
        when(userRepository.save(Mockito.<UserModel>any())).thenReturn(userModel);
        when(userRepository.existsById(Mockito.<Integer>any())).thenReturn(true);

        UserModel updatedUser = new UserModel();
        updatedUser.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        updatedUser.setEmail("jane.doe@example.org");
        updatedUser.setFirstName("Jane");
        updatedUser.setGoalModelList(new ArrayList<>());
        updatedUser.setId(1);
        updatedUser.setLastName("Doe");
        updatedUser.setRole(RoleEnum.GUEST);
        updatedUser.setUserImageUrl("https://example.org/example");
        updatedUser.setUsername("janedoe");
        UserModel actualUpdateUserResult = userService.updateUser(1, updatedUser);
        verify(userRepository).existsById(Mockito.<Integer>any());
        verify(userRepository).save(Mockito.<UserModel>any());
        assertEquals(1, updatedUser.getId());
        assertSame(userModel, actualUpdateUserResult);
    }

    /**
     * Method under test: {@link UserService#updateUser(int, UserModel)}
     */
    @Test
    void testUpdateUser2() {
        when(userRepository.existsById(Mockito.<Integer>any())).thenReturn(false);

        UserModel updatedUser = new UserModel();
        updatedUser.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        updatedUser.setEmail("jane.doe@example.org");
        updatedUser.setFirstName("Jane");
        updatedUser.setGoalModelList(new ArrayList<>());
        updatedUser.setId(1);
        updatedUser.setLastName("Doe");
        updatedUser.setRole(RoleEnum.GUEST);
        updatedUser.setUserImageUrl("https://example.org/example");
        updatedUser.setUsername("janedoe");
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
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(new DistanceGoalModel());
        goalModel.setDurationGoal(new DurationGoalModel());
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(new UserModel());
        goalModel.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(goalModel);
        distanceGoal.setId(1L);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(new DistanceGoalModel());
        goalModel2.setDurationGoal(new DurationGoalModel());
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(new UserModel());
        goalModel2.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(goalModel2);
        durationGoal.setId(1L);

        UserModel user = new UserModel();
        user.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setGoalModelList(new ArrayList<>());
        user.setId(1);
        user.setLastName("Doe");
        user.setRole(RoleEnum.GUEST);
        user.setUserImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(new DistanceGoalModel());
        goalModel3.setDurationGoal(new DurationGoalModel());
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(new UserModel());
        goalModel3.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(goalModel3);
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal);
        goalModel4.setDurationGoal(durationGoal);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user);
        goalModel4.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel4);
        distanceGoal2.setId(1L);

        GoalModel goalModel5 = new GoalModel();
        goalModel5.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDistanceGoal(new DistanceGoalModel());
        goalModel5.setDurationGoal(new DurationGoalModel());
        goalModel5.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel5.setId(1L);
        goalModel5.setUser(new UserModel());
        goalModel5.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(goalModel5);
        distanceGoal3.setId(1L);

        GoalModel goalModel6 = new GoalModel();
        goalModel6.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDistanceGoal(new DistanceGoalModel());
        goalModel6.setDurationGoal(new DurationGoalModel());
        goalModel6.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel6.setId(1L);
        goalModel6.setUser(new UserModel());
        goalModel6.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(goalModel6);
        durationGoal2.setId(1L);

        UserModel user2 = new UserModel();
        user2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setGoalModelList(new ArrayList<>());
        user2.setId(1);
        user2.setLastName("Doe");
        user2.setRole(RoleEnum.GUEST);
        user2.setUserImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        GoalModel goalModel7 = new GoalModel();
        goalModel7.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDistanceGoal(new DistanceGoalModel());
        goalModel7.setDurationGoal(new DurationGoalModel());
        goalModel7.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel7.setId(1L);
        goalModel7.setUser(new UserModel());
        goalModel7.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(goalModel7);
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel8 = new GoalModel();
        goalModel8.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDistanceGoal(distanceGoal3);
        goalModel8.setDurationGoal(durationGoal2);
        goalModel8.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel8.setId(1L);
        goalModel8.setUser(user2);
        goalModel8.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel8);
        durationGoal3.setId(1L);

        UserModel user3 = new UserModel();
        user3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setGoalModelList(new ArrayList<>());
        user3.setId(1);
        user3.setLastName("Doe");
        user3.setRole(RoleEnum.GUEST);
        user3.setUserImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        GoalModel goalModel9 = new GoalModel();
        goalModel9.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDistanceGoal(new DistanceGoalModel());
        goalModel9.setDurationGoal(new DurationGoalModel());
        goalModel9.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel9.setId(1L);
        goalModel9.setUser(new UserModel());
        goalModel9.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(goalModel9);
        distanceGoal4.setId(1L);

        GoalModel goalModel10 = new GoalModel();
        goalModel10.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDistanceGoal(new DistanceGoalModel());
        goalModel10.setDurationGoal(new DurationGoalModel());
        goalModel10.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel10.setId(1L);
        goalModel10.setUser(new UserModel());
        goalModel10.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(goalModel10);
        durationGoal4.setId(1L);

        UserModel user4 = new UserModel();
        user4.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("jane.doe@example.org");
        user4.setFirstName("Jane");
        user4.setGoalModelList(new ArrayList<>());
        user4.setId(1);
        user4.setLastName("Doe");
        user4.setRole(RoleEnum.GUEST);
        user4.setUserImageUrl("https://example.org/example");
        user4.setUsername("janedoe");

        GoalModel goalModel11 = new GoalModel();
        goalModel11.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDistanceGoal(new DistanceGoalModel());
        goalModel11.setDurationGoal(new DurationGoalModel());
        goalModel11.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel11.setId(1L);
        goalModel11.setUser(new UserModel());
        goalModel11.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(goalModel11);
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel12 = new GoalModel();
        goalModel12.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDistanceGoal(distanceGoal4);
        goalModel12.setDurationGoal(durationGoal4);
        goalModel12.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel12.setId(1L);
        goalModel12.setUser(user4);
        goalModel12.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel12);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel13 = new GoalModel();
        goalModel13.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDistanceGoal(distanceGoal2);
        goalModel13.setDurationGoal(durationGoal3);
        goalModel13.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel13.setId(1L);
        goalModel13.setUser(user3);
        goalModel13.setWeightGoal(weightGoal4);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        DistanceGoalModel distanceGoal5 = new DistanceGoalModel();
        distanceGoal5.setDistance(1L);
        distanceGoal5.setGoalModel(new GoalModel());
        distanceGoal5.setId(1L);

        DurationGoalModel durationGoal5 = new DurationGoalModel();
        durationGoal5.setGoalModel(new GoalModel());
        durationGoal5.setId(1L);

        UserModel user5 = new UserModel();
        user5.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user5.setEmail("jane.doe@example.org");
        user5.setFirstName("Jane");
        user5.setGoalModelList(new ArrayList<>());
        user5.setId(1);
        user5.setLastName("Doe");
        user5.setRole(RoleEnum.GUEST);
        user5.setUserImageUrl("https://example.org/example");
        user5.setUsername("janedoe");

        WeightGoalModel weightGoal5 = new WeightGoalModel();
        weightGoal5.setCurrentWeight(3);
        weightGoal5.setGoalModel(new GoalModel());
        weightGoal5.setId(1L);
        weightGoal5.setTargetWeight(3);

        GoalModel goalModel14 = new GoalModel();
        goalModel14.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDistanceGoal(distanceGoal5);
        goalModel14.setDurationGoal(durationGoal5);
        goalModel14.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel14.setId(1L);
        goalModel14.setUser(user5);
        goalModel14.setWeightGoal(weightGoal5);

        DistanceGoalModel distanceGoal6 = new DistanceGoalModel();
        distanceGoal6.setDistance(1L);
        distanceGoal6.setGoalModel(goalModel14);
        distanceGoal6.setId(1L);

        DistanceGoalModel distanceGoal7 = new DistanceGoalModel();
        distanceGoal7.setDistance(1L);
        distanceGoal7.setGoalModel(new GoalModel());
        distanceGoal7.setId(1L);

        DurationGoalModel durationGoal6 = new DurationGoalModel();
        durationGoal6.setGoalModel(new GoalModel());
        durationGoal6.setId(1L);

        UserModel user6 = new UserModel();
        user6.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setGoalModelList(new ArrayList<>());
        user6.setId(1);
        user6.setLastName("Doe");
        user6.setRole(RoleEnum.GUEST);
        user6.setUserImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        WeightGoalModel weightGoal6 = new WeightGoalModel();
        weightGoal6.setCurrentWeight(3);
        weightGoal6.setGoalModel(new GoalModel());
        weightGoal6.setId(1L);
        weightGoal6.setTargetWeight(3);

        GoalModel goalModel15 = new GoalModel();
        goalModel15.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDistanceGoal(distanceGoal7);
        goalModel15.setDurationGoal(durationGoal6);
        goalModel15.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel15.setId(1L);
        goalModel15.setUser(user6);
        goalModel15.setWeightGoal(weightGoal6);

        DurationGoalModel durationGoal7 = new DurationGoalModel();
        durationGoal7.setGoalModel(goalModel15);
        durationGoal7.setId(1L);

        UserModel user7 = new UserModel();
        user7.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user7.setEmail("jane.doe@example.org");
        user7.setFirstName("Jane");
        user7.setGoalModelList(new ArrayList<>());
        user7.setId(1);
        user7.setLastName("Doe");
        user7.setRole(RoleEnum.GUEST);
        user7.setUserImageUrl("https://example.org/example");
        user7.setUsername("janedoe");

        DistanceGoalModel distanceGoal8 = new DistanceGoalModel();
        distanceGoal8.setDistance(1L);
        distanceGoal8.setGoalModel(new GoalModel());
        distanceGoal8.setId(1L);

        DurationGoalModel durationGoal8 = new DurationGoalModel();
        durationGoal8.setGoalModel(new GoalModel());
        durationGoal8.setId(1L);

        UserModel user8 = new UserModel();
        user8.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user8.setEmail("jane.doe@example.org");
        user8.setFirstName("Jane");
        user8.setGoalModelList(new ArrayList<>());
        user8.setId(1);
        user8.setLastName("Doe");
        user8.setRole(RoleEnum.GUEST);
        user8.setUserImageUrl("https://example.org/example");
        user8.setUsername("janedoe");

        WeightGoalModel weightGoal7 = new WeightGoalModel();
        weightGoal7.setCurrentWeight(3);
        weightGoal7.setGoalModel(new GoalModel());
        weightGoal7.setId(1L);
        weightGoal7.setTargetWeight(3);

        GoalModel goalModel16 = new GoalModel();
        goalModel16.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDistanceGoal(distanceGoal8);
        goalModel16.setDurationGoal(durationGoal8);
        goalModel16.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel16.setId(1L);
        goalModel16.setUser(user8);
        goalModel16.setWeightGoal(weightGoal7);

        WeightGoalModel weightGoal8 = new WeightGoalModel();
        weightGoal8.setCurrentWeight(3);
        weightGoal8.setGoalModel(goalModel16);
        weightGoal8.setId(1L);
        weightGoal8.setTargetWeight(3);

        GoalModel goalModel17 = new GoalModel();
        goalModel17.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDistanceGoal(distanceGoal6);
        goalModel17.setDurationGoal(durationGoal7);
        goalModel17.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel17.setId(1L);
        goalModel17.setUser(user7);
        goalModel17.setWeightGoal(weightGoal8);

        DistanceGoalModel distanceGoalModel = new DistanceGoalModel();
        distanceGoalModel.setDistance(1L);
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
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(new DistanceGoalModel());
        goalModel.setDurationGoal(new DurationGoalModel());
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(new UserModel());
        goalModel.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(goalModel);
        distanceGoal.setId(1L);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(new DistanceGoalModel());
        goalModel2.setDurationGoal(new DurationGoalModel());
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(new UserModel());
        goalModel2.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(goalModel2);
        durationGoal.setId(1L);

        UserModel user = new UserModel();
        user.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setGoalModelList(new ArrayList<>());
        user.setId(1);
        user.setLastName("Doe");
        user.setRole(RoleEnum.GUEST);
        user.setUserImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(new DistanceGoalModel());
        goalModel3.setDurationGoal(new DurationGoalModel());
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(new UserModel());
        goalModel3.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(goalModel3);
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal);
        goalModel4.setDurationGoal(durationGoal);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user);
        goalModel4.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel4);
        distanceGoal2.setId(1L);

        GoalModel goalModel5 = new GoalModel();
        goalModel5.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDistanceGoal(new DistanceGoalModel());
        goalModel5.setDurationGoal(new DurationGoalModel());
        goalModel5.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel5.setId(1L);
        goalModel5.setUser(new UserModel());
        goalModel5.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(goalModel5);
        distanceGoal3.setId(1L);

        GoalModel goalModel6 = new GoalModel();
        goalModel6.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDistanceGoal(new DistanceGoalModel());
        goalModel6.setDurationGoal(new DurationGoalModel());
        goalModel6.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel6.setId(1L);
        goalModel6.setUser(new UserModel());
        goalModel6.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(goalModel6);
        durationGoal2.setId(1L);

        UserModel user2 = new UserModel();
        user2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setGoalModelList(new ArrayList<>());
        user2.setId(1);
        user2.setLastName("Doe");
        user2.setRole(RoleEnum.GUEST);
        user2.setUserImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        GoalModel goalModel7 = new GoalModel();
        goalModel7.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDistanceGoal(new DistanceGoalModel());
        goalModel7.setDurationGoal(new DurationGoalModel());
        goalModel7.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel7.setId(1L);
        goalModel7.setUser(new UserModel());
        goalModel7.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(goalModel7);
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel8 = new GoalModel();
        goalModel8.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDistanceGoal(distanceGoal3);
        goalModel8.setDurationGoal(durationGoal2);
        goalModel8.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel8.setId(1L);
        goalModel8.setUser(user2);
        goalModel8.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel8);
        durationGoal3.setId(1L);

        UserModel user3 = new UserModel();
        user3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setGoalModelList(new ArrayList<>());
        user3.setId(1);
        user3.setLastName("Doe");
        user3.setRole(RoleEnum.GUEST);
        user3.setUserImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        GoalModel goalModel9 = new GoalModel();
        goalModel9.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDistanceGoal(new DistanceGoalModel());
        goalModel9.setDurationGoal(new DurationGoalModel());
        goalModel9.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel9.setId(1L);
        goalModel9.setUser(new UserModel());
        goalModel9.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(goalModel9);
        distanceGoal4.setId(1L);

        GoalModel goalModel10 = new GoalModel();
        goalModel10.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDistanceGoal(new DistanceGoalModel());
        goalModel10.setDurationGoal(new DurationGoalModel());
        goalModel10.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel10.setId(1L);
        goalModel10.setUser(new UserModel());
        goalModel10.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(goalModel10);
        durationGoal4.setId(1L);

        UserModel user4 = new UserModel();
        user4.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("jane.doe@example.org");
        user4.setFirstName("Jane");
        user4.setGoalModelList(new ArrayList<>());
        user4.setId(1);
        user4.setLastName("Doe");
        user4.setRole(RoleEnum.GUEST);
        user4.setUserImageUrl("https://example.org/example");
        user4.setUsername("janedoe");

        GoalModel goalModel11 = new GoalModel();
        goalModel11.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDistanceGoal(new DistanceGoalModel());
        goalModel11.setDurationGoal(new DurationGoalModel());
        goalModel11.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel11.setId(1L);
        goalModel11.setUser(new UserModel());
        goalModel11.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(goalModel11);
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel12 = new GoalModel();
        goalModel12.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDistanceGoal(distanceGoal4);
        goalModel12.setDurationGoal(durationGoal4);
        goalModel12.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel12.setId(1L);
        goalModel12.setUser(user4);
        goalModel12.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel12);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel13 = new GoalModel();
        goalModel13.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDistanceGoal(distanceGoal2);
        goalModel13.setDurationGoal(durationGoal3);
        goalModel13.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel13.setId(1L);
        goalModel13.setUser(user3);
        goalModel13.setWeightGoal(weightGoal4);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        DistanceGoalModel distanceGoal5 = new DistanceGoalModel();
        distanceGoal5.setDistance(1L);
        distanceGoal5.setGoalModel(new GoalModel());
        distanceGoal5.setId(1L);

        DurationGoalModel durationGoal5 = new DurationGoalModel();
        durationGoal5.setGoalModel(new GoalModel());
        durationGoal5.setId(1L);

        UserModel user5 = new UserModel();
        user5.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user5.setEmail("jane.doe@example.org");
        user5.setFirstName("Jane");
        user5.setGoalModelList(new ArrayList<>());
        user5.setId(1);
        user5.setLastName("Doe");
        user5.setRole(RoleEnum.GUEST);
        user5.setUserImageUrl("https://example.org/example");
        user5.setUsername("janedoe");

        WeightGoalModel weightGoal5 = new WeightGoalModel();
        weightGoal5.setCurrentWeight(3);
        weightGoal5.setGoalModel(new GoalModel());
        weightGoal5.setId(1L);
        weightGoal5.setTargetWeight(3);

        GoalModel goalModel14 = new GoalModel();
        goalModel14.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDistanceGoal(distanceGoal5);
        goalModel14.setDurationGoal(durationGoal5);
        goalModel14.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel14.setId(1L);
        goalModel14.setUser(user5);
        goalModel14.setWeightGoal(weightGoal5);

        DistanceGoalModel distanceGoal6 = new DistanceGoalModel();
        distanceGoal6.setDistance(1L);
        distanceGoal6.setGoalModel(goalModel14);
        distanceGoal6.setId(1L);

        DistanceGoalModel distanceGoal7 = new DistanceGoalModel();
        distanceGoal7.setDistance(1L);
        distanceGoal7.setGoalModel(new GoalModel());
        distanceGoal7.setId(1L);

        DurationGoalModel durationGoal6 = new DurationGoalModel();
        durationGoal6.setGoalModel(new GoalModel());
        durationGoal6.setId(1L);

        UserModel user6 = new UserModel();
        user6.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setGoalModelList(new ArrayList<>());
        user6.setId(1);
        user6.setLastName("Doe");
        user6.setRole(RoleEnum.GUEST);
        user6.setUserImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        WeightGoalModel weightGoal6 = new WeightGoalModel();
        weightGoal6.setCurrentWeight(3);
        weightGoal6.setGoalModel(new GoalModel());
        weightGoal6.setId(1L);
        weightGoal6.setTargetWeight(3);

        GoalModel goalModel15 = new GoalModel();
        goalModel15.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDistanceGoal(distanceGoal7);
        goalModel15.setDurationGoal(durationGoal6);
        goalModel15.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel15.setId(1L);
        goalModel15.setUser(user6);
        goalModel15.setWeightGoal(weightGoal6);

        DurationGoalModel durationGoal7 = new DurationGoalModel();
        durationGoal7.setGoalModel(goalModel15);
        durationGoal7.setId(1L);

        UserModel user7 = new UserModel();
        user7.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user7.setEmail("jane.doe@example.org");
        user7.setFirstName("Jane");
        user7.setGoalModelList(new ArrayList<>());
        user7.setId(1);
        user7.setLastName("Doe");
        user7.setRole(RoleEnum.GUEST);
        user7.setUserImageUrl("https://example.org/example");
        user7.setUsername("janedoe");

        DistanceGoalModel distanceGoal8 = new DistanceGoalModel();
        distanceGoal8.setDistance(1L);
        distanceGoal8.setGoalModel(new GoalModel());
        distanceGoal8.setId(1L);

        DurationGoalModel durationGoal8 = new DurationGoalModel();
        durationGoal8.setGoalModel(new GoalModel());
        durationGoal8.setId(1L);

        UserModel user8 = new UserModel();
        user8.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user8.setEmail("jane.doe@example.org");
        user8.setFirstName("Jane");
        user8.setGoalModelList(new ArrayList<>());
        user8.setId(1);
        user8.setLastName("Doe");
        user8.setRole(RoleEnum.GUEST);
        user8.setUserImageUrl("https://example.org/example");
        user8.setUsername("janedoe");

        WeightGoalModel weightGoal7 = new WeightGoalModel();
        weightGoal7.setCurrentWeight(3);
        weightGoal7.setGoalModel(new GoalModel());
        weightGoal7.setId(1L);
        weightGoal7.setTargetWeight(3);

        GoalModel goalModel16 = new GoalModel();
        goalModel16.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDistanceGoal(distanceGoal8);
        goalModel16.setDurationGoal(durationGoal8);
        goalModel16.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel16.setId(1L);
        goalModel16.setUser(user8);
        goalModel16.setWeightGoal(weightGoal7);

        WeightGoalModel weightGoal8 = new WeightGoalModel();
        weightGoal8.setCurrentWeight(3);
        weightGoal8.setGoalModel(goalModel16);
        weightGoal8.setId(1L);
        weightGoal8.setTargetWeight(3);

        GoalModel goalModel17 = new GoalModel();
        goalModel17.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDistanceGoal(distanceGoal6);
        goalModel17.setDurationGoal(durationGoal7);
        goalModel17.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel17.setId(1L);
        goalModel17.setUser(user7);
        goalModel17.setWeightGoal(weightGoal8);

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
        Optional<UserModel> ofResult = Optional.of(userModel);
        when(userRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(new DistanceGoalModel());
        goalModel.setDurationGoal(new DurationGoalModel());
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(new UserModel());
        goalModel.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(goalModel);
        distanceGoal.setId(1L);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(new DistanceGoalModel());
        goalModel2.setDurationGoal(new DurationGoalModel());
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(new UserModel());
        goalModel2.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(goalModel2);
        durationGoal.setId(1L);

        UserModel user = new UserModel();
        user.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setGoalModelList(new ArrayList<>());
        user.setId(1);
        user.setLastName("Doe");
        user.setRole(RoleEnum.GUEST);
        user.setUserImageUrl("https://example.org/example");
        user.setUsername("janedoe");

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(new DistanceGoalModel());
        goalModel3.setDurationGoal(new DurationGoalModel());
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(new UserModel());
        goalModel3.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(goalModel3);
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal);
        goalModel4.setDurationGoal(durationGoal);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user);
        goalModel4.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel4);
        distanceGoal2.setId(1L);

        GoalModel goalModel5 = new GoalModel();
        goalModel5.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDistanceGoal(new DistanceGoalModel());
        goalModel5.setDurationGoal(new DurationGoalModel());
        goalModel5.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel5.setId(1L);
        goalModel5.setUser(new UserModel());
        goalModel5.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(goalModel5);
        distanceGoal3.setId(1L);

        GoalModel goalModel6 = new GoalModel();
        goalModel6.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDistanceGoal(new DistanceGoalModel());
        goalModel6.setDurationGoal(new DurationGoalModel());
        goalModel6.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel6.setId(1L);
        goalModel6.setUser(new UserModel());
        goalModel6.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(goalModel6);
        durationGoal2.setId(1L);

        UserModel user2 = new UserModel();
        user2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user2.setEmail("jane.doe@example.org");
        user2.setFirstName("Jane");
        user2.setGoalModelList(new ArrayList<>());
        user2.setId(1);
        user2.setLastName("Doe");
        user2.setRole(RoleEnum.GUEST);
        user2.setUserImageUrl("https://example.org/example");
        user2.setUsername("janedoe");

        GoalModel goalModel7 = new GoalModel();
        goalModel7.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDistanceGoal(new DistanceGoalModel());
        goalModel7.setDurationGoal(new DurationGoalModel());
        goalModel7.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel7.setId(1L);
        goalModel7.setUser(new UserModel());
        goalModel7.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(goalModel7);
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel8 = new GoalModel();
        goalModel8.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDistanceGoal(distanceGoal3);
        goalModel8.setDurationGoal(durationGoal2);
        goalModel8.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel8.setId(1L);
        goalModel8.setUser(user2);
        goalModel8.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel8);
        durationGoal3.setId(1L);

        UserModel user3 = new UserModel();
        user3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user3.setEmail("jane.doe@example.org");
        user3.setFirstName("Jane");
        user3.setGoalModelList(new ArrayList<>());
        user3.setId(1);
        user3.setLastName("Doe");
        user3.setRole(RoleEnum.GUEST);
        user3.setUserImageUrl("https://example.org/example");
        user3.setUsername("janedoe");

        GoalModel goalModel9 = new GoalModel();
        goalModel9.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel9.setDistanceGoal(new DistanceGoalModel());
        goalModel9.setDurationGoal(new DurationGoalModel());
        goalModel9.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel9.setId(1L);
        goalModel9.setUser(new UserModel());
        goalModel9.setWeightGoal(new WeightGoalModel());

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(goalModel9);
        distanceGoal4.setId(1L);

        GoalModel goalModel10 = new GoalModel();
        goalModel10.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel10.setDistanceGoal(new DistanceGoalModel());
        goalModel10.setDurationGoal(new DurationGoalModel());
        goalModel10.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel10.setId(1L);
        goalModel10.setUser(new UserModel());
        goalModel10.setWeightGoal(new WeightGoalModel());

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(goalModel10);
        durationGoal4.setId(1L);

        UserModel user4 = new UserModel();
        user4.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user4.setEmail("jane.doe@example.org");
        user4.setFirstName("Jane");
        user4.setGoalModelList(new ArrayList<>());
        user4.setId(1);
        user4.setLastName("Doe");
        user4.setRole(RoleEnum.GUEST);
        user4.setUserImageUrl("https://example.org/example");
        user4.setUsername("janedoe");

        GoalModel goalModel11 = new GoalModel();
        goalModel11.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel11.setDistanceGoal(new DistanceGoalModel());
        goalModel11.setDurationGoal(new DurationGoalModel());
        goalModel11.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel11.setId(1L);
        goalModel11.setUser(new UserModel());
        goalModel11.setWeightGoal(new WeightGoalModel());

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(goalModel11);
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel12 = new GoalModel();
        goalModel12.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel12.setDistanceGoal(distanceGoal4);
        goalModel12.setDurationGoal(durationGoal4);
        goalModel12.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel12.setId(1L);
        goalModel12.setUser(user4);
        goalModel12.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel12);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel13 = new GoalModel();
        goalModel13.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel13.setDistanceGoal(distanceGoal2);
        goalModel13.setDurationGoal(durationGoal3);
        goalModel13.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel13.setId(1L);
        goalModel13.setUser(user3);
        goalModel13.setWeightGoal(weightGoal4);
        when(goalRepository.save(Mockito.<GoalModel>any())).thenReturn(goalModel13);

        DistanceGoalModel distanceGoal5 = new DistanceGoalModel();
        distanceGoal5.setDistance(1L);
        distanceGoal5.setGoalModel(new GoalModel());
        distanceGoal5.setId(1L);

        DurationGoalModel durationGoal5 = new DurationGoalModel();
        durationGoal5.setGoalModel(new GoalModel());
        durationGoal5.setId(1L);

        UserModel user5 = new UserModel();
        user5.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user5.setEmail("jane.doe@example.org");
        user5.setFirstName("Jane");
        user5.setGoalModelList(new ArrayList<>());
        user5.setId(1);
        user5.setLastName("Doe");
        user5.setRole(RoleEnum.GUEST);
        user5.setUserImageUrl("https://example.org/example");
        user5.setUsername("janedoe");

        WeightGoalModel weightGoal5 = new WeightGoalModel();
        weightGoal5.setCurrentWeight(3);
        weightGoal5.setGoalModel(new GoalModel());
        weightGoal5.setId(1L);
        weightGoal5.setTargetWeight(3);

        GoalModel goalModel14 = new GoalModel();
        goalModel14.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel14.setDistanceGoal(distanceGoal5);
        goalModel14.setDurationGoal(durationGoal5);
        goalModel14.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel14.setId(1L);
        goalModel14.setUser(user5);
        goalModel14.setWeightGoal(weightGoal5);

        DistanceGoalModel distanceGoal6 = new DistanceGoalModel();
        distanceGoal6.setDistance(1L);
        distanceGoal6.setGoalModel(goalModel14);
        distanceGoal6.setId(1L);

        DistanceGoalModel distanceGoal7 = new DistanceGoalModel();
        distanceGoal7.setDistance(1L);
        distanceGoal7.setGoalModel(new GoalModel());
        distanceGoal7.setId(1L);

        DurationGoalModel durationGoal6 = new DurationGoalModel();
        durationGoal6.setGoalModel(new GoalModel());
        durationGoal6.setId(1L);

        UserModel user6 = new UserModel();
        user6.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user6.setEmail("jane.doe@example.org");
        user6.setFirstName("Jane");
        user6.setGoalModelList(new ArrayList<>());
        user6.setId(1);
        user6.setLastName("Doe");
        user6.setRole(RoleEnum.GUEST);
        user6.setUserImageUrl("https://example.org/example");
        user6.setUsername("janedoe");

        WeightGoalModel weightGoal6 = new WeightGoalModel();
        weightGoal6.setCurrentWeight(3);
        weightGoal6.setGoalModel(new GoalModel());
        weightGoal6.setId(1L);
        weightGoal6.setTargetWeight(3);

        GoalModel goalModel15 = new GoalModel();
        goalModel15.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel15.setDistanceGoal(distanceGoal7);
        goalModel15.setDurationGoal(durationGoal6);
        goalModel15.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel15.setId(1L);
        goalModel15.setUser(user6);
        goalModel15.setWeightGoal(weightGoal6);

        DurationGoalModel durationGoal7 = new DurationGoalModel();
        durationGoal7.setGoalModel(goalModel15);
        durationGoal7.setId(1L);

        UserModel user7 = new UserModel();
        user7.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user7.setEmail("jane.doe@example.org");
        user7.setFirstName("Jane");
        user7.setGoalModelList(new ArrayList<>());
        user7.setId(1);
        user7.setLastName("Doe");
        user7.setRole(RoleEnum.GUEST);
        user7.setUserImageUrl("https://example.org/example");
        user7.setUsername("janedoe");

        DistanceGoalModel distanceGoal8 = new DistanceGoalModel();
        distanceGoal8.setDistance(1L);
        distanceGoal8.setGoalModel(new GoalModel());
        distanceGoal8.setId(1L);

        DurationGoalModel durationGoal8 = new DurationGoalModel();
        durationGoal8.setGoalModel(new GoalModel());
        durationGoal8.setId(1L);

        UserModel user8 = new UserModel();
        user8.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        user8.setEmail("jane.doe@example.org");
        user8.setFirstName("Jane");
        user8.setGoalModelList(new ArrayList<>());
        user8.setId(1);
        user8.setLastName("Doe");
        user8.setRole(RoleEnum.GUEST);
        user8.setUserImageUrl("https://example.org/example");
        user8.setUsername("janedoe");

        WeightGoalModel weightGoal7 = new WeightGoalModel();
        weightGoal7.setCurrentWeight(3);
        weightGoal7.setGoalModel(new GoalModel());
        weightGoal7.setId(1L);
        weightGoal7.setTargetWeight(3);

        GoalModel goalModel16 = new GoalModel();
        goalModel16.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel16.setDistanceGoal(distanceGoal8);
        goalModel16.setDurationGoal(durationGoal8);
        goalModel16.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel16.setId(1L);
        goalModel16.setUser(user8);
        goalModel16.setWeightGoal(weightGoal7);

        WeightGoalModel weightGoal8 = new WeightGoalModel();
        weightGoal8.setCurrentWeight(3);
        weightGoal8.setGoalModel(goalModel16);
        weightGoal8.setId(1L);
        weightGoal8.setTargetWeight(3);

        GoalModel goalModel17 = new GoalModel();
        goalModel17.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel17.setDistanceGoal(distanceGoal6);
        goalModel17.setDurationGoal(durationGoal7);
        goalModel17.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel17.setId(1L);
        goalModel17.setUser(user7);
        goalModel17.setWeightGoal(weightGoal8);

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
