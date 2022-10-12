package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditResult implements Serializable {
    private String applicationId;
    private Name name;
    private List<Address> address;
    private Date timeStamp;
    private double creditScore;
    private char missPayment;
    private double currentBalance;
}
