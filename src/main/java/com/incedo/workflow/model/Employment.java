package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employment extends BasePO{
    private long employeeId;
    private String employerName;
    private Date startDate;
    private Date endDate;
    private boolean isCurrent;
    private Address employerAddress;
}
