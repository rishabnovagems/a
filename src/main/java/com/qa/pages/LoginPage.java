package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(id="mat-input-0")
	WebElement username;
	
	@FindBy(id="mat-input-1")
	WebElement password;
	
	@FindBy(xpath="//span[text()=' LOGIN ']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the Page Objects:
	public LoginPage(String un, String pwd){
		PageFactory.initElements(driver, this);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public void login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
//		    	JavascriptExecutor js = (JavascriptExecutor)driver;
//		    	js.executeScript("arguments[0].click();", loginBtn);
//		    	
//	return new HomePage();
	
	}
}
