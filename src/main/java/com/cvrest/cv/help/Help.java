package com.cvrest.cv.help;

import java.util.List;

public class Help {
  private List<Help> operations;
  private String url;
  private String mehtode;
  private String description;

  public Help(String url, String mehtode, String description) {
    this.url = url;
    this.mehtode = mehtode;
    this.description = description;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getMehtode() {
    return mehtode;
  }

  public void setMehtode(String mehtode) {
    this.mehtode = mehtode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
