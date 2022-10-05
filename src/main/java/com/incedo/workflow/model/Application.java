package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application extends BasePO{
    private long applicationId;
    private CodedApplicationStatus statusCode;
    private LocalDate startTime;
    private LocalDate completedTime;
    private Customer customer;
    private String customerTypeCode;
    private String applicationTypeCode;

}
