package com.qa.testcases;

import org.testng.annotations.Test;

public class TC6_Tc9_SiteTestCase extends TC1_TC5_StaffPageTestCase {
	
	
	@Test
	public void siteTab() throws InterruptedException {
		this.staffPageTestCase();
		tc.siteTabTest();
		tc.tearDown();


	}

	@Test
	public void addSite() throws InterruptedException {
		this.staffPageTestCase();
		tc.addSiteTest();
		tc.tearDown();


	}

	@Test
	public void editSite() throws InterruptedException {
		this.staffPageTestCase();
		tc.editSiteTest();
		tc.tearDown();


	}

	@Test
	public void multipleEmail() throws InterruptedException {
		this.staffPageTestCase();
		tc.addMultipleEmailsTest();
		tc.tearDown();


	}

	
}
