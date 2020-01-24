package com.eas.emp.selTest.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxTest {
    public void getFireFox() throws InterruptedException {
        WebDriver webDriver = new FirefoxDriver();
        String url = "http://localhost:8080/attendance";
        webDriver.get(url);
        String title = webDriver.getTitle();
        System.out.println("Page Title: " + title);
        System.out.println("Page Title length: " + title.length());

        String pageSource = webDriver.getPageSource();
        System.out.println("Page Source: " + pageSource);
        System.out.println("Page Source length: " + pageSource.length());

        String actualUrl = webDriver.getCurrentUrl();
        if(actualUrl.equals(url)){
            System.out.println("Actual URL sent.");
        }
        webDriver.navigate().to("http://localhost:8080/attendanceReport");

       // webDriver.findElement(By.xpath(".//*[@id='badges']/a")).click();
        Thread.sleep(5000);
        webDriver.navigate().back();
        Thread.sleep(5000);
        webDriver.navigate().forward();
        Thread.sleep(5000);
        webDriver.navigate().refresh();

    }

}
