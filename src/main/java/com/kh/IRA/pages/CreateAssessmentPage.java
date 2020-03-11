package com.kh.IRA.pages;

import com.kh.IRA.utilities.Configreader;

public class CreateAssessmentPage {


	Configreader cr;
	public CreateAssessmentPage() {

		String proppath="//src//main//resources//com//kh//IRA//Locators//CreateAssessment.properties";
		cr=new Configreader(proppath);
	}

	public  String createAssessment() {
		return cr.getProperty("createAssessment");
	}
	
	public  String assessmetName() {
		return cr.getProperty("Name");
	}
	
	public  String assessmentDescription() {
		return cr.getProperty("Description");
	}

	public  String assessmentType() {
		return cr.getProperty("AssessmentType");
	}
	public  String noOfAttempts() {
		return cr.getProperty("Attempts");
	}
	public  String passPercentage() {
		return cr.getProperty("passpercentage");
	}
	public  String assessmentTimer() {
		return cr.getProperty("AssessmentTimer");
	}
	public  String assessmentTime() {
		return cr.getProperty("AssessmentTime");
	}
	public  String timeFields() {
		return cr.getProperty("TimeFields");
	}
	public  String cancel() {
		return cr.getProperty("cancel");
	}
	public  String saveAndNext() {
		return cr.getProperty("Saveandnext");
	}
	public  String attemptList() {
		return cr.getProperty("Attemptlist");
	}
	public  String timeZone() {
		return cr.getProperty("Timezone");
	}
	public  String selectlogo() {
		return cr.getProperty("selectlogo");
	}
	public  String logoDelete() {
		return cr.getProperty("delete");
	}
	public  String logoReset() {
		return cr.getProperty("reset");
	}
	public  String logoUpload() {
		return cr.getProperty("upload");
	}
}
