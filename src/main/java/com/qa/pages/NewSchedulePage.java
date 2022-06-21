package com.qa.pages;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class NewSchedulePage extends TestBase {
	JavascriptExecutor js;
	WebDriverWait wait;
	Random randomGenerator;
	int randomInt;
	int randomIntLong;
	String uuid;
	Actions action;

	public NewSchedulePage() {
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

	//---------------------------------------------------------------------------------//
	
	@FindBy(xpath="//a[text()=' Schedule']")
	WebElement scheulePageNavigation;

	@FindBy(xpath="(//div[@class='ng-schedule-guardbox shift-container ng-star-inserted'])[1]")
	
	//  ((//div[@class='ng-schedule-sitebox'])[1]/following-sibling::div[1]/descendant::div[@class='ng-schedule-guardbox-areatop empty-box'])[2]
	
	WebElement cellHover;

	@FindBy(xpath="((//div[@class='ng-schedule-guardbox shift-container ng-star-inserted'])[1]//div[@class='ng-schedule-header-guardbox-options ng-star-inserted'])[2]")
	
	// scheduleTooltip
	
	WebElement cell;

	@FindBy(xpath="//button[@id='publishbtn']")
	WebElement publishBtn;

	@FindBy(xpath="//input[@id='shiftRequiredstaff']")
	WebElement countStaff;
	
	@FindBy(xpath="//div[@class='mat-chip-list-wrapper']")  // ////input[@id='shiftSearchstaff']
	WebElement searchStaff;


		public void validatePublishShiftTest() throws InterruptedException {

		Thread.sleep(1000);
			List<WebElement> allOptions = driver.findElements(By.xpath("//a[@class='smalltab mat-tab-link mat-focus-indicator']"));
	        System.out.println(allOptions.size());
	        
	        for(int i = 0; i<=allOptions.size()-1; i++) {
	                      Thread.sleep(1500);
	            if(allOptions.get(i).getText().contains("Schedule")) {
	            	System.out.println("xx");
	                 
	                allOptions.get(i).click();
	                
	                break;
	                 
	            }
	        }	
		//wait.until(ExpectedConditions.elementToBeClickable(scheulePageNavigation)).click();
		action.moveToElement(cellHover).perform();
		cellHover.click();
		//cell.click();
		countStaff.sendKeys(Keys.CLEAR);
		countStaff.sendKeys("2");
		Thread.sleep(4000);
        js.executeScript("window.scrollBy(0,1000)");

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//wait.until(ExpectedConditions.elementToBeClickable(searchStaff)).sendKeys("abc");
		action.moveToElement(searchStaff).perform();
		searchStaff.click();
		searchStaff.click();

		//action.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER)).perform();	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(publishBtn)).click();
		//publishBtn.click();
	}
	
//------------------------------------------------------------------------------------//
	
	@FindBy(xpath="//button[text()='Unpublish This Day']")
	WebElement unpublish;

	@FindBy(xpath="(//img[@tooltiptheme='scheduleTooltip'])[1]")
	WebElement velipsesCell;

	public void validateuNPublishShiftTest() throws InterruptedException {

		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(scheulePageNavigation)).click();
		action.moveToElement(cellHoverUpper).perform();
		cellHover.click();
		cell2.click();
		//action.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER)).perform();
		List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class='mat-menu-content']//button"));
        System.out.println(allOptions.size());
        
        for(int i = 0; i<=allOptions.size()-1; i++) {
                      
            if(allOptions.get(i).getText().contains("Unpublish This Day")) {
                 
                allOptions.get(i).click();
                	
                break;
                 
            }
        }

	}
	

//----------------------------------------------------------------------------------------//	
	
	@FindBy(xpath="((//div[@class='ng-schedule-sitebox'])[1]/following-sibling::div[1]/descendant::div[@class='ng-schedule-guardbox-areatop empty-box'])[1]")
	WebElement cellHoverUpper;

	@FindBy(xpath="(//img[@tooltiptheme='scheduleTooltip'])[1]")
	WebElement cell2;

	@FindBy(id="mat-menu-panel-334")
	WebElement delete_This_Day;

	@FindBy(xpath="//button[text()='Delete staff + Shifts']")
	WebElement delete_Staff_Shift;

	@FindBy(xpath="//button[@class='btn-theme font-fam']")
	WebElement yes_Button;
	
	@FindBy(xpath="(//div[@class='mat-menu-content'])[2]")
	WebElement container;

	public void validateDeleteShiftTest() throws InterruptedException {

		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(scheulePageNavigation)).click();
		action.moveToElement(cellHoverUpper).perform();
		cellHover.click();
		cell2.click();
		//(//div[@class='ng-schedule-sitebox'])[1]/following-sibling::div[1]/descendant::div[1]
		//By abhinav ji
		
		List<WebElement> allOptions = driver.findElements(By.xpath("//div[@class='mat-menu-content']//button"));
        System.out.println(allOptions.size());
        
        for(int i = 0; i<=allOptions.size()-1; i++) {
                      
            if(allOptions.get(i).getText().contains("Delete staff + Shifts")) {
                 
                allOptions.get(i).click();
                
                break;
                 
            }
        }
		
		delete_Staff_Shift.click();
		yes_Button.click();

	}
	
	//--------------------------------------------------------------------------------//

	@FindBy(xpath="//button[@id='publishbtn']")
	WebElement saveShiftButton;
	
	public void validateSaveShiftTest() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(scheulePageNavigation)).click();
		action.moveToElement(cellHover).perform();
		cellHover.click();
		cell.click();
		countStaff.sendKeys(Keys.CLEAR);
		countStaff.sendKeys("2");		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(saveShiftButton)).click();
		
	}

	@FindBy(xpath="//div[@class='gaurdIcons01 ng-star-inserted']")
	WebElement chevronDownIcon;
	
	@FindBy(xpath="//img[@class='moreopt-cls']")
	WebElement chevronDownIcon2;
	
	
	public void validateRepeatShiftTest() throws InterruptedException {
		this.validatePublishShiftTest();
		action.moveToElement(cellHover).perform();
		action.moveToElement(chevronDownIcon).perform();
		chevronDownIcon.click();
		chevronDownIcon2.click();
		
		List<WebElement> allOptions = driver.findElements(By.className("//div[@class='mat-menu-content']//button"));
        System.out.println(allOptions.size());
		for(int i = 0; i<=allOptions.size()-1; i++) {
            
            if(allOptions.get(i).getText().contains("Repeat Shift + Staff")) {
                 
                allOptions.get(i).click();
                
                break;
                 
            }
        }
		//cell2.click();
		
		
	}
	
	//   //div[@class='ng-schedule-guard-container ng-schedule-npublish-guard-container-pastdates ng-star-inserted']
	@FindBy(xpath="//div[@class='ng-schedule-guard-container ng-schedule-npublish-guard-container-pastdates ng-star-inserted']")
	WebElement drag;
	@FindBy(xpath="(//div[@class='ng-schedule-guardbox ng-star-inserted'])[3]")
	WebElement drop;
	
	@FindBy(xpath="(//a[@class='smalltab mat-tab-link mat-focus-indicator'])[4]")
	WebElement schedule1;

	public void validateDragAndDropShiftTest() throws InterruptedException {
		//this.validatePublishShiftTest();
	     // driver.switchTo().frame(0);

		Thread.sleep(6000);
	
		wait.until(ExpectedConditions.elementToBeClickable(schedule1)).click();
		Thread.sleep(2000);
		//action.moveToElement(cellHover).perform();
		//action.moveToElement(chevronDownIcon).perform();
		Thread.sleep(6000);
		action.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
		
		//action.clickAndHold(drag).dragAndDrop(drag, drop).build().perform();
		
		
		
	}

	
}
