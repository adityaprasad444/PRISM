package com.IRA.Assessments;

import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CreateAssessmentHelper;

public class TC2_Assessment extends CreateAssessmentHelper{

	@Test(priority=1)
	public void createMock() {
		gotoCreatepage();
		fillAssessmentDetails("Mock");
	}

	@Test(priority=2)
	public void createGroup() {
		gotoCreatepage();
		fillAssessmentDetails("group");
	}
	
	@Test(priority=3) //(enabled = false) 
	public void createRegular() {
		gotoCreatepage();
		fillAssessmentDetails("regular");
	}
	
	@Test(priority=4) //(enabled = false)
	public void createRecall() {
		gotoCreatepage();
		fillAssessmentDetails("recall");
	}
	
	@Test(priority=5) //(enabled = false)
	public void createFree() {
		gotoCreatepage();
		fillAssessmentDetails("free");
	}
}
