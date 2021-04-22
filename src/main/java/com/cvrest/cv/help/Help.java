package com.cvrest.cv.help;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class Help {
  @Id
  private Long id;
  // private List<Help> operations;
  private String url;
  private String methode;
  private String description;

  public Help(String url, String methode, String description) {
    this.url = url;
    this.methode = methode;
    this.description = description;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getMethode() {
    return methode;
  }

  public void setMethode(String methode) {
    this.methode = methode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

}
