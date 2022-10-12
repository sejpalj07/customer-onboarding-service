package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private String addressType;
    private String addressLine1;
    private String addressLine2;
    private String county;
    private String city;
    private String zipCode;
    private String state;
    private String countryCode;
    private String isPrimary;
}
