package com.qa.testcases;

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

public class StaffViewTestCase extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	StaffPage staffPage;
	SitePage sitePage;
	PatrolCarPage patrolPage;
	NewSchedulePage schedulePage;
	StaffViewPage staffViewPage;
	
	public StaffViewTestCase() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage("Rishab", "Gmail@novagems");
		staffPage=new StaffPage();
		sitePage=new SitePage();
		patrolPage=new PatrolCarPage();
		schedulePage =new NewSchedulePage();
		staffViewPage=new StaffViewPage();

	}
	
	@Test (priority=1)       // if - else condition pending not working
	public void staffViewPublishShiftTest() throws InterruptedException {

		staffViewPage.validateStaffViewPublishShiftTest();
		
		
    }
}


