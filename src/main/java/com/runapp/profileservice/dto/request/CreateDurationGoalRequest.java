package com.runapp.profileservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDurationGoalRequest {
    private Integer user_id;
    private LocalDateTime dateStart;
    private LocalDateTime dateStop;
    private Duration runningTime;
}
