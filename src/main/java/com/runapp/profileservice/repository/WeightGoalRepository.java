package com.runapp.profileservice.repository;

import com.runapp.profileservice.model.WeightGoalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightGoalRepository extends JpaRepository<WeightGoalModel, Long> {
}
