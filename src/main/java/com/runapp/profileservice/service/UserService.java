package com.runapp.profileservice.service;

import com.runapp.profileservice.dto.request.CreateDistanceGoalRequest;
import com.runapp.profileservice.dto.request.CreateDurationGoalRequest;
import com.runapp.profileservice.dto.request.CreateWeightGoalRequest;
import com.runapp.profileservice.model.*;
import com.runapp.profileservice.repository.*;
import com.runapp.profileservice.utill.GoalTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final GoalRepository goalRepository;
    private final DistanceGoalRepository distanceGoalRepository;
    private final DurationGoalRepository durationGoalRepository;
    private final WeightGoalRepository weightGoalRepository;

    @Autowired
    public UserService(UserRepository userRepository, GoalRepository goalRepository, DistanceGoalRepository distanceGoalRepository, DurationGoalRepository durationGoalRepository, WeightGoalRepository weightGoalRepository) {
        this.userRepository = userRepository;
        this.goalRepository = goalRepository;
        this.distanceGoalRepository = distanceGoalRepository;
        this.durationGoalRepository = durationGoalRepository;
        this.weightGoalRepository = weightGoalRepository;
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

    public DistanceGoalModel addDistanceGoalToUser(CreateDistanceGoalRequest createDistanceGoalRequest) {
        Optional<UserModel> userOptional = userRepository.findById(createDistanceGoalRequest.getUser_id());
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            GoalModel goal = new GoalModel(
                    createDistanceGoalRequest.getDateStart(),
                    createDistanceGoalRequest.getDateStop(),
                    GoalTypeEnum.DISTANCE_GOAL,
                    user);
            goalRepository.save(goal);
            DistanceGoalModel distanceGoal = new DistanceGoalModel();
            distanceGoal.setGoalModel(goal);
            distanceGoal.setDistance(createDistanceGoalRequest.getDistance_km());
            return distanceGoalRepository.save(distanceGoal);
        } else {
            return null;
        }
    }

    public DurationGoalModel addDurationGoalToUser(CreateDurationGoalRequest createDurationGoalRequest) {
        Optional<UserModel> userOptional = userRepository.findById(createDurationGoalRequest.getUser_id());
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            GoalModel goal = new GoalModel(
                    createDurationGoalRequest.getDateStart(),
                    createDurationGoalRequest.getDateStop(),
                    GoalTypeEnum.DURATION_GOAL,
                    user
            );
            goalRepository.save(goal);
            DurationGoalModel durationGoal = new DurationGoalModel();
            durationGoal.setGoalModel(goal);
            durationGoal.setRunningTime(createDurationGoalRequest.getRunningTime());
            return durationGoalRepository.save(durationGoal);
        } else {
            return null;
        }

    }

    public WeightGoalModel addWeightGoalToUser(CreateWeightGoalRequest createWeightGoalRequest) {
        Optional<UserModel> userOptional = userRepository.findById(createWeightGoalRequest.getUser_id());
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            GoalModel goal = new GoalModel(
                    createWeightGoalRequest.getDateStart(),
                    createWeightGoalRequest.getDateStop(),
                    GoalTypeEnum.WEIGHT_GOAL,
                    user
            );
            goalRepository.save(goal);
            WeightGoalModel weightGoal = new WeightGoalModel();
            weightGoal.setGoalModel(goal);
            weightGoal.setCurrentWeight(createWeightGoalRequest.getCurrentWeight());
            weightGoal.setTargetWeight(createWeightGoalRequest.getTargetWeight());
            return weightGoalRepository.save(weightGoal);
        } else {
            return null;
        }
    }
}
