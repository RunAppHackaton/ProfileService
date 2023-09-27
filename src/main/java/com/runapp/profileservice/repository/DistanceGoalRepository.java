package com.runapp.profileservice.repository;

import com.runapp.profileservice.model.DistanceGoalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceGoalRepository extends JpaRepository<DistanceGoalModel, Long> {
}
