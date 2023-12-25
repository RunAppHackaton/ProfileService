package com.runapp.profileservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.runapp.profileservice.utill.GoalTypeEnum;
import com.runapp.profileservice.utill.RoleEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class GoalModelDiffblueTest {
    /**
     * Method under test:
     * {@link GoalModel#GoalModel(LocalDateTime, LocalDateTime, GoalTypeEnum, UserModel)}
     */
    @Test
    void testConstructor() {
        LocalDate ofResult = LocalDate.of(1970, 1, 1);
        LocalDateTime dateStart = ofResult.atStartOfDay();
        LocalDate ofResult2 = LocalDate.of(1970, 1, 1);
        LocalDateTime dateStop = ofResult2.atStartOfDay();

        UserModel user = new UserModel();
        LocalDate ofResult3 = LocalDate.of(1970, 1, 1);
        user.setCreateDate(ofResult3.atStartOfDay());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        ArrayList<GoalModel> goalModelList = new ArrayList<>();
        user.setGoalModelList(goalModelList);
        user.setId(1);
        user.setLastName("Doe");
        user.setRole(RoleEnum.GUEST);
        user.setUserImageUrl("https://example.org/example");
        user.setUsername("janedoe");
        GoalModel actualGoalModel = new GoalModel(dateStart, dateStop, GoalTypeEnum.DISTANCE_GOAL, user);

        LocalDateTime dateStart2 = actualGoalModel.getDateStart();
        assertEquals("00:00", dateStart2.toLocalTime().toString());
        LocalDateTime dateStop2 = actualGoalModel.getDateStop();
        assertEquals("00:00", dateStop2.toLocalTime().toString());
        UserModel user2 = actualGoalModel.getUser();
        LocalDateTime createDate = user2.getCreateDate();
        assertEquals("00:00", createDate.toLocalTime().toString());
        LocalDate toLocalDateResult = dateStart2.toLocalDate();
        assertEquals("1970-01-01", toLocalDateResult.toString());
        LocalDate toLocalDateResult2 = dateStop2.toLocalDate();
        assertEquals("1970-01-01", toLocalDateResult2.toString());
        LocalDate toLocalDateResult3 = createDate.toLocalDate();
        assertEquals("1970-01-01", toLocalDateResult3.toString());
        assertEquals("Doe", user2.getLastName());
        assertEquals("Jane", user2.getFirstName());
        assertEquals("https://example.org/example", user2.getUserImageUrl());
        assertEquals("jane.doe@example.org", user2.getEmail());
        assertEquals("janedoe", user2.getUsername());
        assertNull(actualGoalModel.getDistanceGoal());
        assertNull(actualGoalModel.getDurationGoal());
        assertNull(actualGoalModel.getWeightGoal());
        assertNull(actualGoalModel.getId());
        assertEquals(1, user2.getId());
        assertEquals(GoalTypeEnum.DISTANCE_GOAL, actualGoalModel.getGoalTypeEnum());
        assertEquals(RoleEnum.GUEST, user2.getRole());
        List<GoalModel> goalModelList2 = user2.getGoalModelList();
        assertTrue(goalModelList2.isEmpty());
        assertSame(user, user2);
        assertSame(goalModelList, goalModelList2);
        assertSame(dateStart, dateStart2);
        assertSame(dateStop, dateStop2);
        assertSame(ofResult, toLocalDateResult);
        assertSame(ofResult2, toLocalDateResult2);
        assertSame(ofResult3, toLocalDateResult3);
    }
}
