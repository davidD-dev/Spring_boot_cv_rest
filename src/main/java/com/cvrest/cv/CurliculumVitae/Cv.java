package com.cvrest.cv.CurliculumVitae;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Curiculum_Vitae")
public class Cv {
    @Id
    private String id;
    private Status status;
    private String cvXml;

    public Cv() {

    }

    public Cv(Status status,
              String cvXml) {
        this.status = status;
        this.cvXml = cvXml;
    }
    public String getCvXml() {
        return cvXml;
    }

    public void setCvXml(String cvXml) {
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


}
