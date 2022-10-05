package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Name extends BasePO{
    private long nameId;
    private long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String prefix;
    private String isPrimary;
}
