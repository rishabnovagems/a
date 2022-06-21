package com.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewSchedulePage;
//import com.qa.pages.PatrolCar;
import com.qa.pages.PatrolCarPage;
import com.qa.pages.ProfilePage;
import com.qa.pages.SitePage;
import com.qa.pages.StaffPage;



public class TC1_TC12_TestCase extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	StaffPage staffPage;
	SitePage sitePage;
	PatrolCarPage patrolPage;
	NewSchedulePage schedulePage;

	public TC1_TC12_TestCase() {
		super();
	}
	

	
	
	@BeforeMethod
	//@Test(priority=1)
	public void setUp() {
		initialization();
		//WebElement a=driver.findElement(By.xpath("//h1[text()='Login with Novagems']"))	;		
		//String actualLoginScreenTitle = driver.getTitle();		
		//assertEquals(actualLoginScreenTitle, "Novagems Manager");
		loginPage = new LoginPage("garry", "123456");
		staffPage=new StaffPage();
		sitePage=new SitePage();
		patrolPage=new PatrolCarPage();
		schedulePage =new NewSchedulePage();

	}
	
	

	//fetch the text from diff class
	
	@Test   (enabled = false)
	public void loginTest() throws InterruptedException{

		Thread.sleep(2000);
		String actual=driver.findElement(By.xpath("//div[text()='Staff']")).getText();
		System.out.println(actual);
		String expected="Staff";
		AssertJUnit.assertEquals(actual, expected);

	}


	@Test(enabled = false)
	public void staffTabTest() throws InterruptedException {

		this.loginTest();
	}
	

	@Test(enabled = false)  	
	public void logoutTest() throws InterruptedException{
		profilePage=new ProfilePage();
		profilePage.validatelogoutTest();
		String actual1=driver.getTitle();
		System.out.println(actual1);
		String expected1 ="Novagems Manager";
		AssertJUnit.assertEquals(actual1, expected1);

	}

	@Test (enabled = false)
	public void addStaffTest() throws InterruptedException {
		//staffPage=new StaffPage(driver);
		//Thread.sleep(2000);
		staffPage.validateAddStaff();	
		//Assert pending not able to handle success popupn after add staff
		//String actual_staff_Added=staff_Successfully_Added.getText();

	}

	@Test(enabled = false)
	public void editStaffTest() throws InterruptedException {

		staffPage.validateEditStaffTest();	
		//Done

	}

	@Test(enabled = false)
	public void archiveStaffTest() throws InterruptedException {
		staffPage.validateArchiveStaffTest();
		AssertJUnit.assertEquals(true, true);   // Tricky last step Assertion Pending		

	}

	@Test(enabled = false)
	public void unAarchiveStaffTest() throws InterruptedException {  

		staffPage.validateUnArchiveStaffTest();
		//Assertion pending


	}

	@Test(enabled = false)
	public void siteTabTest() throws InterruptedException {  

		sitePage.validateSiteTabTest();    

		//Done //confusion

	}

	@Test(priority=1)
	public void addSiteTest() throws InterruptedException {  

		sitePage.validateAddSiteTest();    //last step pending assertion R & d dynamic text
		//Assert.assertNotEquals(actual, expected, message); 

	}

	@Test(enabled = false)
	public void editSiteTest() throws InterruptedException {
		sitePage.validateEditSiteTest();


	}

	@Test(enabled = false)
	public void addMultipleEmailsTest() throws InterruptedException {
		sitePage.validateMultipleEmailsTest();
		//Dynamic Assertion pending
	}
	
	
	
	@Test(enabled = false)
	public void archiveSiteTest() throws InterruptedException {

		sitePage.validateArchiveSiteTest();
		//Assertion Pending
	}

	
	
	@Test(enabled = false)
	public void unArchiveSiteTest() throws InterruptedException {

		sitePage.validateUnArchiveSiteTest();
		//Assertion pending

	}	

	
	@Test(enabled = false)
	public void deleteSiteTest() throws InterruptedException {

		sitePage.validateDeleteSiteTest();
		//Assertion pending

	}
	
	@Test(enabled = false)
	public void addPatrolCarTest() throws InterruptedException {

		patrolPage.validateAddPatrolCarTest();
		

	}
	
	
	@Test(enabled = false)
	public void publishShiftTest() throws InterruptedException {

		schedulePage.validatePublishShiftTest();
		
	}
	
	@Test(enabled = false)
	public void uNPublishShiftTest() throws InterruptedException {

		schedulePage.validateuNPublishShiftTest();
		
	}
	/*
	@Test(enabled = false)
       public void loginPageTitleTest() {

		 String title = loginPage.validateLoginPageTitle(); Assert.assertEquals(title,
		  "#1 Free CRM for Any Business: Online Customer Relationship Software");

	//	System.out.println("Inside login");
		//loginPage.login("Abhinav", "test@123");
	}
	*/


	/*
	 * @Test(priority=2) public void crmLogoImageTest(){ boolean flag =
	 * loginPage.validate CRMImage(); Assert.assertTrue(flag); }
	 */

	
	/*
	 * @Test(priority=2) public void loginTest(){ homePage =
	 * loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 * }
	 *
	 */
	
	
	//@AfterMethod
	//public void tearDown() {
		//driver.quit();
//	}

}
