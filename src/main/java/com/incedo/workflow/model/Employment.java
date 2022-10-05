package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employment extends BasePO{
    private long employeeId;
    private long customerId;
    private String employerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isCurrent;
    private Address employerAddress;
}
