package com.qa.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class SitePage extends TestBase {


	JavascriptExecutor js;
	WebDriverWait wait;
	Random randomGenerator;
	int randomInt;
	int randomIntLong;
	String uuid;
	Actions action;

	public  SitePage() {

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


	@FindBy(xpath="//a[text()=' Sites ']")
	WebElement navigationSites;

	
	//   //div[@class='mat-tab-link-container']//a[contains(text(),'Sites')]/..
	//    //a[text()=' Sites ']
	//     //div[@class='mat-tab-link-container']//a[contains(text(),'Sites')]/..
	
	
	@FindBy(xpath="//i[text()='location_on']")   ////div[@class="guard_floatIcon_button ng-star-inserted"]//child::i[text()='person_add ']
	public WebElement site_add_details;

	@FindBy(id="sitename")
	WebElement sitename;

	@FindBy(id="siteAddress")
	WebElement siteaddress;

	@FindBy(xpath="//button[@class='save-button mat-focus-indicator mat-raised-button mat-button-base mat-accent ng-star-inserted']")
	WebElement createboundaries;

	@FindBy(xpath="//button[@class='apply btn1 newFinish mat-focus-indicator mat-button mat-button-base faded']")
	WebElement finishbutton;

	public void validateSiteTabTest() throws InterruptedException {
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOf(navigationSites)).click(); 
		Thread.sleep(2000);	
		String actual= navigationSites.getText();		
		System.out.println(actual);
		String expected="Sites";
		assertEquals(actual, expected);

	}

	@FindBy(xpath="//i[text()='add']")
	public WebElement staffloatingIcon;

	public void validateAddSiteTest() throws InterruptedException {
		
		List<WebElement> allOptions = driver.findElements(By.xpath("//a[@class='smalltab mat-tab-link mat-focus-indicator']|//a[text()='Sites']"));
		
		// //a[@class='smalltab mat-tab-link mat-focus-indicator']
		
		//  //a[@class='smalltab mat-tab-link mat-focus-indicator']|//a[text()='Sites']
		
		// //a[@class='smalltab mat-tab-link mat-focus-indicator']|//a[text()='Sites']
		
        System.out.println(allOptions.size());
        
        for(int i = 0; i<=allOptions.size()-1; i++) {
                      Thread.sleep(1500);
            if(allOptions.get(i).getText().contains("Sites")) {
            	System.out.println("xx");
                 
                allOptions.get(i).click();
                
                break;
                 
            }
        }		
        
		action.moveToElement(staffloatingIcon).perform();
		wait.until(ExpectedConditions.elementToBeClickable(site_add_details)).click(); 
		sitename.sendKeys("Novagems"+uuid);
		siteaddress.sendKeys(randomInt+" " +" canada" );
		wait.until(ExpectedConditions.elementToBeClickable(siteaddress)).click(); 
		Thread.sleep(2000);
		action.moveToElement(siteaddress).sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(1000);
		action.moveToElement(siteaddress).sendKeys(Keys.ENTER).perform();
		js.executeScript("arguments[0].scrollIntoView();", createboundaries);
		wait.until(ExpectedConditions.elementToBeClickable(createboundaries)).click(); 
		finishbutton.click();

	}

	@FindBy(xpath="(//mat-icon[text()='drive_file_rename_outline'])[1]")
	WebElement velipses_editsite;

	@FindBy(id="updatesiteinfobtn")
	WebElement save_site;

	@FindBy(className="heading mrg_tb_75")
	WebElement get_site_name;

	@FindBy(id="email_address")
	WebElement email;

	@FindBy(xpath="//span[text()='Edit']")
	public WebElement edit;

	public void validateEditSiteTest() throws InterruptedException{
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.elementToBeClickable(navigationSites)).click(); 
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(navigationSites));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		//	get_site_name.getText();
		//System.out.println(get_site_name.getText());
		velipses_editsite.click();
		//edit.click();
		sitename.clear();
		sitename.sendKeys("NovaQA"+randomInt);
		email.sendKeys("xyz"+randomInt+"@gmail.com"+","+"abc"+randomInt+"@gmail.com");	
		save_site.click();
	}

	public void validateMultipleEmailsTest() throws InterruptedException {
		this.validateEditSiteTest();

	}

	@FindBy(xpath="(//div[@class='company-info-more-menu'])[1]/button")//(//div[@class='company-info-more-menu'])[1]
	WebElement sitelistingVelipses;		
	@FindBy(id="archiveSitebtn")
	WebElement archive_Site_button;
	@FindBy(xpath="//span[text()='YES']")
	WebElement Button;

	public void validateArchiveSiteTest() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(navigationSites)).click();
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", navigationSites);
		//w1.click();

		
		wait.until(ExpectedConditions.elementToBeClickable(sitelistingVelipses));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", sitelistingVelipses);
		//sitelistingVelipses.click();

		Thread.sleep(3500);
		wait.until(ExpectedConditions.elementToBeClickable(archive_Site_button)).click();
		Thread.sleep(3500);
		wait.until(ExpectedConditions.elementToBeClickable(archive_Site_button)).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(Button)).click();


	}

	@FindBy(xpath="//img[@class='icon-dashboard mr-0 mr-sm-16 gray']")
	WebElement archive_site_logo1;

	@FindBy(xpath="((//div[@class='company-info-pro-text'])/following-sibling::div/descendant::mat-icon)[1]")
	WebElement velipses1;

	@FindBy(xpath="//span[text()='Unarchive Site']")
	WebElement unarchive_Site;

	public void validateUnArchiveSiteTest() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(navigationSites)).click(); 
		//((JavascriptExecutor)driver).executeScript("arguments[0].click();", element1);
		//wait.pollingEvery(Duration.ofSeconds(2));
		//element1.click();
		Thread.sleep(4000);
		WebElement click2=wait.until(ExpectedConditions.elementToBeClickable(archive_site_logo1)); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", click2);

		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(velipses1)).click(); 

		//velipses1.click();
		unarchive_Site.click();

	}

	@FindBy(id="deletesitebtn")
	WebElement delete;
	public void validateDeleteSiteTest() throws InterruptedException {
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.elementToBeClickable(navigationSites)).click(); 
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(navigationSites));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(archive_site_logo1)).click();
		//wait.pollingEvery(Duration.ofSeconds(2));
		Thread.sleep(2000);
		//archive_site_logo1.click();
		velipses1.click();
		delete.click();

	}


}
