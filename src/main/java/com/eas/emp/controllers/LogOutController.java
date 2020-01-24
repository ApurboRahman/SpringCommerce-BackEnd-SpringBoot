package com.eas.emp.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogOutController {
  @PostMapping("/logOut")
  @ResponseBody
  public String logOut() {
    return "logout";
  }
}
