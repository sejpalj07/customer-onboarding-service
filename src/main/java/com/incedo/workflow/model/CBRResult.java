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
public class CBRResult implements Serializable {
    private String applicationId;
    private Name name;
    private List<Address> address;
    private Date timeStamp;
    private String decision;
    private String reason;
}
