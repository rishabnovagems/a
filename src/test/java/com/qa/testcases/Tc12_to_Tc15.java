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

public class Tc12_to_Tc15 extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	StaffPage staffPage;
	SitePage sitePage;
	PatrolCarPage patrolPage;
	NewSchedulePage schedulePage;
	
	public Tc12_to_Tc15() {
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
	
	/*
	 * 
	@Test
	public void addMultipleEmailsTest() throws InterruptedException {
		sitePage.validateMultipleEmailsTest();
		//Dynamic Assertion pending
	}
	*
	*/
	
	/*
	@Test
	public void archiveSiteTest() throws InterruptedException {

		sitePage.validateArchiveSiteTest();
		//Assertion Pending
	}
	*/

	
	 
	
	
	@Test
	public void unArchiveSiteTest() throws InterruptedException {

		sitePage.validateUnArchiveSiteTest();
		//Assertion pending

	}

	
	@Test
	public void deleteSiteTest() throws InterruptedException {

		sitePage.validateDeleteSiteTest();
		//Assertion pending

	}
	
    
}
