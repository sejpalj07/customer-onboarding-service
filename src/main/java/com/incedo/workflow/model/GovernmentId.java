package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GovernmentId implements Serializable {
    private int countryCode;
    private String documentType;
    private String value;
    private Date issueDate;
    private Date expireDate;
}
