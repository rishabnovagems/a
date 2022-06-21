package com.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testcases.FreeCrmTest;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(enabled=false)
	public void loginPageTitleTest() {
		/*
		 * String title = loginPage.validateLoginPageTitle(); Assert.assertEquals(title,
		 * "#1 Free CRM for Any Business: Online Customer Relationship Software");
		 */
		System.out.println("Inside login");
		loginPage.login("Abhinav", "test@123");
	}


	@Test(priority=1)   
	public void homePage() throws InterruptedException{

		System.out.println("Inside login");
		loginPage.login("Abhinav", "test@123");
		String expected="Staff";
		
		//assertEquals(this.actual, expected);



	}


	/*
	 * @Test(priority=2) public void crmLogoImageTest(){ boolean flag =
	 * loginPage.validateCRMImage(); Assert.assertTrue(flag); }
	 */

	/*
	 * @Test(priority=2) public void loginTest(){ homePage =
	 * loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 * }
	 */


	//	@AfterMethod
	//	public void tearDown() {
	//		driver.quit();
	//	}

}
