package com.cvrest.cv.CV;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Curiculum_Vitae")
public class CV {
    @Id
    private String id;
    private Status status;
    private String cvXml;

    public CV(Status status, String cvXml) {
        this.status = status;
        this.cvXml = cvXml;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCvXml() {
        return cvXml;
    }

    public void setCvXml(String cvXml) {
        this.cvXml = cvXml;
    }
}
