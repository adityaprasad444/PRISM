package com.PRISM.Assessments;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.CreateAssessmentHelper;

public class TC2_Assessment extends CreateAssessmentHelper{

	@Test(priority=1, enabled = true)
	public void createMock() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("Mock");
	}

	@Test(priority=2,enabled = false)
	public void createGroup() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("group");
	}
	
	@Test(priority=3,enabled = false) 
	public void createRegular() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("regular");
	}
	
	@Test(priority=4,enabled = false)
	public void createRecall() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("recall");
	}
	
	@Test(priority=5,enabled = false)
	public void createFree() throws FileNotFoundException {
		gotoCreatepage();
		fillAssessmentDetails("free");
	}
}
