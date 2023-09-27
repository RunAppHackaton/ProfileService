package com.runapp.profileservice.repository;

import com.runapp.profileservice.model.GoalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<GoalModel, Long> {
}
