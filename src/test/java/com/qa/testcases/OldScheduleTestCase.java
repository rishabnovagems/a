package com.qa.testcases;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.base.TestBaseChild;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.NewSchedulePage;
import com.qa.pages.OldSchedulePage;
import com.qa.pages.PatrolCarPage;
import com.qa.pages.ProfilePage;
import com.qa.pages.SitePage;
import com.qa.pages.StaffPage;
import com.qa.pages.StaffViewPage;

public class OldScheduleTestCase extends TestBaseChild {
	

	public OldScheduleTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {	
		initialization();
		this.xy();
		

	}
	
	@FindBy(className="s-16 mat-icon notranslate material-icons mat-icon-no-color")
	public WebElement hoverProfile;
	
	@Test
	public void oldSchedulePublishShiftTest() throws InterruptedException {		
		oldSchedulePage.validateOldSchedulePublishShiftTest();
		
	}

	



}


