package com.incedo.workflow.model;

import java.time.LocalDate;

public class Employment extends BasePO{
    private long employeeId;
    private long customerId;
    private String employerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isCurrent;
    private Address employerAddress;
}
