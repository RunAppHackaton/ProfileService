package com.runapp.profileservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateWeightGoalRequest {
    private Integer user_id;
    private LocalDateTime dateStart;
    private LocalDateTime dateStop;
    private Integer currentWeight;
    private Integer targetWeight;
}
