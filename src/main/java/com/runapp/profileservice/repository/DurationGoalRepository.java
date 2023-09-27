package com.runapp.profileservice.repository;

import com.runapp.profileservice.model.DurationGoalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DurationGoalRepository extends JpaRepository<DurationGoalModel, Long> {
}
