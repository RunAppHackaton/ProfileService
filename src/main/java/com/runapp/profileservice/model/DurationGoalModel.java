package com.runapp.profileservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "duration_goal")
public class DurationGoalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "running_time")
    private Duration runningTime;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "goal_id")
    private GoalModel goalModel;
}
