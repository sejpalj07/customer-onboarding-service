package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest implements Serializable {
    private String customerId;
    private String customerName;
    private String applicationType;
    private String service;
    private String status;
    private String address;
    private String credit;
    private boolean backGround;
    private  boolean CBSStatus;
}
