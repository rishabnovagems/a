package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR:
	String actual;
	
	@FindBy(id="mat-input-0")
	WebElement username;

	@FindBy(id="mat-input-1")
	WebElement password;

	@FindBy(xpath="//span[text()=' LOGIN ']")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[text()='Staff']")
	WebElement staffText;

	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;

	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}

	public String login(String username, String password){
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		loginBtn.click();	   
		String actual=staffText.getText();
		System.out.println(actual);
		return actual;
		
	}
}
