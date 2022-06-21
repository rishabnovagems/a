package com.qa.pages;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class PatrolCarPage extends TestBase {

	JavascriptExecutor js;
	WebDriverWait wait;
	Random randomGenerator;
	int randomInt;
	int randomIntLong;
	String uuid;
	Actions action;

	public PatrolCarPage() {
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


	@FindBy(xpath="//i[text()='add']")
	public WebElement staffloatingIcon;

	@FindBy(xpath="//a[text()=' Sites ']")
	WebElement navigationSites;

	@FindBy(xpath="//img[@class='patrolImageFloat']")
	WebElement addPatrolCar;

	@FindBy(xpath="//input[@id='patrolsitename']")
	WebElement patrolSiteName;

	@FindBy(xpath="//input[@id='patrolcardescription']")
	WebElement patrolcardescription;

	@FindBy(xpath="//input[@id='patrolcarnumber']")
	WebElement patrolcarnumber;

	@FindBy(xpath="//input[@id='siteAddress']")
	WebElement siteAddress;

	@FindBy(xpath="//label[@class='mat-checkbox-layout']")
	WebElement geofencePatrol;

	@FindBy(id="finishbtn")
	WebElement finishButton;

	@FindBy(id="createBoundarybtn")
	WebElement createBoundaryBtn;



	public void validateAddPatrolCarTest() throws InterruptedException {
		//driver.navigate().refresh();
		Thread.sleep(4000);
		

		js.executeScript("arguments[0].click();", navigationSites);
		String a=navigationSites.getText();
		System.out.println(a);
		if(a!="Sites") {
			
			js.executeScript("arguments[0].click();", navigationSites);

		}
		
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		//driver.navigate().refresh();
		action.moveToElement(staffloatingIcon).perform();
		driver.navigate().refresh();
		action.moveToElement(staffloatingIcon).perform();
		wait.until(ExpectedConditions.elementToBeClickable(addPatrolCar)).click(); 
		patrolSiteName.sendKeys("CarTest"+ randomInt);
		patrolcarnumber.sendKeys("Car Test number"+ randomIntLong);
		patrolcardescription.sendKeys("Test01" + randomInt + randomIntLong);
		siteAddress.sendKeys("Delhi");
		//siteAddress.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		Thread.sleep(2000);
		action.moveToElement(siteAddress).sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER)).perform();
		//action.moveToElement(siteAddress).sendKeys(Keys.ENTER).perform();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//action.moveToElement(siteAddress).sendKeys(Keys.ARROW_DOWN).perform();
		//js.executeScript("arguments[0].scrollIntoView();", geofencePatrol);
		createBoundaryBtn.click();
		js.executeScript("arguments[0].scrollIntoView();", geofencePatrol);

		//wait.until(ExpectedConditions.visibilityOf(geofencePatrol)).click();
		finishButton.click();


	}

	@FindBy(xpath="//a[text()=' Schedule']")
	WebElement scheulePageNavigation;

	@FindBy(xpath="((//div[@class='ng-schedule-sitebox'])[1]/following-sibling::div[1]/descendant::div[@class='ng-schedule-guardbox-areatop empty-box'])[2]")
	WebElement cellHover;

	@FindBy(xpath="(//img[@tooltiptheme='scheduleTooltip'])[2]")
	WebElement cell;

	@FindBy(xpath="//button[@id='publishbtn']")
	WebElement publishBtn;

	@FindBy(xpath="//input[@id='shiftRequiredstaff']")
	WebElement countStaff;

	@FindBy(xpath="//div[@class='mat-chip-list-wrapper']")  // ////input[@id='shiftSearchstaff']
	WebElement searchStaff;

	@FindBy(id="patrolSite")
	WebElement searchSite;

	@FindBy(xpath="//div[@class='mat-select-trigger']")
	WebElement numberOfRounds;

	@FindBy(id="addbtn")
	WebElement addButton;
	
	@FindBy(id="addTimebtn")
	WebElement addTimeButton;

	public void validatePatrolRandomTimeRounds() throws InterruptedException {
		Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(scheulePageNavigation)).click();
		action.moveToElement(cellHover).perform();
		cellHover.click();
		cell.click();
		countStaff.sendKeys(Keys.CLEAR);
		countStaff.sendKeys("2");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1000)");

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//wait.until(ExpectedConditions.elementToBeClickable(searchStaff)).sendKeys("abc");
		action.moveToElement(searchStaff).perform();
		searchStaff.click();
		searchStaff.click();
		action.moveToElement(searchSite).perform();
		searchSite.click();
		action.sendKeys(Keys.chord(Keys.ARROW_UP,Keys.ENTER)).perform();
		//searchSite.click();

		action.moveToElement(numberOfRounds).perform();
		numberOfRounds.click();


		List<WebElement> allOptions = driver.findElements(By.xpath("//mat-option[@class='mat-option mat-focus-indicator ng-star-inserted']"));
		Thread.sleep(2000);
		System.out.println(allOptions.size());

		for(int i = 0; i<=allOptions.size()-1; i++) {

			if(allOptions.get(i).getText().contains("2 Rounds")) {

				allOptions.get(i).click();

				break;

			}
		}

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

		//addButton.click();


		//action.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER)).perform();	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(publishBtn)).click();
		//publishBtn.click();
	}

	@FindBy(id="fixedTimebtn")
	WebElement fixedButton;


	@FindBy(xpath="//input[@id='Start Time']")
	WebElement startTime;

	@FindBy(xpath="//input[@id='End Time']")
	WebElement endTime;

	public void validatePatrolFixedTimeRounds() throws InterruptedException {
		Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(scheulePageNavigation)).click();
		action.moveToElement(cellHover).perform();
		cellHover.click();
		cell.click();
		countStaff.sendKeys(Keys.CLEAR);
		countStaff.sendKeys("2");
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1000)");

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//wait.until(ExpectedConditions.elementToBeClickable(searchStaff)).sendKeys("abc");
		action.moveToElement(searchStaff).perform();
		searchStaff.click();
		searchStaff.click();
		action.moveToElement(searchSite).perform();
		searchSite.click();
		action.sendKeys(Keys.chord(Keys.ARROW_UP,Keys.ENTER)).perform();
		fixedButton.click();
		action.moveToElement(startTime).perform();
		startTime.click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//mat-option[@class='mat-option mat-focus-indicator ng-star-inserted']"));
		Thread.sleep(2000);
		System.out.println(allOptions.size());

		for(int i = 0; i<=allOptions.size()-1; i++) {

			if(allOptions.get(i).getText().contains("10:45")) {

				allOptions.get(i).click();

				break;

			}
		}
		
		Thread.sleep(2000);
		action.moveToElement(endTime).perform();

		endTime.click();

		List<WebElement> xyz = driver.findElements(By.xpath("//mat-option[@role='option']"));
		Thread.sleep(2000);
		System.out.println(xyz.size());
		try {

			for(int i = 0; i<=xyz.size()-1; i++) {

				if(xyz.get(i).getText().contains("11:45")) {


					xyz.get(i).click();

					break;

				}
			}
		}

		catch(StaleElementReferenceException e) {
			for(int i = 0; i<=xyz.size()-1; i++) {

			if(xyz.get(i).getText().contains("17:45")) {


				xyz.get(i).click();

				break;

			}
		}
	}
		
		addTimeButton.click();

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();

		//addButton.click();


		//action.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER)).perform();	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(publishBtn)).click();
		//searchSite.click();
	}

}

/*

try{
    l.sendKeys("Selenium");
 }
 catch(StaleElementReferenceException e){
    l = driver.findElement(By.id("gsc−i−id1"));
    l.sendKeys("Selenium");
    //obtain value entered
    String s= l.getAttribute("value");
    System.out.println("Value entered is: " +s);
 }

 */

