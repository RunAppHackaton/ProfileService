package com.runapp.profileservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.profileservice.utill.GoalTypeEnum;
import com.runapp.profileservice.utill.RoleEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {UserModel.class})
@ExtendWith(SpringExtension.class)
class UserModelDiffblueTest {
    @Autowired
    private UserModel userModel;

    /**
     * Method under test: {@link UserModel#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new UserModel()).canEqual("Other"));
    }

    /**
     * Method under test: {@link UserModel#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        UserModel userModel2 = new UserModel();

        UserModel userModel3 = new UserModel();
        userModel3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel3.setEmail("jane.doe@example.org");
        userModel3.setFirstName("Jane");
        userModel3.setGoalModelList(new ArrayList<>());
        userModel3.setId(1);
        userModel3.setLastName("Doe");
        userModel3.setRole(RoleEnum.GUEST);
        userModel3.setUserImageUrl("https://example.org/example");
        userModel3.setUsername("janedoe");
        assertTrue(userModel2.canEqual(userModel3));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link UserModel}
     *   <li>{@link UserModel#setCreateDate(LocalDateTime)}
     *   <li>{@link UserModel#setEmail(String)}
     *   <li>{@link UserModel#setFirstName(String)}
     *   <li>{@link UserModel#setGoalModelList(List)}
     *   <li>{@link UserModel#setId(int)}
     *   <li>{@link UserModel#setLastName(String)}
     *   <li>{@link UserModel#setRole(RoleEnum)}
     *   <li>{@link UserModel#setUserImageUrl(String)}
     *   <li>{@link UserModel#setUsername(String)}
     *   <li>{@link UserModel#toString()}
     *   <li>{@link UserModel#getCreateDate()}
     *   <li>{@link UserModel#getEmail()}
     *   <li>{@link UserModel#getFirstName()}
     *   <li>{@link UserModel#getGoalModelList()}
     *   <li>{@link UserModel#getId()}
     *   <li>{@link UserModel#getLastName()}
     *   <li>{@link UserModel#getRole()}
     *   <li>{@link UserModel#getUserImageUrl()}
     *   <li>{@link UserModel#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserModel actualUserModel = new UserModel();
        LocalDateTime createDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualUserModel.setCreateDate(createDate);
        actualUserModel.setEmail("jane.doe@example.org");
        actualUserModel.setFirstName("Jane");
        ArrayList<GoalModel> goalModelList = new ArrayList<>();
        actualUserModel.setGoalModelList(goalModelList);
        actualUserModel.setId(1);
        actualUserModel.setLastName("Doe");
        actualUserModel.setRole(RoleEnum.GUEST);
        actualUserModel.setUserImageUrl("https://example.org/example");
        actualUserModel.setUsername("janedoe");
        String actualToStringResult = actualUserModel.toString();
        LocalDateTime actualCreateDate = actualUserModel.getCreateDate();
        String actualEmail = actualUserModel.getEmail();
        String actualFirstName = actualUserModel.getFirstName();
        List<GoalModel> actualGoalModelList = actualUserModel.getGoalModelList();
        int actualId = actualUserModel.getId();
        String actualLastName = actualUserModel.getLastName();
        RoleEnum actualRole = actualUserModel.getRole();
        String actualUserImageUrl = actualUserModel.getUserImageUrl();
        assertEquals("Doe", actualLastName);
        assertEquals("Jane", actualFirstName);
        assertEquals(
                "UserModel(id=1, username=janedoe, firstName=Jane, lastName=Doe, role=GUEST, email=jane.doe@example.org,"
                        + " createDate=1970-01-01T00:00, userImageUrl=https://example.org/example, goalModelList=[])",
                actualToStringResult);
        assertEquals("https://example.org/example", actualUserImageUrl);
        assertEquals("jane.doe@example.org", actualEmail);
        assertEquals("janedoe", actualUserModel.getUsername());
        assertEquals(1, actualId);
        assertEquals(RoleEnum.GUEST, actualRole);
        assertSame(goalModelList, actualGoalModelList);
        assertSame(createDate, actualCreateDate);
    }

    /**
     * Method under test: {@link UserModel#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(userModel, null);
    }

    /**
     * Method under test: {@link UserModel#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(userModel, "Different type to UserModel");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserModel#equals(Object)}
     *   <li>{@link UserModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
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
        assertEquals(userModel, userModel);
        int expectedHashCodeResult = userModel.hashCode();
        assertEquals(expectedHashCodeResult, userModel.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link UserModel#equals(Object)}
     *   <li>{@link UserModel#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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

        UserModel userModel2 = new UserModel();
        userModel2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel2.setEmail("jane.doe@example.org");
        userModel2.setFirstName("Jane");
        userModel2.setGoalModelList(new ArrayList<>());
        userModel2.setId(1);
        userModel2.setLastName("Doe");
        userModel2.setRole(RoleEnum.GUEST);
        userModel2.setUserImageUrl("https://example.org/example");
        userModel2.setUsername("janedoe");
        assertEquals(userModel, userModel2);
        int expectedHashCodeResult = userModel.hashCode();
        assertEquals(expectedHashCodeResult, userModel2.hashCode());
    }

    /**
     * Method under test: {@link UserModel#equals(Object)}
     */
    @Test
    void testEquals5() {
        UserModel userModel = new UserModel();
        userModel.setCreateDate(LocalDate.now().atStartOfDay());
        userModel.setEmail("jane.doe@example.org");
        userModel.setFirstName("Jane");
        userModel.setGoalModelList(new ArrayList<>());
        userModel.setId(1);
        userModel.setLastName("Doe");
        userModel.setRole(RoleEnum.GUEST);
        userModel.setUserImageUrl("https://example.org/example");
        userModel.setUsername("janedoe");

        UserModel userModel2 = new UserModel();
        userModel2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel2.setEmail("jane.doe@example.org");
        userModel2.setFirstName("Jane");
        userModel2.setGoalModelList(new ArrayList<>());
        userModel2.setId(1);
        userModel2.setLastName("Doe");
        userModel2.setRole(RoleEnum.GUEST);
        userModel2.setUserImageUrl("https://example.org/example");
        userModel2.setUsername("janedoe");
        assertNotEquals(userModel, userModel2);
    }

    /**
     * Method under test: {@link UserModel#equals(Object)}
     */
    @Test
    void testEquals6() {
        UserModel userModel = new UserModel();
        userModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel.setEmail("john.smith@example.org");
        userModel.setFirstName("Jane");
        userModel.setGoalModelList(new ArrayList<>());
        userModel.setId(1);
        userModel.setLastName("Doe");
        userModel.setRole(RoleEnum.GUEST);
        userModel.setUserImageUrl("https://example.org/example");
        userModel.setUsername("janedoe");

        UserModel userModel2 = new UserModel();
        userModel2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel2.setEmail("jane.doe@example.org");
        userModel2.setFirstName("Jane");
        userModel2.setGoalModelList(new ArrayList<>());
        userModel2.setId(1);
        userModel2.setLastName("Doe");
        userModel2.setRole(RoleEnum.GUEST);
        userModel2.setUserImageUrl("https://example.org/example");
        userModel2.setUsername("janedoe");
        assertNotEquals(userModel, userModel2);
    }

    /**
     * Method under test: {@link UserModel#equals(Object)}
     */
    @Test
    void testEquals7() {
        UserModel userModel = new UserModel();
        userModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel.setEmail(null);
        userModel.setFirstName("Jane");
        userModel.setGoalModelList(new ArrayList<>());
        userModel.setId(1);
        userModel.setLastName("Doe");
        userModel.setRole(RoleEnum.GUEST);
        userModel.setUserImageUrl("https://example.org/example");
        userModel.setUsername("janedoe");

        UserModel userModel2 = new UserModel();
        userModel2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel2.setEmail("jane.doe@example.org");
        userModel2.setFirstName("Jane");
        userModel2.setGoalModelList(new ArrayList<>());
        userModel2.setId(1);
        userModel2.setLastName("Doe");
        userModel2.setRole(RoleEnum.GUEST);
        userModel2.setUserImageUrl("https://example.org/example");
        userModel2.setUsername("janedoe");
        assertNotEquals(userModel, userModel2);
    }

    /**
     * Method under test: {@link UserModel#equals(Object)}
     */
    @Test
    void testEquals8() {
        UserModel userModel = new UserModel();
        userModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel.setEmail("jane.doe@example.org");
        userModel.setFirstName("John");
        userModel.setGoalModelList(new ArrayList<>());
        userModel.setId(1);
        userModel.setLastName("Doe");
        userModel.setRole(RoleEnum.GUEST);
        userModel.setUserImageUrl("https://example.org/example");
        userModel.setUsername("janedoe");

        UserModel userModel2 = new UserModel();
        userModel2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel2.setEmail("jane.doe@example.org");
        userModel2.setFirstName("Jane");
        userModel2.setGoalModelList(new ArrayList<>());
        userModel2.setId(1);
        userModel2.setLastName("Doe");
        userModel2.setRole(RoleEnum.GUEST);
        userModel2.setUserImageUrl("https://example.org/example");
        userModel2.setUsername("janedoe");
        assertNotEquals(userModel, userModel2);
    }

    /**
     * Method under test: {@link UserModel#equals(Object)}
     */
    @Test
    void testEquals9() {
        UserModel userModel = new UserModel();
        userModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel.setEmail("jane.doe@example.org");
        userModel.setFirstName(null);
        userModel.setGoalModelList(new ArrayList<>());
        userModel.setId(1);
        userModel.setLastName("Doe");
        userModel.setRole(RoleEnum.GUEST);
        userModel.setUserImageUrl("https://example.org/example");
        userModel.setUsername("janedoe");

        UserModel userModel2 = new UserModel();
        userModel2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel2.setEmail("jane.doe@example.org");
        userModel2.setFirstName("Jane");
        userModel2.setGoalModelList(new ArrayList<>());
        userModel2.setId(1);
        userModel2.setLastName("Doe");
        userModel2.setRole(RoleEnum.GUEST);
        userModel2.setUserImageUrl("https://example.org/example");
        userModel2.setUsername("janedoe");
        assertNotEquals(userModel, userModel2);
    }

    /**
     * Method under test: {@link UserModel#equals(Object)}
     */
    @Test
    void testEquals10() {
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

        ArrayList<GoalModel> goalModelList = new ArrayList<>();
        goalModelList.add(goalModel4);

        UserModel userModel = new UserModel();
        userModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel.setEmail("jane.doe@example.org");
        userModel.setFirstName("Jane");
        userModel.setGoalModelList(goalModelList);
        userModel.setId(1);
        userModel.setLastName("Doe");
        userModel.setRole(RoleEnum.GUEST);
        userModel.setUserImageUrl("https://example.org/example");
        userModel.setUsername("janedoe");

        UserModel userModel2 = new UserModel();
        userModel2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        userModel2.setEmail("jane.doe@example.org");
        userModel2.setFirstName("Jane");
        userModel2.setGoalModelList(new ArrayList<>());
        userModel2.setId(1);
        userModel2.setLastName("Doe");
        userModel2.setRole(RoleEnum.GUEST);
        userModel2.setUserImageUrl("https://example.org/example");
        userModel2.setUsername("janedoe");
        assertNotEquals(userModel, userModel2);
    }
}
