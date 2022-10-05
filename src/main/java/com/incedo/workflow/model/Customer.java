package com.incedo.workflow.model;



import java.time.LocalDate;
import java.util.List;

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
