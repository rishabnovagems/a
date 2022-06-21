package com.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
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

public class Tc7_to_Tc11 extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	StaffPage staffPage;
	SitePage sitePage;
	PatrolCarPage patrolPage;
	NewSchedulePage schedulePage;

	public Tc7_to_Tc11() {
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

	}
	
	//------------------------------------------------------------//
	
	@Test
	public void archiveStaffTest() throws InterruptedException {
		staffPage.validateArchiveStaffTest();
		//assertEquals(true, true);   // Tricky last step Assertion Pending		

	}

	@Test
	public void unAarchiveStaffTest() throws InterruptedException {  

		staffPage.validateUnArchiveStaffTest();
		//Assertion pending


	}

	@Test
	public void siteTabTest() throws InterruptedException {  

		sitePage.validateSiteTabTest();    

		//Done //confusion

	}

	@Test
	public void addSiteTest() throws InterruptedException {  

		sitePage.validateAddSiteTest();    //last step pending assertion R & d dynamic text
		//Assert.assertNotEquals(actual, expected, message); 

	}

	/* Pending Template change
	 * 
	 * 
	@Test
	public void editSiteTest() throws InterruptedException {
		sitePage.validateEditSiteTest();


	}
	*
	*
	*/
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
