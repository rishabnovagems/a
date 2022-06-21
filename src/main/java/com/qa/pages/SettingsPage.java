package com.qa.pages;


import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.NoSuchElementException;

//import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;
import com.qa.base.TestBaseChild;

public class SettingsPage extends TestBase{

	JavascriptExecutor js;
	WebDriverWait wait;
	Random randomGenerator;
	int randomInt;
	int randomIntLong;
	String uuid;
	Actions action; 
	Select select;


	public SettingsPage() {
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



	//    //div[@class='toolbar-icons ng-star-inserted']
	@FindBy(xpath="//mat-toolbar[@class='p-0 mat-elevation-z1 login_hidden mat-toolbar mat-toolbar-single-row ng-star-inserted']//img[@routerlink]")  // //mat-toolbar[@class='p-0 mat-elevation-z1 login_hidden mat-toolbar mat-toolbar-single-row ng-star-inserted']//img[@routerlink]  //    //img[@routerlink='/view-settings']   //   ((//div[@fxlayoutalign='start center'])[3]//div[1])[1]
	//     //div[@class='toolbar-icons ng-star-inserted']
	public WebElement settingsLogo;

	public void validatesettingsTabTest() throws InterruptedException {
		//settingsLogo.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(settingsLogo)).click();


	}

	@FindBy(xpath="//select[@class='ng-pristine ng-valid ng-touched']")
	public WebElement weekDays;

	public void validatweekStartTest() throws InterruptedException {
		Thread.sleep(4000);
		this.validatesettingsTabTest();

		//js.executeScript("arguments[0].click();", settingsLogo);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//select")).click();

		WebElement osne=driver.findElement(By.xpath("//select[@class='ng-pristine ng-valid ng-touched']"));
		select =new Select(osne);

		select.selectByVisibleText("Saturday");



	}

	@FindBy(xpath="//li[text()=\" Time Format \"]")
	public WebElement timeFormat;
	@FindBy(xpath="//option")
	public WebElement time;
	@FindBy(xpath="//div[@class='selectBlock']")
	public WebElement block;

	public void validatTimeFormatTest() throws InterruptedException {
		Thread.sleep(4000);

		js.executeScript("arguments[0].click();", settingsLogo);
		Thread.sleep(1500);
		timeFormat.click();
		block.click();
		Thread.sleep(2000);
		//select=new Select(time);
		//select.selectByVisibleText("AM-PM Time - 05:00p");
		List<WebElement> allOptions = driver.findElements(By.xpath("//option"));
		System.out.println(allOptions.size());
		for(int i = 0; i<=allOptions.size()-1; i++) {

			if(allOptions.get(i).getText().contains("AM-PM Time - 05:00p")) {

				allOptions.get(i).click();

				break;

			}
		}
	}

	@FindBy(xpath="//li[contains(text(),'Notifications')]") 
	public WebElement notificationSetting;
	@FindBy(xpath="(//div[contains(@class,'mat-slide-toggle-thumb')])[2]") 
	public WebElement toggle;

	public void validationNotificationSettingTest() throws InterruptedException {
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(settingsLogo)).click();

		//	js.executeScript("arguments[0].click()", settingsLogo);
		notificationSetting.click();
		toggle.click();
	}

	@FindBy(xpath="//li[contains(text(),'Shift Settings')]") 
	public WebElement shiftSettings;

	@FindBy(xpath="//mat-checkbox[@id='mat-checkbox-1']") 
	public WebElement allowStaff;

	public void validationShiftSettingTest() throws InterruptedException {
		Thread.sleep(6000);

		//js.executeScript("arguments[0].scrollIntoView(true);",settingsLogo);
		//settingsLogo.click();
		settingsLogo.click();
		shiftSettings.click();
		allowStaff.click();


	}

}
