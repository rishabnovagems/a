package com.qa.pages;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class TimeSheetStaffPage extends TestBase {
	JavascriptExecutor js;
	WebDriverWait wait;
	Random randomGenerator;
	int randomInt;
	int randomIntLong;
	String uuid;
	Actions action; 
	Select select;

	public TimeSheetStaffPage() {
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
	public WebElement stafffloatingIcon; 
	@FindBy(xpath="//nav[@class='floatcontainer']//a[@href='#/guard-payroll']")
	public WebElement timeSheetlogo;

	// 

	public void validatetimeSheetTabTest() {
		System.out.println("xxxxxxxxxxxxxxxx");
		action.moveToElement(stafffloatingIcon).perform();
		wait.until(ExpectedConditions.visibilityOf(timeSheetlogo)).click();

	}

	@FindBy(xpath="//div[@class='detail-view pointer mat-menu-trigger']/mat-icon")
	public WebElement summaryView;
	@FindBy(xpath="//mat-icon[text()='chrome_reader_mode']")
	public WebElement detailView;

	public void validatedetailViewTest() throws InterruptedException {
		this.validatetimeSheetTabTest();
		summaryView.click();
		//Thread.sleep(1500);
		detailView.click();

	}
	
	@FindBy(xpath="//div[@class='filter-date pointer ml-25 mat-menu-trigger']")
	public WebElement dateListIcon;
	
	public void validateTimeSheetCalendar() throws InterruptedException {
		this.validatetimeSheetTabTest();
		dateListIcon.click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//button[@class='mat-focus-indicator mat-menu-item']"));
        System.out.println(allOptions.size());
        
        for(int i = 0; i<=allOptions.size()-1; i++) {
                      Thread.sleep(1500);
            if(allOptions.get(i).getText().contains("Today")) {
            	System.out.println("xx");
                 
                allOptions.get(i).click();
                
                break;
                 
            }
        }		
	}

	
	@FindBy(xpath="//div[@class='table-action pointer pointer ml-25 mat-menu-trigger']")
	public WebElement tableAction;
	@FindBy(xpath="//mat-checkbox[@class='mat-checkbox mat-primary ng-valid ng-dirty ng-touched']")
	public WebElement tableAction;
	
	public void validateAddPayrollHrsColumn() throws InterruptedException {
		this.validatetimeSheetTabTest();
		tableAction.click();
		List<WebElement> allOptions = driver.findElements(By.xpath("//button[@class='mat-focus-indicator mat-menu-item']"));
        System.out.println(allOptions.size());
        
        for(int i = 0; i<=allOptions.size()-1; i++) {
                      //Thread.sleep(1500);
            if(allOptions.get(i).getText().contains("Edit Columns")) {
            	System.out.println("xx");
                 
                allOptions.get(i).click();
                
                break;
                 
            }
        }	
		Thread.sleep(1000);
		
		
		
		
		
	}

	public void validateEditPayrolColumn() {
		this.validatetimeSheetTabTest();
		
		
	}
	
	public void exportStaffTimeSheet() {
		this.validateExportStaffTimeSheet();
		
		
	}

	private void validateExportStaffTimeSheet() {
		// TODO Auto-generated method stub
		
	}
}
