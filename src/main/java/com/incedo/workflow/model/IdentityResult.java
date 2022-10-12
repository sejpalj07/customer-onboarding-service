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
public class IdentityResult implements Serializable {
    private String applicationId;
    private String decision;
    private Date timeStamp;
    private List<Details> details;
}
