package com.cvrest.cv.help;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelpService {
  // private HelpRepository helpRepository;

  // @Autowired
  // public HelpService(HelpRepository helpRepository) {
  // this.helpRepository = helpRepository;
  // }

  public List<Help> getHelp() {
    Help getHome = new Help("www.google.fr", "GET", "Le site de google");
    List<Help> methods = Arrays.asList(getHome);
    return methods;
  }

}
