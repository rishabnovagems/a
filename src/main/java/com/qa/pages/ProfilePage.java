package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class ProfilePage extends TestBase{
	Actions action;
	WebDriverWait wait;


	public ProfilePage() {
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 80);


	}

	@FindBy(xpath="//span[text()='Logout']")
	public WebElement c2;
	@FindBy(xpath="//span[text()=' Done']")
	public WebElement c3;
	@FindBy(xpath="//img[@class=\"avatar mr-0 mr-sm-16\"]")
	public WebElement hoverMenuLogout;


	public void validatelogoutTest() throws InterruptedException{
		System.out.println("xxxxxxxxxxxxxxxx");
		Thread.sleep(5000);
		action.moveToElement(hoverMenuLogout).perform();
		action.moveToElement(hoverMenuLogout).perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(hoverMenuLogout)).click(); 

		//hoverMenuLogout.click();
		c2.click();
		c3.click();
		Thread.sleep(5000);

	}
}
