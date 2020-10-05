package com.IRA.Assessments;

import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CreateAssessmentHelper;

public class TC2_Assessment extends CreateAssessmentHelper{

	@Test(enabled = false)
	public void createMock() {
		gotoCreatepage();
		fillAssessmentDetails("Mock");
	}

	@Test(enabled=false)
	public void createGroup() {
		gotoCreatepage();
		fillAssessmentDetails("group");
	}
	
	@Test(priority=3)
	public void createRegular() {
		gotoCreatepage();
		fillAssessmentDetails("regular");
	}
	
	@Test(priority=4)
	public void createRecall() {
		gotoCreatepage();
		fillAssessmentDetails("recall");
	}
	
	@Test(priority=5)
	public void createFree() {
		gotoCreatepage();
		fillAssessmentDetails("free");
	}
}
