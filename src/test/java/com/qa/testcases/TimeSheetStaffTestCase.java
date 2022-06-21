package com.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBaseChild;

public class TimeSheetStaffTestCase extends TestBaseChild{

	public TimeSheetStaffTestCase() {
		super();
	}

	
	@BeforeMethod
	public void setUp() {	
		initialization();
		this.xy();

	}  
	@Test(enabled=false)
	public void timeSheetTab() {
		timeSheetStaffPage.validatetimeSheetTabTest();

	}

	@Test(enabled=false)
	public void detailView() throws InterruptedException {
		timeSheetStaffPage.validatedetailViewTest();

	}

	@Test(enabled=false)
	public void timeSheetCalendar() throws InterruptedException {
		timeSheetStaffPage.validateTimeSheetCalendar() ;

	}
	
	
	@Test(priority=1)
	public void addPayrolColumn() throws InterruptedException {
		timeSheetStaffPage.validateAddPayrollHrsColumn() ;

	}
	
	// runing
	/*
	@Test(priority=1)
	public void editPayrolColumn() throws InterruptedException {
		timeSheetStaffPage.validateEditPayrolColumn() ;

	}
	
	@Test(priority=1)
	public void editPayrolColumn() throws InterruptedException {
		timeSheetStaffPage.validateEditPayrolColumn() ;

	}
	*/
}
