package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerContact extends BasePO{
    private long customerContactId;
    private Phone cellPhone;
    private String email;
    private Phone alternatePhone;
}
