package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class TC1_TC5_StaffPageTestCase {
	TC1_TC12_TestCase tc;
	
	public void staffPageTestCase() {
		tc= new TC1_TC12_TestCase();
		tc.setUp();  //Before Method
		
	}
	
	@Test
	public void staffTab() throws InterruptedException {
		this.staffPageTestCase();
		tc.staffTabTest();
		tc.tearDown();
		
	}
	
	@Test
	public void addStaff() throws InterruptedException {
		this.staffPageTestCase();
		tc.addStaffTest();
		tc.tearDown();

		
	}
	
	@Test
	public void editStaff() throws InterruptedException {
		tc.editStaffTest();
		tc.tearDown();

		
	}
	
	@Test
	public void archiveStaff() throws InterruptedException {
		this.staffPageTestCase();
		tc.archiveStaffTest();
		tc.tearDown();

		
	}
	
	@Test
	public void unArchiveStaff() throws InterruptedException {
		this.staffPageTestCase();
		tc.unAarchiveStaffTest();
		tc.tearDown();

		
	}

}
