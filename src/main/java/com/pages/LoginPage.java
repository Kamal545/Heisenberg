package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
     private WebDriver driver;
     //By locators
     private By email = By.id("email");
     private By password = By.id("passwd");
     private By signinButton = By.id("SubmitLogin");
     private By forgotPwdLink = By.linkText("Forgot your password?");
     private By authError = By.xpath("//div[@class='alert alert-danger']");
     //Constructor of the page class
     public LoginPage(WebDriver driver){
    	 this.driver = driver;
     }
     //Page actions
     
     public String getPageTitle(){
    	 return driver.getTitle();
     }
     public void enterEmail(String username){
    	 driver.findElement(email).sendKeys(username);
     }
     public void enterPassword(String pwd){
    	 driver.findElement(password).sendKeys(pwd);
     }
     public void clickSignIn(){
    	 driver.findElement(signinButton).click();
     }
     public Boolean isForgotPdLinkExist(){
    	return driver.findElement(forgotPwdLink).isDisplayed();
     }
     public Boolean isAuthErrorExist(){
    	 return driver.findElement(authError).isDisplayed();
     }
     public AccountsPage doLogin(String username, String pwd){
    	 driver.findElement(email).sendKeys(username);
    	 driver.findElement(password).sendKeys(pwd);
    	 driver.findElement(signinButton).click();
    	 return new AccountsPage(driver);
     }
     
}
