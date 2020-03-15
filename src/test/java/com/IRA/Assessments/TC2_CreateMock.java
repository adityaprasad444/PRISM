package com.IRA.Assessments;

import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CreateAssessmentHelper;

public class TC2_CreateMock extends CreateAssessmentHelper{

	@Test(priority=1)
	public void createMock() {
		gotoCreatepage();
		fillAssessmentDetails("Mock");

	}

	@Test(priority=2)
	public void createRegular() { 
		gotoCreatepage();
		fillAssessmentDetails("regular");
	}

	@Test(priority=3)
	public void createGroup() {
		gotoCreatepage();
		fillAssessmentDetails("Group");

	}

	@Test(priority=4)
	public void createRecall() { 
		gotoCreatepage();
		fillAssessmentDetails("recall");

	}

}
