package com.eas.emp.selenium;

import com.eas.emp.webPages.SignupPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignupSelTest {
    private WebDriver webDriver;

    @Before
    public void setup(){
        System.setProperty(
                "webdriver.gecko.driver",
                "C:\\Users\\BJIT\\IdeaProjects\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void applySignupTest() throws InterruptedException {
        SignupPage signupPage = new SignupPage(webDriver);

        //check if page is opened
        Assert.assertTrue(signupPage.isPagOpened());
        signupPage.setCompanyId("1");
        Thread.sleep(2000);
        signupPage.setEmployeeId("1238");
        Thread.sleep(2000);
        signupPage.setPasswords("Ab@123");
        Thread.sleep(2000);
        signupPage.setConfirmPasswords("Ab@123");

        //click sign up button
        Thread.sleep(2000);
        signupPage.clickOnSignupButton();
        Thread.sleep(5000);

        Assert.assertTrue(signupPage.isSuccess());
    }

    @Test
    public void alreadyUserCreatedTest() throws InterruptedException {
        SignupPage signupPage = new SignupPage(webDriver);

        //check if page is opened
        Assert.assertTrue(signupPage.isPagOpened());
        signupPage.setCompanyId("1");
        Thread.sleep(2000);
        signupPage.setEmployeeId("1114");
        Thread.sleep(2000);
        signupPage.setPasswords("Ab@123");
        Thread.sleep(2000);
        signupPage.setConfirmPasswords("Ab@123");

        //click sign up button
        Thread.sleep(2000);
        signupPage.clickOnSignupButton();
        Thread.sleep(5000);

        Assert.assertTrue(signupPage.isErrorMessageShown());
    }

    @Test
    public void checkPasswordsValidationTest() throws InterruptedException {
        SignupPage signupPage = new SignupPage(webDriver);

        //check if page is opened
        Assert.assertTrue(signupPage.isPagOpened());
        signupPage.setCompanyId("1");
        Thread.sleep(2000);
        signupPage.setEmployeeId("1114");
        Thread.sleep(2000);
        signupPage.setPasswords("ab@123");
        Thread.sleep(2000);
        signupPage.setConfirmPasswords("ab@123");

        //click sign up button
        Thread.sleep(2000);
        signupPage.clickOnSignupButton();
        Thread.sleep(5000);

        Assert.assertTrue(signupPage.isPasswordsValid());
    }

    @After
    public void close (){
        webDriver.close();
    }
}
