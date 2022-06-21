package com.qa.pages;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class StaffViewPage extends TestBase {
	JavascriptExecutor js;
	WebDriverWait wait;
	Random randomGenerator;
	int randomInt;
	int randomIntLong;
	String uuid;
	Actions action;

	public StaffViewPage() {
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

	@FindBy(xpath="(//a[@class='smalltab mat-tab-link mat-focus-indicator'])[4]")
	WebElement schedule;

	@FindBy(xpath="//div[@class='site-guard-menu pointer mat-menu-trigger']")
	WebElement changeView;

	@FindBy(xpath="//button[@class='mat-focus-indicator mat-menu-item ng-star-inserted']")
	WebElement button;

	@FindBy(xpath="//div[@class='shiftwithoutguard-close-icon']")
	WebElement shiftWithoutStaff;

	@FindBy(xpath="(//img[@tooltiptheme='scheduleTooltip'])[2]")
	WebElement cellToolTipPlus;

	@FindBy(xpath="((//div[@class='ng-schedule-guardbox ng-star-inserted'])[1]/descendant::div[@class='ng-schedule-guardbox-areatop empty-box'])[2]")
	WebElement cellToolTipPlus2;

	@FindBy(id="shiftSite")
	WebElement setSite;

	@FindBy(xpath="//span[text()='Publish']")
	WebElement publishStaffView;

	@FindBy(xpath="//span[text()='Save Anyway']")
	WebElement saveAnyway;
	
	@FindBy(xpath="//button[text()=' Staff View ']")
	WebElement button2;

	@FindBy(xpath="//h2[text()='1 Scheduling Conflicts']")
	WebElement conflict;
	
	//public boolean validatestaffViewPublishShiftTest(//WebElement publishStaffView//) throws InterruptedException {

	public void validateStaffViewPublishShiftTest() throws InterruptedException {
		Thread.sleep(6000);

		wait.until(ExpectedConditions.visibilityOf(schedule)).click();
		Thread.sleep(5000);

		js.executeScript("arguments[0].click();", changeView);

		//wait.until(ExpectedConditions.elementToBeClickable(changeView)).click();
		//changeView.click();

		//changeView.click();
		Thread.sleep(4000);
		action.moveToElement(button2).build().perform();

		wait.until(ExpectedConditions.visibilityOf(button2)).click();

		//button.click();				
		shiftWithoutStaff.click();      //close staff first Row
		Thread.sleep(2000);

		action.moveToElement(cellToolTipPlus2).perform();
		cellToolTipPlus2.click();
		cellToolTipPlus.click();
		//action.moveToElement(cellToolTipPlus).perform();

		//js.executeScript("arguments[0].scrollIntoView(true);", cellToolTipPlus);   
		//wait.until(ExpectedConditions.visibilityOf(cellToolTipPlus)).click();

		//cellToolTipPlus.click();
		//action.moveToElement(cellToolTipPlus).perform();
		driver.findElement(By.id("shiftSite"));
		action.moveToElement(setSite).perform();
		js.executeScript("arguments[0].click();", setSite);

		wait.until(ExpectedConditions.visibilityOf(setSite)).click();

	//	setSite.click();
		setSite.sendKeys(Keys.ARROW_UP,Keys.ENTER);
		//publishStaffView.click();
	//	publishStaffView.click();

	}}
		/*
		try {
            driver.findElement(By.xpath("//h2[text()='1 Scheduling Conflicts']"));
        } catch (Exception e) {
            System.out.println("id is not present ");
            return false;
        }

        return true;
	 
	
		
		 if(validatestaffViewPublishShiftTest(publishStaffView)==true) {
			
				publishStaffView.click();

			//publishStaffView.click();
		}
		else {
			System.out.println("xxxxx");
			wait.until(ExpectedConditions.elementToBeClickable(saveAnyway)).click();
			//saveAnyway.click();
			wait.until(ExpectedConditions.elementToBeClickable(publishStaffView)).click();
			//changeView.click();

		
		}
	
	
	*/

		//publishStaffView.click();
	

