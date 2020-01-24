package com.eas.emp.selTest.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
  public void getLoginTest() throws InterruptedException {
    String login = "http://localhost:8080/login";
    WebDriver webDriver = new FirefoxDriver();
    webDriver.navigate().refresh();
    webDriver.get(login);
    webDriver.findElement(By.name("companyId")).sendKeys("1");
    Thread.sleep(2000);
    webDriver.findElement(By.name("employeeId")).sendKeys("1112");
    Thread.sleep(2000);
    webDriver.findElement(By.name("passwords")).sendKeys("Ba@123");
    Thread.sleep(2000);

    webDriver.findElement(By.className("signupbtn")).click();
  }
}
