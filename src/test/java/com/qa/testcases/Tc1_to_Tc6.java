package com.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
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

public class Tc1_to_Tc6 extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	StaffPage staffPage;
	SitePage sitePage;
	PatrolCarPage patrolPage;
	NewSchedulePage schedulePage;
	
	public Tc1_to_Tc6() {
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
	
	

	//fetch the text from diff class
	
	@Test   
	public void loginTest() throws InterruptedException{

		Thread.sleep(2000);
		String actual=driver.findElement(By.xpath("//div[text()='Staff']")).getText();
		System.out.println(actual);
		String expected="Staff";
		assertEquals(actual, expected);

	}


	@Test
	public void staffTabTest() throws InterruptedException {

		this.loginTest();
	}
	

	@Test(priority=3)   	
	public void logoutTest() throws InterruptedException{
		profilePage=new ProfilePage();
		profilePage.validatelogoutTest();
		String actual1=driver.getTitle();
		System.out.println(actual1);
		String expected1 ="Novagems Manager";
		assertEquals(actual1, expected1);

	}
	
	@Test 
	public void addStaffTest() throws InterruptedException {
		//staffPage=new StaffPage(driver);
		//Thread.sleep(2000);
		staffPage.validateAddStaff();	
		//Assert pending not able to handle success popupn after add staff
		//String actual_staff_Added=staff_Successfully_Added.getText();

	}
	
	@Test
	public void editStaffTest() throws InterruptedException {

		staffPage.validateEditStaffTest();	
		//Done

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
