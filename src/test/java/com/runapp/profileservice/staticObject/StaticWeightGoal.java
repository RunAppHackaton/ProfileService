package com.runapp.profileservice.staticObject;

import com.runapp.profileservice.model.*;
import com.runapp.profileservice.utill.GoalTypeEnum;

import java.time.LocalDate;

public class StaticWeightGoal {

    public static WeightGoalModel weightGoalModel1(){
        WeightGoalModel weightGoalModel = new WeightGoalModel();
        weightGoalModel.setCurrentWeight(3);
        weightGoalModel.setId(1L);
        weightGoalModel.setTargetWeight(3);
        return weightGoalModel;
    }

    public static WeightGoalModel weightGoalModel4(){
        DistanceGoalModel distanceGoal4 = new DistanceGoalModel();
        distanceGoal4.setDistance(3L);
        distanceGoal4.setGoalModel(new GoalModel());
        distanceGoal4.setId(1L);

        DurationGoalModel durationGoal4 = new DurationGoalModel();
        durationGoal4.setGoalModel(new GoalModel());
        durationGoal4.setId(1L);

        UserModel user4 = StaticUser.userModel1();

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
        return weightGoal4;
    }
}
