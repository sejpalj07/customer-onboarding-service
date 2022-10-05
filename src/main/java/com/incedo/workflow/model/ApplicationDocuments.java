package com.incedo.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDocuments extends BasePO{
    private long applicationDocumentsId;
    private long applicationId;
    private String documentTypeCode;
    private String documentFileName;
    private String documentLink;
    private String fileExtension;
    private Date uploadDate;
    private String uploadBy;

}
