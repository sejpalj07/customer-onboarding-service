package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Name implements Serializable {
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String prefix;
    private String isPrimary;
}
