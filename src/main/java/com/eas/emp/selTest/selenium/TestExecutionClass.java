package com.eas.emp.selTest.selenium;

import org.springframework.stereotype.Service;


@Service("testExecution")
public class TestExecutionClass {

  public void seleniumTest() throws InterruptedException {
    System.setProperty(
            "webdriver.gecko.driver",
            "C:\\Users\\BJIT\\IdeaProjects\\geckodriver-v0.24.0-win64\\geckodriver.exe");
    EmployeeRegistrationSeleniumTest seleniumTest = new EmployeeRegistrationSeleniumTest();
    seleniumTest.getEmployeeRegistration();
    Thread.sleep(1000);

    LoginTest longTest = new LoginTest();
    longTest.getLoginTest();
  }
}
