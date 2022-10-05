package com.incedo.workflow.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BasePO {
    private long customerId;
    private Name primaryName;
    private Address address;
    private List<Name> akaNameList;
    private LocalDate dateOfBirth;
    private CustomerContact customerContact;
    private String ssn;
    private String tin;


}
