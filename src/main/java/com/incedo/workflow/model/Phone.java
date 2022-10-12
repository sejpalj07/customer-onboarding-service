package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone implements Serializable {
    private int countryCode;
    private String number;
    private String type;
    private String isPrimary;
}
