package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePO implements Serializable {
    private Date createDate;
    private String createdBy;
    private Date updateDate;
    private String updateBy;
}
