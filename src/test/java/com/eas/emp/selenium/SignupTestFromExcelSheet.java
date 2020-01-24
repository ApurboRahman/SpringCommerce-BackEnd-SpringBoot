package com.eas.emp.selenium;

import com.eas.emp.webPages.SignupPage;
import com.eas.emp.excel.ExcelReadWrite;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignupTestFromExcelSheet {
  private WebDriver webDriver;
  private static final String Path_TestData =
      "C:\\Users\\BJIT\\IdeaProjects\\FinalAttendanceProject\\src\\test\\resources\\testData\\signup\\input\\";
  private static final String File_TestData = "testData.xlsx";

  @Before
  public void setup() {
    ExcelReadWrite.openExcelFile(Path_TestData + File_TestData, "Sheet1");
    System.setProperty(
        "webdriver.gecko.driver",
        "C:\\Users\\BJIT\\IdeaProjects\\geckodriver-v0.24.0-win64\\geckodriver.exe");
    webDriver = new FirefoxDriver();
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void applySignupTest() throws InterruptedException {
    SignupPage signupPage = new SignupPage(webDriver);

    // check if page is opened
    Assert.assertTrue(signupPage.isPagOpened());
    String companyId = ExcelReadWrite.getCellData(0, 0);
    signupPage.setCompanyId(companyId);
    Thread.sleep(2000);

    String employeeId = ExcelReadWrite.getCellData(0, 1);
    signupPage.setEmployeeId(employeeId);
    Thread.sleep(2000);

    String pass = ExcelReadWrite.getCellData(0, 2);
    signupPage.setPasswords(pass);
    Thread.sleep(2000);
    signupPage.setConfirmPasswords(pass);

    // click sign up button
    Thread.sleep(2000);
    signupPage.clickOnSignupButton();
    Thread.sleep(5000);

    //   Assert.assertTrue(signupPage.isSuccess());
    if (signupPage.isSuccess()) {
      ExcelReadWrite.setCellData("pass", 0, 3);
    } else {
      ExcelReadWrite.setCellData("fail", 0, 3);
    }
  }

  @After
  public void close() {
    webDriver.close();
  }
}
