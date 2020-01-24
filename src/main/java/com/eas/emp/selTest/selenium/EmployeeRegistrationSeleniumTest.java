package com.eas.emp.selTest.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EmployeeRegistrationSeleniumTest {
  public void getEmployeeRegistration() throws InterruptedException {
    WebDriver webDriver = new FirefoxDriver();

    String login = "http://localhost:8080/login";
    String signup = "http://localhost:8080/signup";
    String registration = "http://localhost:8080";
    String employeeList = "http://localhost:8080/employeeList";
    String attendance = "http://localhost:8080/attendance";
    String attendanceReport = "http://localhost:8080/attendanceReport";
    String pass = "Ba@123";
    // Signup testing

    webDriver.get(signup);

    WebElement element = webDriver.findElement(By.name("companyId"));
    element.sendKeys("1");
    Thread.sleep(2000);
    webDriver.findElement(By.name("employeeId")).sendKeys("1112");
    Thread.sleep(2000);
    webDriver.findElement(By.name("passwords")).sendKeys(pass);
    System.out.println("pass: " + pass);
    Thread.sleep(2000);
    ((FirefoxDriver) webDriver).findElementByName("confirmPasswords").sendKeys(pass);
    System.out.println("con pass: " + pass);
    Thread.sleep(2000);
    webDriver.findElement(By.className("signupbtn")).click();
    Thread.sleep(3000);

    webDriver.findElement(By.className("cancelbtn")).click();
    Thread.sleep(2000);

    webDriver
        .findElement(By.xpath("/html/body/div/div/div[2]/form/div/div/div/div[5]/span/a"))
        .click();

    Thread.sleep(2000);

    webDriver = new FirefoxDriver();
    webDriver.get(login);
    webDriver.findElement(By.name("companyId")).sendKeys("1");
    Thread.sleep(2000);

    webDriver.findElement(By.name("employeeId")).sendKeys("1112");
    Thread.sleep(2000);

    webDriver.findElement(By.name("passwords")).sendKeys("Ba@123");
    Thread.sleep(2000);

    webDriver.findElement(By.className("signupbtn")).click();
    Thread.sleep(2000);
    /*

        // Login after sign up
        // webDriver.switchTo().window(login);
        Thread.sleep(2000);

        webDriver.get(registration);

        element = ((FirefoxDriver) webDriver).findElementById(("employeeId"));
        element.sendKeys("123456");

        Thread.sleep(2000);
        element = ((FirefoxDriver) webDriver).findElementByName(("firstName"));
        element.sendKeys("firstName");

        Thread.sleep(2000);
        element = ((FirefoxDriver) webDriver).findElementByName(("lastName"));
        element.sendKeys("selTestLast");
        Thread.sleep(2000);
        ((FirefoxDriver) webDriver).findElementByName("sexId").click();
        Select oSelect = new Select(((FirefoxDriver) webDriver).findElementByName("sexId"));
        oSelect.selectByIndex(2);

        ((FirefoxDriver) webDriver).findElementByName("phoneNo").sendKeys("01616278726");

        Thread.sleep(1000);
        element = ((FirefoxDriver) webDriver).findElementByName("birthDate");
        element.click();
        element.click();

        Thread.sleep(2000);
        ((FirefoxDriver) webDriver).findElementByName("companyId").click();
        oSelect = new Select(((FirefoxDriver) webDriver).findElementByName("companyId"));
        oSelect.selectByIndex(1);

        Thread.sleep(2000);
        ((FirefoxDriver) webDriver).findElementByName("department").click();
        oSelect = new Select(((FirefoxDriver) webDriver).findElementByName("department"));
        oSelect.selectByIndex(1);

        Thread.sleep(2000);

        element = ((FirefoxDriver) webDriver).findElementByName("Add");
        element.submit();

        element = ((FirefoxDriver) webDriver).findElementByName("show");
        element.click();

        Thread.sleep(2000);
        webDriver.findElement(By.name("reset")).click();

        Thread.sleep(5000);
        webDriver.findElement(By.name("show")).click();

        Thread.sleep(5000);
        element = webDriver.findElement(By.name("hide"));
        element.click();
        Thread.sleep(5000);
        webDriver.findElement(By.name("show")).click();

        Thread.sleep(5000);
        webDriver.findElement(By.name("reset")).click();

        Thread.sleep(5000);
    */
    // webDriver.quit();
  }
}
