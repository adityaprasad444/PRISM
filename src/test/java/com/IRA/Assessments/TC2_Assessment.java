package com.IRA.Assessments;

import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CreateAssessmentHelper;

public class TC2_Assessment extends CreateAssessmentHelper{

	@Test(enabled=true)
	public void createMock() {
		gotoCreatepage();
		fillAssessmentDetails("Mock");

	}

	@Test(enabled=false)
	public void createRegular() {
		gotoCreatepage();
		fillAssessmentDetails("regular");
	}

	@Test(enabled=false)
	public void createGroup() {
		gotoCreatepage();
		fillAssessmentDetails("group");

	}

	@Test(enabled=false)
	public void createRecall() {
		gotoCreatepage();
		fillAssessmentDetails("recall");

	}
	
	@Test(enabled=false)
	public void createFree() {
		gotoCreatepage();
		fillAssessmentDetails("free");

	}
}
