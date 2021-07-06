package com.PRISM.Assessments;

import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.CreateAssessmentHelper;

public class TC2_Assessment extends CreateAssessmentHelper{

	@Test(priority=1, enabled = true)
	public void createMock() {
		gotoCreatepage();
		fillAssessmentDetails("Mock");
	}

	@Test(priority=2,enabled = true)
	public void createGroup() {
		gotoCreatepage();
		fillAssessmentDetails("group");
	}
	
	@Test(priority=3,enabled = true) 
	public void createRegular() {
		gotoCreatepage();
		fillAssessmentDetails("regular");
	}
	
	@Test(priority=4,enabled = true)
	public void createRecall() {
		gotoCreatepage();
		fillAssessmentDetails("recall");
	}
	
	@Test(priority=5,enabled = true)
	public void createFree() {
		gotoCreatepage();
		fillAssessmentDetails("free");
	}
}
