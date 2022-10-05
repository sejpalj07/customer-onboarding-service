package com.incedo.workflow.model;

import java.time.LocalDate;

public class ApplicationStatus extends BasePO{
    private long applicationStatusId;
    private long applicationId;
    private String statusCode;
    private LocalDate statusChangedDate;
    private String statusChangedBy;
}
