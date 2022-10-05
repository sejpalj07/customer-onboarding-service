package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BasePO{
    private long addressId;
    private long customerId;
    private String street1;
    private String street2;
    private String city;
    private String zip;
    private String state;
    private String country;
    private String addressTypeCode;
}
