package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewSchedulePage;
import com.qa.pages.PatrolCarPage;
import com.qa.pages.ProfilePage;
import com.qa.pages.SitePage;
import com.qa.pages.StaffPage;
import com.qa.pages.StaffViewPage;

public class NewScheduleTestCase extends TestBase {
	//	private static final int enabled = 0;
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	StaffPage staffPage;
	SitePage sitePage;
	PatrolCarPage patrolPage;
	NewSchedulePage schedulePage;
	StaffViewPage staffViewPage;

	public NewScheduleTestCase() {
		super();
	}

	
	
	@BeforeMethod
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage("garry", "123456");
		staffPage=new StaffPage();
		sitePage=new SitePage();
		patrolPage=new PatrolCarPage();
		schedulePage =new NewSchedulePage();
		staffViewPage=new StaffViewPage();

	}

	@Test(priority=1)
	public void publishShiftTest() throws InterruptedException {

		schedulePage.validatePublishShiftTest();

	}

	@Test(enabled=false)
	public void deleteShiftTest() throws InterruptedException {

		schedulePage.validateDeleteShiftTest();

	}

	@Test(enabled=false)
	public void uNPublishShiftTest() throws InterruptedException {

		schedulePage.validateuNPublishShiftTest();

	}

	@Test(enabled=false)
	public void saveShiftTest() throws InterruptedException {

		schedulePage.validateSaveShiftTest();

	}

	@Test(enabled=false)    //not working
	public void repeatShiftTest() throws InterruptedException {

		schedulePage.validateRepeatShiftTest();

	}

	@Test (enabled=false)   //not working
	public void dragAndDropShiftTest() throws InterruptedException {

		schedulePage.validateDragAndDropShiftTest();



	}
}
//-------------------------Staff View----------------------------//
