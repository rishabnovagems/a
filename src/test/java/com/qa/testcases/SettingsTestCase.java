package com.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBaseChild;

public class SettingsTestCase extends TestBaseChild{

	public SettingsTestCase() {
		super();
	}


	@BeforeMethod
	public void setUp() {	
		initialization();
		this.xy();

	}

	@Test(enabled=false)
	public void settingsTabTest() throws InterruptedException {		
		settingsPage.validatesettingsTabTest();

	}

	@Test(priority=1)
	public void weekStartTest() throws InterruptedException {		
		settingsPage.validatweekStartTest();

	}
	@Test(enabled =false)
	public void timeFormat () throws InterruptedException {		
		settingsPage.validatTimeFormatTest();

	}
	
	@Test(enabled =false)
	public void notificationSettingTest () throws InterruptedException {		
		settingsPage.validationNotificationSettingTest();

	}
	
	@Test(enabled=false)
	public void shiftSettingTest () throws InterruptedException {		
		settingsPage.validationShiftSettingTest();

	}
}
