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
public class CustomerData implements Serializable {
    private  int customerId;
    private Name name;
    private List<Address> address;
    private Date dateOfBirth;
    private GovernmentId governmentId;
    private List<Phone> phone;
    private List<Email> email;
}
