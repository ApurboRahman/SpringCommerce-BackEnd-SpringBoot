package com.eas.emp.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
  private WebDriver webDriver;

  private static String PAGE_URL = "http://localhost:8080/signup";

  @FindBy(className = "lead")
  private WebElement heading;

  @FindBy(className = "alert-success")
  private WebElement success;

  @FindBy(className = "alert-danger")
  private WebElement error;
  @FindBy(name = "companyId")
  private WebElement companyId;

  @FindBy(name = "employeeId")
  private WebElement employeeId;

  @FindBy(name = "passwords")
  private WebElement passwords;

  @FindBy(name = "confirmPasswords")
  private WebElement confirmPasswords;


  public void setCompanyId(String company) {
    companyId.clear();
    companyId.sendKeys(company);
  }

  public void setEmployeeId(String employee) {
    employeeId.clear();
   employeeId.sendKeys(employee);
  }

  public void setPasswords(String password) {
    passwords.clear();
    passwords.sendKeys(password);
  }

  public void setConfirmPasswords(String confPasswords) {
    confirmPasswords.clear();
    confirmPasswords.sendKeys(confPasswords);
  }

  public SignupPage(WebDriver webDriver) {
    this.webDriver = webDriver;
    webDriver.get(PAGE_URL);
    PageFactory.initElements(webDriver, this);
  }

  // Apply sign up button

  // @FindBy(how = How.CLASS_NAME,using = "signupbtn")
  @FindBy(className = "signupbtn")
  private WebElement signupButton;

  public void clickOnSignupButton() {
    signupButton.click();
  }

  public boolean isPagOpened(){
    //Assertion
    return heading.getText().toString().contains("Employee Signup");
  }

  public boolean isErrorMessageShown(){
   return error.getText().contains("Already user has been created with this info. Please check.");
  }

  public boolean isPasswordsValid(){
   return error.getText().contains("passwords length must be 6-8 including at least 1 capital letter, 1 number and 1 special character.");
  }

  public boolean isSuccess(){
    return success.getText().contains("User created successfully!");
  }
}
