package com.qa.base;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewSchedulePage;
import com.qa.pages.OldSchedulePage;
import com.qa.pages.PatrolCarPage;
import com.qa.pages.ProfilePage;
import com.qa.pages.SettingsPage;
import com.qa.pages.SitePage;
import com.qa.pages.StaffPage;
import com.qa.pages.StaffViewPage;
import com.qa.pages.TimeSheetStaffPage;

public class TestBaseChild extends TestBase {
	
	public LoginPage loginPage;
	public HomePage homePage;
	public ProfilePage profilePage;
	public StaffPage staffPage;
	public SitePage sitePage;
	public PatrolCarPage patrolPage;
	public NewSchedulePage schedulePage;
	public StaffViewPage staffViewPage;
	public OldSchedulePage oldSchedulePage;
	public SettingsPage settingsPage;
	public TimeSheetStaffPage timeSheetStaffPage;

	public JavascriptExecutor js;
	public WebDriverWait wait;
	public	Random randomGenerator;
	public int randomInt;
	public int randomIntLong;
	public String uuid;
	public Actions action;

	 
	public TestBaseChild() {
		
		super();
	}
	
	public void xy() {
		loginPage = new LoginPage("Rishab", "Gmail@novagems");
		staffPage=new StaffPage();
		sitePage=new SitePage();
		patrolPage=new PatrolCarPage();
		schedulePage =new NewSchedulePage();
		staffViewPage=new StaffViewPage();
		oldSchedulePage =new OldSchedulePage();
		settingsPage=new SettingsPage();
		timeSheetStaffPage=new TimeSheetStaffPage();
		action =new Actions(driver);
		wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
	//	wait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) driver;
		randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(1000);
		randomIntLong = randomGenerator.nextInt(1000000000);
		uuid = UUID.randomUUID().toString();
	}
	
	
	
}
