package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataRequest implements Serializable {
    private String applicationId;
    private String consumerId;
    private String statusCode;
    private String applicationTypeCode;
    private String applicationProcess;
    private CustomerData customerData;
}
