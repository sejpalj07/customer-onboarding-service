package com.incedo.workflow.model;

import java.time.LocalDate;

public class ApplicationDocuments extends BasePO{
    private long applicationDocumentsId;
    private long applicationId;
    private String documentTypeCode;
    private String documentFileName;
    private String documentLink;
    private String fileExtension;
    private LocalDate uploadDate;
    private String uploadBy;

}
