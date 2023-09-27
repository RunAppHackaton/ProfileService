package com.runapp.profileservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.runapp.profileservice.utill.GoalTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "goal")
public class GoalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_start")
    private LocalDateTime dateStart;

    @Column(name = "date_stop")
    private LocalDateTime dateStop;

    @Column(name = "goal_type")
    @Enumerated(EnumType.STRING)
    private GoalTypeEnum goalTypeEnum;

    @OneToOne(mappedBy = "goalModel", cascade = CascadeType.ALL)
    private DistanceGoalModel distanceGoal;

    @OneToOne(mappedBy = "goalModel", cascade = CascadeType.ALL)
    private DurationGoalModel durationGoal;

    @OneToOne(mappedBy = "goalModel", cascade = CascadeType.ALL)
    private WeightGoalModel weightGoal;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    public GoalModel(LocalDateTime dateStart, LocalDateTime dateStop, GoalTypeEnum goalTypeEnum, UserModel user) {
        this.dateStart = dateStart;
        this.dateStop = dateStop;
        this.goalTypeEnum = goalTypeEnum;
        this.user = user;
    }
}
