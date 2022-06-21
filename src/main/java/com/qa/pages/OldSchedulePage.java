package com.qa.pages;



import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;



public class OldSchedulePage extends TestBase {

	JavascriptExecutor js;
	WebDriverWait wait;
	Random randomGenerator;
	int randomInt;
	int randomIntLong;
	String uuid;
	Actions action;

	public OldSchedulePage() {
		
		super();

		PageFactory.initElements(driver, this);
		action =new Actions(driver);
		wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 80);
		js = (JavascriptExecutor) driver;
		randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(1000);
		randomIntLong = randomGenerator.nextInt(1000000000);
		uuid = UUID.randomUUID().toString();
	}
	
	@FindBy(xpath="//img[@class=\"avatar mr-0 mr-sm-16\"]")
	public WebElement hoverProfile;
	@FindBy(className="s-16 mat-icon notranslate material-icons mat-icon-no-color")
	public WebElement hoverProfile1;
	@FindBy(xpath="//span[text()='Switch to Old Schedule']")
	public WebElement switchToOldSchedule;
	@FindBy(xpath="//button[@class='apply btn1 mat-focus-indicator mat-button mat-button-base']")
	public WebElement yesButton;
	@FindBy(xpath="((//li[@class='left-sidebar-schedule hover_grey'])[1]//following::li//descendant::div[@class='plusIcon ng-star-inserted'])")
	public WebElement plusCell;

	public void validateOldSchedulePublishShiftTest() throws InterruptedException {
		Thread.sleep(5000);
		action.moveToElement(hoverProfile).perform();
		action.moveToElement(hoverProfile).perform();
		js.executeScript("arguments[0].click();", hoverProfile);

		
		//wait.until(ExpectedConditions.elementToBeClickable(hoverProfile)).click(); 
		//hoverProfile.click();
		switchToOldSchedule.click();
		action.moveToElement(yesButton).perform();
		Thread.sleep(1000);
		yesButton.click();
		
		//js.executeScript("arguments[0].click();", plusCell);   working
		driver.findElement(By.xpath("(//div[@class='plusIcon ng-star-inserted'])[1]")).click();
	}
}
	/*	
		List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class='plusIcon ng-star-inserted']"));
		//((//li[@class='left-sidebar-schedule hover_grey'])[1]//following::li//descendant::div[@class='plusIcon ng-star-inserted'])
        System.out.println(allOptions.size());
        
        for(int i = 0; i<=allOptions.size()-1; i++) {
        	 Thread.sleep(3000);
        	// action.moveToElement()
        	 
                allOptions.get(i).findElement(null).click();               
            
                break;
                 
            }
        }

		//plusCell.click();
		
	}

/*
List<WebElement> allOptions = driver.findElements(By.className("//div[@class='mat-menu-content']//button"));
System.out.println(allOptions.size());
for(int i = 0; i<=allOptions.size()-1; i++) {
    
    if(allOptions.get(i).getText().contains("Repeat Shift + Staff")) {
         
        allOptions.get(i).click();
        
        break;
         
    }
}

*/











