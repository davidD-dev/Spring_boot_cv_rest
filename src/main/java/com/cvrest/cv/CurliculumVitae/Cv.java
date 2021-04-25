package com.cvrest.cv.CurliculumVitae;

import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import org.bson.Document;

@Document(collection = "Curiculum_Vitae")
public class Cv {
    @Id
    private String id;
    private Status status;
    private org.bson.Document cvXml;

    public Cv() {

    }

    public Cv(Status status, org.bson.Document cvXml) {
        this.status = status;
        this.cvXml = cvXml;
    }

    public org.bson.Document getCvXml() {
        return cvXml;
    }

    public void setCvXml(org.bson.Document cvXml) {
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
