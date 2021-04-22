package com.cvrest.cv.help;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class HelpController {
  private HelpService helpService;

  @Autowired
  public HelpController(HelpService helpService) {
    this.helpService = helpService;
  }

  // @RequestMapping(value = { "/", "/help" }, method = RequestMethod.GET)
  @GetMapping("/help")
  public String getHelps(Model model) {
    List<Help> helps = helpService.getHelps();
    model.addAttribute("helps", helps);
    return "help";
  }

  @PostMapping("/help")
  public void addHelp(@RequestBody Help help) {
    helpService.addHelp(help);
  }

  // @PostMapping("/help")
  // public void addHelp(Model model) {
  // // List<Help> helps = helpService.getHelp();
  // // model.addAttribute("helps", helps);
  // helpService.
  // // return "help";
  // }
}
