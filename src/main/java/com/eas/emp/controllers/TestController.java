package com.eas.emp.controllers;

import com.eas.emp.selTest.selenium.TestExecutionClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
  @Autowired private TestExecutionClass testExecution;

  @RequestMapping("/selTest")
  public String testInitialize() throws InterruptedException {
      testExecution.seleniumTest();
      return "index";
  }
}
