package com.cvrest.cv.help;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@RestController
public class HelpController {
  private HelpService helpService;

  @Autowired
  public HelpController(HelpService helpService) {
    this.helpService = helpService;
  }

  // @RequestMapping(value = { "/", "/help" }, method = RequestMethod.GET)
  @GetMapping("/help")
  public String help(Model model) {
    // List<Help> helps = helpService.getHelp();
    return "help";
  }

}
