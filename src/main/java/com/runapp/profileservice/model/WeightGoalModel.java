package com.runapp.profileservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weight_goal")
public class WeightGoalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "current_weight")
    private Integer currentWeight;

    @Column(name = "target weight")
    private Integer targetWeight;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "goal_id")
    private GoalModel goalModel;
}
