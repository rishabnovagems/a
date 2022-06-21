package com.qa.pages;

import static org.testng.Assert.assertNotEquals;

import java.time.Duration;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

//import Locators.xyz;

public class StaffPage extends TestBase {
	
	Actions action;
	

	JavascriptExecutor js;
	WebDriverWait wait;
	Random randomGenerator;
	int randomInt;
	int randomIntLong;
	String uuid;



	@FindBy(xpath="//i[text()='add']")
	public WebElement stafffloatingIcon;

	@FindBy(xpath="//i[text()='person_add ']")   ////div[@class="guard_floatIcon_button ng-star-inserted"]//child::i[text()='person_add ']
	public WebElement person_add;

	@FindBy(id="firstname")
	public WebElement first_Name;

	@FindBy(id="lastname")
	public WebElement last_Name;

	@FindBy(id="phone_number")
	WebElement phone_Number;

	@FindBy(id="licenceNumber")
	public WebElement licenceNumber;

	@FindBy(id="licenceNumber")
	public WebElement employee_id;

	@FindBy(id="nextbtn")
	public WebElement next_btn;

	@FindBy(xpath=" //span[text()=' Add Staff ']")
	public WebElement add_Staff;

	@FindBy(xpath="(//button[@id=\"nextbtn\"])[2]")
	public WebElement next_btn2;

	@FindBy(xpath="//span[text()=' Add Staff ']")
	public WebElement addStaff;

	@FindBy(className="menu-br mat-focus-indicator mat-menu-trigger mat-icon-button mat-button-base")
	public WebElement verticalElipses;

	@FindBy(xpath="//span[text()='Edit']")
	public WebElement edit;
	@FindBy(id="firstname")

	public WebElement fname;
	@FindBy(id="lastname")

	public WebElement lname;
	@FindBy(id="emailaddress")

	public WebElement email_Address;
	//WebElement Category_Body = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));

	@FindBy(id="phone_number")
	public WebElement pnumber;

	@FindBy(xpath="//span[text()=' SAVE ']")
	public WebElement save;

	@FindBy(className="//body")
	public WebElement overlay;

	@FindBy(xpath="//div[@class=\"mobile-margin\"]//child::button")
	public WebElement Velipses;   //.margin-bottom-mobile .menu-br
	private Object console;

	
	public StaffPage() {
		PageFactory.initElements(driver, this);
		action =new Actions(driver);
		wait = new WebDriverWait(driver, 100);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 80);
		js = (JavascriptExecutor) driver;
		randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(100000);
		randomIntLong = randomGenerator.nextInt(100000000);
		uuid = UUID.randomUUID().toString();



	}
	
	public void validateAddStaff() throws InterruptedException {
		System.out.println("xxxxxxxxxxxxxxxx");
		action.moveToElement(stafffloatingIcon).perform();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(person_add)).click();
		first_Name.sendKeys("QAFname"+randomInt);
		last_Name.sendKeys("lname"+randomInt);
		phone_Number.sendKeys("phno"+randomIntLong);
		Thread.sleep(1500);
		licenceNumber.sendKeys("lcno"+randomInt);
		employee_id.sendKeys("empid"+randomInt);
		js.executeScript("arguments[0].scrollIntoView();", next_btn);
		next_btn.click();
		next_btn2.click();
		add_Staff.click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.id("mat-dialog-0"));
		action.moveToElement(element).sendKeys(Keys.ESCAPE).perform();

		

	} 
	
	@FindBy(xpath="//p[@class='heading mrg_tb_75 color-tittle']")
	WebElement staff_name_text;
	
	public void validateEditStaffTest() throws InterruptedException {
		Thread.sleep(2000);

		String actual=staff_name_text.getText();
		System.out.println(actual);

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(Velipses)).click(); 
		edit.click(); 
		fname.clear();
		lname.clear();
		fname.sendKeys("Nova"+randomInt);
		lname.sendKeys("gems"+randomInt);
		Thread.sleep(2000);		
		js.executeScript("arguments[0].scrollIntoView();", save);
		save.click();

		js.executeScript("arguments[0].scrollIntoView();",staff_name_text );
		Thread.sleep(2000);

		String expected =staff_name_text.getText();
		Thread.sleep(2000);
		System.out.println(expected);

		assertNotEquals(actual, expected);
		//assertEquals(actual, expected);

	}
	
	@FindBy(xpath="(//mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color'])[2]")    //
	WebElement elipsesStaffListing;

	@FindBy(xpath="//span[text()=\"Archive\"]")    //
	WebElement archiveStaff;

	@FindBy(xpath="//span[text()='Ok']")    //
	WebElement okButton;

	@FindBy(id="mat-badge-content-12")    //
	WebElement count;
	
	@FindBy(xpath="//img[@class='icon-dashboard mr-0 mr-sm-16 gray']")    //(//div[@class='maticon-more'])[1]
	WebElement archiveLogo;
	
	
	public void validateArchiveStaffTest() throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(elipsesStaffListing)).click(); 
		archiveStaff.click();
		okButton.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(archiveLogo)).click(); 
		//wait.pollingEvery(Duration.ofSeconds(2));		
	}
	
	
	@FindBy(xpath="(//div[@class='archived-left']/following-sibling::div[@class='maticon-more'])[1]")
	WebElement velipses; 

	@FindBy(xpath="//div[@class='mat-menu-content']//descendant::span[text()='Unarchive']")    //(//div[@class='maticon-more'])[1]
	WebElement unarchiveText;


	@FindBy(xpath="//span[text()='Ok']")
	WebElement unarchiveOk ;

	@FindBy(xpath="(//div[@class='archived-left']/following-sibling::div[@class='maticon-more'])[1]/..//div[@class='archived-title']")
	WebElement text ;

	
	public void validateUnArchiveStaffTest() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(archiveLogo)).click(); 
		//archiveLogo.click();
		text.getText();
		System.out.println(text.getText());
		
		velipses.click();
		unarchiveText.click();             
		unarchiveOk.click();
	}



	
}
