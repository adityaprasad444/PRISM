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
	public  String timeZone() {
		return cr.getProperty("Timezone");
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
	
	public  String selectQuestion() {
		return cr.getProperty("SelectQuestion");
	}
	public  String updateAssessment() {
		return cr.getProperty("UpdateAssessment");
	}
	public  String addMoreQuestions() {
		return cr.getProperty("addMoreQuestions");
	}
	public  String selectCheckbox() {
		return cr.getProperty("SelectCheckbox");
	}
	public  String confirmSelection() {
		return cr.getProperty("confirmSelection");
	}
	public  String ddlPagination() {
		return cr.getProperty("ddlPagination");
	}
	public  String pagesize5() {
		return cr.getProperty("pagesize5");
	}
	public  String pagesize10() {
		return cr.getProperty("pagesize10");
	}
	public  String pagesize25() {
		return cr.getProperty("pagesize25");
	}
	public  String pagesize50() {
		return cr.getProperty("pagesize50");
	}
	public  String pagination() {
		return cr.getProperty("pagination");
	}
	public  String pagestatus() {
		return cr.getProperty("pagestatus");
	}
	public  String c1() {
		return cr.getProperty("checkbox_click1");
	}
	public  String c2() {
		return cr.getProperty("checkbox_click2");
	}
	public  String nextpage() {
		return cr.getProperty("nextpage");
	}
	public  String previouspage() {
		return cr.getProperty("previouspage");
	}
	public  String lastpagedisablednext() {
		return cr.getProperty("lastpagedisablednext");
	}
	public  String createAssessment1() {
		return cr.getProperty("createAssessment1");
	}
	public  String questionsSelected() {
		return cr.getProperty("questionsSelected");
	}
	public  String sender() {
		return cr.getProperty("sender");
	}
	public  String ddl1() {
		return cr.getProperty("ddl1");
	}
}
