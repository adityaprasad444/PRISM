package com.IRA.Assessments;

import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CreateAssessmentHelper;

public class TC2_CreateMock extends CreateAssessmentHelper{

	@Test
	public void createMock() {
		gotoCreatepage();
		fillAssessmentDetails("Regular");
	}
}
