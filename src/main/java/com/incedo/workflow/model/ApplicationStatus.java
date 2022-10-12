package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationStatus extends BasePO{
    private long applicationStatusId;
    private long applicationId;
    private String statusCode;
    private LocalDate statusChangedDate;
    private String statusChangedBy;
}
