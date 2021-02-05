package com.IRA.Assessments;

import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CreateAssessmentHelper;

public class TC2_Assessment extends CreateAssessmentHelper{

	@Test(enabled = false) //(priority=1)
	public void createMock() {
		gotoCreatepage();
		fillAssessmentDetails("Mock");
	}

	@Test(enabled = false)//(priority=2)
	public void createGroup() {
		gotoCreatepage();
		fillAssessmentDetails("group");
	}
	
	@Test(enabled = true) 
	public void createRegular() {
		gotoCreatepage();
		fillAssessmentDetails("regular");
	}
	
	@Test(enabled = false)//(priority=4)
	public void createRecall() {
		gotoCreatepage();
		fillAssessmentDetails("recall");
	}
	
	@Test(enabled = false)//(priority=5)
	public void createFree() {
		gotoCreatepage();
		fillAssessmentDetails("free");
	}
}
