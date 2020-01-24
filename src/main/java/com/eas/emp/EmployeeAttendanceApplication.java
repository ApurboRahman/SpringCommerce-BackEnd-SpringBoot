package com.eas.emp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeAttendanceApplication {


  public static void main(String[] args) throws InterruptedException {
    Logger logger = LoggerFactory.getLogger(EmployeeAttendanceApplication.class);

    logger.info("Employee Attendance Project initializing..........");

    SpringApplication.run(EmployeeAttendanceApplication.class, args);
    logger.info("Employee Attendance Project completed..........");


   // WebDriver webDriver = new FirefoxDriver();
    /*String ulr = "http://localhost:8080";
    webDriver.get(ulr);
    String title = webDriver.getTitle();
    String actualUrl = webDriver.getCurrentUrl();

    if (actualUrl.equals(ulr)) {
      System.out.println("same url");
    } else {
      System.out.println("wrong url");
    }
    String pageSource = webDriver.getPageSource();
    System.out.println("Title: " + title);
    System.out.println("Title Length: " + title.length());
    System.out.println("page source: " + pageSource);
    System.out.println("page Source length: " + pageSource.length());

    Thread.sleep(5000);
    FireFoxTest fireFoxTest = new FireFoxTest();
    fireFoxTest.getFireFox();

    Thread.sleep(1000);
    webDriver.close();*/
  }
}
