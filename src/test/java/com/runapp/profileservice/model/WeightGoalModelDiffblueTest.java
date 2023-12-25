package com.runapp.profileservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.runapp.profileservice.utill.GoalTypeEnum;
import com.runapp.profileservice.utill.RoleEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {WeightGoalModel.class})
@ExtendWith(SpringExtension.class)
class WeightGoalModelDiffblueTest {
    @Autowired
    private WeightGoalModel weightGoalModel;

    /**
     * Method under test: {@link WeightGoalModel#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new WeightGoalModel()).canEqual("Other"));
    }

    /**
     * Method under test: {@link WeightGoalModel#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        WeightGoalModel weightGoalModel2 = new WeightGoalModel();

        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(3L);
        distanceGoal.setGoalModel(new GoalModel());
        distanceGoal.setId(1L);

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(new GoalModel());
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(distanceGoal);
        goalModel.setDurationGoal(durationGoal);
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(user);
        goalModel.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(3L);
        distanceGoal2.setGoalModel(goalModel);
        distanceGoal2.setId(1L);

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(3L);
        distanceGoal3.setGoalModel(new GoalModel());
        distanceGoal3.setId(1L);

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(new GoalModel());
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(distanceGoal3);
        goalModel2.setDurationGoal(durationGoal2);
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(user2);
        goalModel2.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel2);
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

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(3L);
        distanceGoal4.setGoalModel(new GoalModel());
        distanceGoal4.setId(1L);

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(new GoalModel());
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(distanceGoal4);
        goalModel3.setDurationGoal(durationGoal4);
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(user4);
        goalModel3.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel3);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal2);
        goalModel4.setDurationGoal(durationGoal3);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user3);
        goalModel4.setWeightGoal(weightGoal4);

        WeightGoalModel weightGoalModel3 = new WeightGoalModel();
        weightGoalModel3.setCurrentWeight(3);
        weightGoalModel3.setGoalModel(goalModel4);
        weightGoalModel3.setId(1L);
        weightGoalModel3.setTargetWeight(3);
        assertTrue(weightGoalModel2.canEqual(weightGoalModel3));
    }

    /**
     * Method under test: {@link WeightGoalModel#canEqual(Object)}
     */
    @Test
    void testCanEqual3() {
        WeightGoalModel weightGoalModel2 = new WeightGoalModel();

        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(3L);
        distanceGoal.setGoalModel(new GoalModel());
        distanceGoal.setId(1L);

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(new GoalModel());
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(distanceGoal);
        goalModel.setDurationGoal(durationGoal);
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(user);
        goalModel.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(3L);
        distanceGoal2.setGoalModel(goalModel);
        distanceGoal2.setId(1L);

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(3L);
        distanceGoal3.setGoalModel(new GoalModel());
        distanceGoal3.setId(1L);

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(new GoalModel());
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(distanceGoal3);
        goalModel2.setDurationGoal(durationGoal2);
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(user2);
        goalModel2.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel2);
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

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(3L);
        distanceGoal4.setGoalModel(new GoalModel());
        distanceGoal4.setId(1L);

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(new GoalModel());
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(distanceGoal4);
        goalModel3.setDurationGoal(durationGoal4);
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(user4);
        goalModel3.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel3);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);
        GoalModel goalModel4 = mock(GoalModel.class);
        doNothing().when(goalModel4).setDateStart(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel4).setDateStop(Mockito.<LocalDateTime>any());
        doNothing().when(goalModel4).setDistanceGoal(Mockito.<DistanceGoalModel>any());
        doNothing().when(goalModel4).setDurationGoal(Mockito.<DurationGoalModel>any());
        doNothing().when(goalModel4).setGoalTypeEnum(Mockito.<GoalTypeEnum>any());
        doNothing().when(goalModel4).setId(Mockito.<Long>any());
        doNothing().when(goalModel4).setUser(Mockito.<UserModel>any());
        doNothing().when(goalModel4).setWeightGoal(Mockito.<WeightGoalModel>any());
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal2);
        goalModel4.setDurationGoal(durationGoal3);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user3);
        goalModel4.setWeightGoal(weightGoal4);

        WeightGoalModel weightGoalModel3 = new WeightGoalModel();
        weightGoalModel3.setCurrentWeight(3);
        weightGoalModel3.setGoalModel(goalModel4);
        weightGoalModel3.setId(1L);
        weightGoalModel3.setTargetWeight(3);
        boolean actualCanEqualResult = weightGoalModel2.canEqual(weightGoalModel3);
        verify(goalModel4).setDateStart(Mockito.<LocalDateTime>any());
        verify(goalModel4).setDateStop(Mockito.<LocalDateTime>any());
        verify(goalModel4).setDistanceGoal(Mockito.<DistanceGoalModel>any());
        verify(goalModel4).setDurationGoal(Mockito.<DurationGoalModel>any());
        verify(goalModel4).setGoalTypeEnum(Mockito.<GoalTypeEnum>any());
        verify(goalModel4).setId(Mockito.<Long>any());
        verify(goalModel4).setUser(Mockito.<UserModel>any());
        verify(goalModel4).setWeightGoal(Mockito.<WeightGoalModel>any());
        assertTrue(actualCanEqualResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link WeightGoalModel#WeightGoalModel()}
     *   <li>{@link WeightGoalModel#setCurrentWeight(Integer)}
     *   <li>{@link WeightGoalModel#setGoalModel(GoalModel)}
     *   <li>{@link WeightGoalModel#setId(Long)}
     *   <li>{@link WeightGoalModel#setTargetWeight(Integer)}
     *   <li>{@link WeightGoalModel#toString()}
     *   <li>{@link WeightGoalModel#getCurrentWeight()}
     *   <li>{@link WeightGoalModel#getGoalModel()}
     *   <li>{@link WeightGoalModel#getId()}
     *   <li>{@link WeightGoalModel#getTargetWeight()}
     * </ul>
     */
    @Test
    void testConstructor() {
        WeightGoalModel actualWeightGoalModel = new WeightGoalModel();
        actualWeightGoalModel.setCurrentWeight(3);
        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(new GoalModel());
        distanceGoal.setId(1L);
        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(new GoalModel());
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
        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(new GoalModel());
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);
        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(distanceGoal);
        goalModel.setDurationGoal(durationGoal);
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(user);
        goalModel.setWeightGoal(weightGoal);
        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel);
        distanceGoal2.setId(1L);
        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(new GoalModel());
        distanceGoal3.setId(1L);
        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(new GoalModel());
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
        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(new GoalModel());
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);
        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(distanceGoal3);
        goalModel2.setDurationGoal(durationGoal2);
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(user2);
        goalModel2.setWeightGoal(weightGoal2);
        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel2);
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
        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(new GoalModel());
        distanceGoal4.setId(1L);
        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(new GoalModel());
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
        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(new GoalModel());
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);
        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(distanceGoal4);
        goalModel3.setDurationGoal(durationGoal4);
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(user4);
        goalModel3.setWeightGoal(weightGoal3);
        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel3);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);
        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal2);
        goalModel4.setDurationGoal(durationGoal3);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user3);
        goalModel4.setWeightGoal(weightGoal4);
        actualWeightGoalModel.setGoalModel(goalModel4);
        actualWeightGoalModel.setId(1L);
        actualWeightGoalModel.setTargetWeight(3);
        String actualToStringResult = actualWeightGoalModel.toString();
        Integer actualCurrentWeight = actualWeightGoalModel.getCurrentWeight();
        GoalModel actualGoalModel = actualWeightGoalModel.getGoalModel();
        Long actualId = actualWeightGoalModel.getId();
        Integer actualTargetWeight = actualWeightGoalModel.getTargetWeight();
        assertEquals(
                "WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=1, dateStart=1970-01-01T00:00,"
                        + " dateStop=1970-01-01T00:00, goalTypeEnum=DISTANCE_GOAL, distanceGoal=DistanceGoalModel(id=1, distance=1,"
                        + " goalModel=GoalModel(id=1, dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00, goalTypeEnum=DISTANCE_GOAL,"
                        + " distanceGoal=DistanceGoalModel(id=1, distance=1, goalModel=GoalModel(id=null, dateStart=null,"
                        + " dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)),"
                        + " durationGoal=DurationGoalModel(id=1, runningTime=null, goalModel=GoalModel(id=null, dateStart=null,"
                        + " dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)),"
                        + " weightGoal=WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=null,"
                        + " dateStart=null, dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null,"
                        + " user=null)), user=UserModel(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=GUEST,"
                        + " email=jane.doe@example.org, createDate=1970-01-01T00:00, userImageUrl=https://example.org/example,"
                        + " goalModelList=[]))), durationGoal=DurationGoalModel(id=1, runningTime=null, goalModel=GoalModel(id=1,"
                        + " dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00, goalTypeEnum=DISTANCE_GOAL, distanceGoal"
                        + "=DistanceGoalModel(id=1, distance=1, goalModel=GoalModel(id=null, dateStart=null, dateStop=null,"
                        + " goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)), durationGoal"
                        + "=DurationGoalModel(id=1, runningTime=null, goalModel=GoalModel(id=null, dateStart=null, dateStop=null,"
                        + " goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)), weightGoal"
                        + "=WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=null, dateStart=null,"
                        + " dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)),"
                        + " user=UserModel(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=GUEST, email=jane.doe@example.org,"
                        + " createDate=1970-01-01T00:00, userImageUrl=https://example.org/example, goalModelList=[]))),"
                        + " weightGoal=WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=1,"
                        + " dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00, goalTypeEnum=DISTANCE_GOAL, distanceGoal"
                        + "=DistanceGoalModel(id=1, distance=1, goalModel=GoalModel(id=null, dateStart=null, dateStop=null,"
                        + " goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)), durationGoal"
                        + "=DurationGoalModel(id=1, runningTime=null, goalModel=GoalModel(id=null, dateStart=null, dateStop=null,"
                        + " goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)), weightGoal"
                        + "=WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=null, dateStart=null,"
                        + " dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)),"
                        + " user=UserModel(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=GUEST, email=jane.doe@example.org,"
                        + " createDate=1970-01-01T00:00, userImageUrl=https://example.org/example, goalModelList=[]))),"
                        + " user=UserModel(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=GUEST, email=jane.doe@example.org,"
                        + " createDate=1970-01-01T00:00, userImageUrl=https://example.org/example, goalModelList=[])))",
                actualToStringResult);
        assertEquals(1L, actualId.longValue());
        assertEquals(3, actualCurrentWeight.intValue());
        assertEquals(3, actualTargetWeight.intValue());
        assertSame(goalModel4, actualGoalModel);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link WeightGoalModel#WeightGoalModel(Long, Integer, Integer, GoalModel)}
     *   <li>{@link WeightGoalModel#WeightGoalModel()}
     *   <li>{@link WeightGoalModel#setCurrentWeight(Integer)}
     *   <li>{@link WeightGoalModel#setGoalModel(GoalModel)}
     *   <li>{@link WeightGoalModel#setId(Long)}
     *   <li>{@link WeightGoalModel#setTargetWeight(Integer)}
     *   <li>{@link WeightGoalModel#toString()}
     *   <li>{@link WeightGoalModel#getCurrentWeight()}
     *   <li>{@link WeightGoalModel#getGoalModel()}
     *   <li>{@link WeightGoalModel#getId()}
     *   <li>{@link WeightGoalModel#getTargetWeight()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(new GoalModel());
        distanceGoal.setId(1L);

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(new GoalModel());
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(distanceGoal);
        goalModel.setDurationGoal(durationGoal);
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(user);
        goalModel.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel);
        distanceGoal2.setId(1L);

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(new GoalModel());
        distanceGoal3.setId(1L);

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(new GoalModel());
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(distanceGoal3);
        goalModel2.setDurationGoal(durationGoal2);
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(user2);
        goalModel2.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel2);
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

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(new GoalModel());
        distanceGoal4.setId(1L);

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(new GoalModel());
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(distanceGoal4);
        goalModel3.setDurationGoal(durationGoal4);
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(user4);
        goalModel3.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel3);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal2);
        goalModel4.setDurationGoal(durationGoal3);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user3);
        goalModel4.setWeightGoal(weightGoal4);
        WeightGoalModel actualWeightGoalModel = new WeightGoalModel(1L, 1, 1, goalModel4);
        actualWeightGoalModel.setCurrentWeight(3);
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
        GoalModel goalModel5 = new GoalModel();
        goalModel5.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDistanceGoal(distanceGoal5);
        goalModel5.setDurationGoal(durationGoal5);
        goalModel5.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel5.setId(1L);
        goalModel5.setUser(user5);
        goalModel5.setWeightGoal(weightGoal5);
        DistanceGoalModel distanceGoal6 = new DistanceGoalModel();
        distanceGoal6.setDistance(1L);
        distanceGoal6.setGoalModel(goalModel5);
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
        GoalModel goalModel6 = new GoalModel();
        goalModel6.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDistanceGoal(distanceGoal7);
        goalModel6.setDurationGoal(durationGoal6);
        goalModel6.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel6.setId(1L);
        goalModel6.setUser(user6);
        goalModel6.setWeightGoal(weightGoal6);
        DurationGoalModel durationGoal7 = new DurationGoalModel();
        durationGoal7.setGoalModel(goalModel6);
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
        GoalModel goalModel7 = new GoalModel();
        goalModel7.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDistanceGoal(distanceGoal8);
        goalModel7.setDurationGoal(durationGoal8);
        goalModel7.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel7.setId(1L);
        goalModel7.setUser(user8);
        goalModel7.setWeightGoal(weightGoal7);
        WeightGoalModel weightGoal8 = new WeightGoalModel();
        weightGoal8.setCurrentWeight(3);
        weightGoal8.setGoalModel(goalModel7);
        weightGoal8.setId(1L);
        weightGoal8.setTargetWeight(3);
        GoalModel goalModel8 = new GoalModel();
        goalModel8.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDistanceGoal(distanceGoal6);
        goalModel8.setDurationGoal(durationGoal7);
        goalModel8.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel8.setId(1L);
        goalModel8.setUser(user7);
        goalModel8.setWeightGoal(weightGoal8);
        actualWeightGoalModel.setGoalModel(goalModel8);
        actualWeightGoalModel.setId(1L);
        actualWeightGoalModel.setTargetWeight(3);
        String actualToStringResult = actualWeightGoalModel.toString();
        Integer actualCurrentWeight = actualWeightGoalModel.getCurrentWeight();
        GoalModel actualGoalModel = actualWeightGoalModel.getGoalModel();
        Long actualId = actualWeightGoalModel.getId();
        Integer actualTargetWeight = actualWeightGoalModel.getTargetWeight();
        assertEquals(
                "WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=1, dateStart=1970-01-01T00:00,"
                        + " dateStop=1970-01-01T00:00, goalTypeEnum=DISTANCE_GOAL, distanceGoal=DistanceGoalModel(id=1, distance=1,"
                        + " goalModel=GoalModel(id=1, dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00, goalTypeEnum=DISTANCE_GOAL,"
                        + " distanceGoal=DistanceGoalModel(id=1, distance=1, goalModel=GoalModel(id=null, dateStart=null,"
                        + " dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)),"
                        + " durationGoal=DurationGoalModel(id=1, runningTime=null, goalModel=GoalModel(id=null, dateStart=null,"
                        + " dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)),"
                        + " weightGoal=WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=null,"
                        + " dateStart=null, dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null,"
                        + " user=null)), user=UserModel(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=GUEST,"
                        + " email=jane.doe@example.org, createDate=1970-01-01T00:00, userImageUrl=https://example.org/example,"
                        + " goalModelList=[]))), durationGoal=DurationGoalModel(id=1, runningTime=null, goalModel=GoalModel(id=1,"
                        + " dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00, goalTypeEnum=DISTANCE_GOAL, distanceGoal"
                        + "=DistanceGoalModel(id=1, distance=1, goalModel=GoalModel(id=null, dateStart=null, dateStop=null,"
                        + " goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)), durationGoal"
                        + "=DurationGoalModel(id=1, runningTime=null, goalModel=GoalModel(id=null, dateStart=null, dateStop=null,"
                        + " goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)), weightGoal"
                        + "=WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=null, dateStart=null,"
                        + " dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)),"
                        + " user=UserModel(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=GUEST, email=jane.doe@example.org,"
                        + " createDate=1970-01-01T00:00, userImageUrl=https://example.org/example, goalModelList=[]))),"
                        + " weightGoal=WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=1,"
                        + " dateStart=1970-01-01T00:00, dateStop=1970-01-01T00:00, goalTypeEnum=DISTANCE_GOAL, distanceGoal"
                        + "=DistanceGoalModel(id=1, distance=1, goalModel=GoalModel(id=null, dateStart=null, dateStop=null,"
                        + " goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)), durationGoal"
                        + "=DurationGoalModel(id=1, runningTime=null, goalModel=GoalModel(id=null, dateStart=null, dateStop=null,"
                        + " goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)), weightGoal"
                        + "=WeightGoalModel(id=1, currentWeight=3, targetWeight=3, goalModel=GoalModel(id=null, dateStart=null,"
                        + " dateStop=null, goalTypeEnum=null, distanceGoal=null, durationGoal=null, weightGoal=null, user=null)),"
                        + " user=UserModel(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=GUEST, email=jane.doe@example.org,"
                        + " createDate=1970-01-01T00:00, userImageUrl=https://example.org/example, goalModelList=[]))),"
                        + " user=UserModel(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=GUEST, email=jane.doe@example.org,"
                        + " createDate=1970-01-01T00:00, userImageUrl=https://example.org/example, goalModelList=[])))",
                actualToStringResult);
        assertEquals(1L, actualId.longValue());
        assertEquals(3, actualCurrentWeight.intValue());
        assertEquals(3, actualTargetWeight.intValue());
        assertEquals(goalModel4, actualGoalModel);
        assertSame(goalModel8, actualGoalModel);
    }

    /**
     * Method under test: {@link WeightGoalModel#equals(Object)}
     */
    @Test
    void testEquals() {
        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(new GoalModel());
        distanceGoal.setId(1L);

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(new GoalModel());
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(distanceGoal);
        goalModel.setDurationGoal(durationGoal);
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(user);
        goalModel.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel);
        distanceGoal2.setId(1L);

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(new GoalModel());
        distanceGoal3.setId(1L);

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(new GoalModel());
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(distanceGoal3);
        goalModel2.setDurationGoal(durationGoal2);
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(user2);
        goalModel2.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel2);
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

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(new GoalModel());
        distanceGoal4.setId(1L);

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(new GoalModel());
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(distanceGoal4);
        goalModel3.setDurationGoal(durationGoal4);
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(user4);
        goalModel3.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel3);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal2);
        goalModel4.setDurationGoal(durationGoal3);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user3);
        goalModel4.setWeightGoal(weightGoal4);

        WeightGoalModel weightGoalModel = new WeightGoalModel();
        weightGoalModel.setCurrentWeight(3);
        weightGoalModel.setGoalModel(goalModel4);
        weightGoalModel.setId(1L);
        weightGoalModel.setTargetWeight(3);
        assertNotEquals(weightGoalModel, null);
    }

    /**
     * Method under test: {@link WeightGoalModel#equals(Object)}
     */
    @Test
    void testEquals2() {
        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(new GoalModel());
        distanceGoal.setId(1L);

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(new GoalModel());
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(distanceGoal);
        goalModel.setDurationGoal(durationGoal);
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(user);
        goalModel.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel);
        distanceGoal2.setId(1L);

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(new GoalModel());
        distanceGoal3.setId(1L);

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(new GoalModel());
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(distanceGoal3);
        goalModel2.setDurationGoal(durationGoal2);
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(user2);
        goalModel2.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel2);
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

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(new GoalModel());
        distanceGoal4.setId(1L);

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(new GoalModel());
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(distanceGoal4);
        goalModel3.setDurationGoal(durationGoal4);
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(user4);
        goalModel3.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel3);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal2);
        goalModel4.setDurationGoal(durationGoal3);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user3);
        goalModel4.setWeightGoal(weightGoal4);

        WeightGoalModel weightGoalModel = new WeightGoalModel();
        weightGoalModel.setCurrentWeight(3);
        weightGoalModel.setGoalModel(goalModel4);
        weightGoalModel.setId(1L);
        weightGoalModel.setTargetWeight(3);
        assertNotEquals(weightGoalModel, "Different type to WeightGoalModel");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link WeightGoalModel#equals(Object)}
     *   <li>{@link WeightGoalModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(new GoalModel());
        distanceGoal.setId(1L);

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(new GoalModel());
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(distanceGoal);
        goalModel.setDurationGoal(durationGoal);
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(user);
        goalModel.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel);
        distanceGoal2.setId(1L);

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(new GoalModel());
        distanceGoal3.setId(1L);

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(new GoalModel());
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(distanceGoal3);
        goalModel2.setDurationGoal(durationGoal2);
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(user2);
        goalModel2.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel2);
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

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(new GoalModel());
        distanceGoal4.setId(1L);

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(new GoalModel());
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(distanceGoal4);
        goalModel3.setDurationGoal(durationGoal4);
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(user4);
        goalModel3.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel3);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal2);
        goalModel4.setDurationGoal(durationGoal3);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user3);
        goalModel4.setWeightGoal(weightGoal4);

        WeightGoalModel weightGoalModel = new WeightGoalModel();
        weightGoalModel.setCurrentWeight(3);
        weightGoalModel.setGoalModel(goalModel4);
        weightGoalModel.setId(1L);
        weightGoalModel.setTargetWeight(3);
        assertEquals(weightGoalModel, weightGoalModel);
        int expectedHashCodeResult = weightGoalModel.hashCode();
        assertEquals(expectedHashCodeResult, weightGoalModel.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link WeightGoalModel#equals(Object)}
     *   <li>{@link WeightGoalModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        DistanceGoalModel distanceGoal = new DistanceGoalModel();
        distanceGoal.setDistance(1L);
        distanceGoal.setGoalModel(new GoalModel());
        distanceGoal.setId(1L);

        DurationGoalModel durationGoal = new DurationGoalModel();
        durationGoal.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal = new WeightGoalModel();
        weightGoal.setCurrentWeight(3);
        weightGoal.setGoalModel(new GoalModel());
        weightGoal.setId(1L);
        weightGoal.setTargetWeight(3);

        GoalModel goalModel = new GoalModel();
        goalModel.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel.setDistanceGoal(distanceGoal);
        goalModel.setDurationGoal(durationGoal);
        goalModel.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel.setId(1L);
        goalModel.setUser(user);
        goalModel.setWeightGoal(weightGoal);

        DistanceGoalModel distanceGoal2 = new DistanceGoalModel();
        distanceGoal2.setDistance(1L);
        distanceGoal2.setGoalModel(goalModel);
        distanceGoal2.setId(1L);

        DistanceGoalModel distanceGoal3 = new DistanceGoalModel();
        distanceGoal3.setDistance(1L);
        distanceGoal3.setGoalModel(new GoalModel());
        distanceGoal3.setId(1L);

        DurationGoalModel durationGoal2 = new DurationGoalModel();
        durationGoal2.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal2 = new WeightGoalModel();
        weightGoal2.setCurrentWeight(3);
        weightGoal2.setGoalModel(new GoalModel());
        weightGoal2.setId(1L);
        weightGoal2.setTargetWeight(3);

        GoalModel goalModel2 = new GoalModel();
        goalModel2.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel2.setDistanceGoal(distanceGoal3);
        goalModel2.setDurationGoal(durationGoal2);
        goalModel2.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel2.setId(1L);
        goalModel2.setUser(user2);
        goalModel2.setWeightGoal(weightGoal2);

        DurationGoalModel durationGoal3 = new DurationGoalModel();
        durationGoal3.setGoalModel(goalModel2);
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

        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(1L);
        distanceGoal4.setGoalModel(new GoalModel());
        distanceGoal4.setId(1L);

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(new GoalModel());
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

        WeightGoalModel weightGoal3 = new WeightGoalModel();
        weightGoal3.setCurrentWeight(3);
        weightGoal3.setGoalModel(new GoalModel());
        weightGoal3.setId(1L);
        weightGoal3.setTargetWeight(3);

        GoalModel goalModel3 = new GoalModel();
        goalModel3.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel3.setDistanceGoal(distanceGoal4);
        goalModel3.setDurationGoal(durationGoal4);
        goalModel3.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel3.setId(1L);
        goalModel3.setUser(user4);
        goalModel3.setWeightGoal(weightGoal3);

        WeightGoalModel weightGoal4 = new WeightGoalModel();
        weightGoal4.setCurrentWeight(3);
        weightGoal4.setGoalModel(goalModel3);
        weightGoal4.setId(1L);
        weightGoal4.setTargetWeight(3);

        GoalModel goalModel4 = new GoalModel();
        goalModel4.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel4.setDistanceGoal(distanceGoal2);
        goalModel4.setDurationGoal(durationGoal3);
        goalModel4.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel4.setId(1L);
        goalModel4.setUser(user3);
        goalModel4.setWeightGoal(weightGoal4);

        WeightGoalModel weightGoalModel = new WeightGoalModel();
        weightGoalModel.setCurrentWeight(3);
        weightGoalModel.setGoalModel(goalModel4);
        weightGoalModel.setId(1L);
        weightGoalModel.setTargetWeight(3);

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

        GoalModel goalModel5 = new GoalModel();
        goalModel5.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel5.setDistanceGoal(distanceGoal5);
        goalModel5.setDurationGoal(durationGoal5);
        goalModel5.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel5.setId(1L);
        goalModel5.setUser(user5);
        goalModel5.setWeightGoal(weightGoal5);

        DistanceGoalModel distanceGoal6 = new DistanceGoalModel();
        distanceGoal6.setDistance(1L);
        distanceGoal6.setGoalModel(goalModel5);
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

        GoalModel goalModel6 = new GoalModel();
        goalModel6.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel6.setDistanceGoal(distanceGoal7);
        goalModel6.setDurationGoal(durationGoal6);
        goalModel6.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel6.setId(1L);
        goalModel6.setUser(user6);
        goalModel6.setWeightGoal(weightGoal6);

        DurationGoalModel durationGoal7 = new DurationGoalModel();
        durationGoal7.setGoalModel(goalModel6);
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

        GoalModel goalModel7 = new GoalModel();
        goalModel7.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel7.setDistanceGoal(distanceGoal8);
        goalModel7.setDurationGoal(durationGoal8);
        goalModel7.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel7.setId(1L);
        goalModel7.setUser(user8);
        goalModel7.setWeightGoal(weightGoal7);

        WeightGoalModel weightGoal8 = new WeightGoalModel();
        weightGoal8.setCurrentWeight(3);
        weightGoal8.setGoalModel(goalModel7);
        weightGoal8.setId(1L);
        weightGoal8.setTargetWeight(3);

        GoalModel goalModel8 = new GoalModel();
        goalModel8.setDateStart(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDateStop(LocalDate.of(1970, 1, 1).atStartOfDay());
        goalModel8.setDistanceGoal(distanceGoal6);
        goalModel8.setDurationGoal(durationGoal7);
        goalModel8.setGoalTypeEnum(GoalTypeEnum.DISTANCE_GOAL);
        goalModel8.setId(1L);
        goalModel8.setUser(user7);
        goalModel8.setWeightGoal(weightGoal8);

        WeightGoalModel weightGoalModel2 = new WeightGoalModel();
        weightGoalModel2.setCurrentWeight(3);
        weightGoalModel2.setGoalModel(goalModel8);
        weightGoalModel2.setId(1L);
        weightGoalModel2.setTargetWeight(3);
        assertEquals(weightGoalModel, weightGoalModel2);
        int expectedHashCodeResult = weightGoalModel.hashCode();
        assertEquals(expectedHashCodeResult, weightGoalModel2.hashCode());
    }
}
