package com.cvrest.cv.CV;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CV {
    @Id
    private String id;
    private Status status;
    private String jsonData;

    public CV(String id, Status status, String jsonData) {
        this.id = id;
        this.status = status;
        this.jsonData = jsonData;
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

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
