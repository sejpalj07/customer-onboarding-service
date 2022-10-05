package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnBoardApplication extends BasePO{
    private long applicationId;
    private String statusCode;
    private Date startTime;
    private Date completedTime;
    private Customer customer;
    private String customerTypeCode;
    private String applicationTypeCode;

}
