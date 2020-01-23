package com.kh.IRA.Pages;

import com.kh.IRA.Utilities.Configreader;

public class CreateMCQPage {

	Configreader cr;
	public CreateMCQPage() {
		
		String proppath="//src//main//resources//com//kh//IRA//Locators//CreateQuestion.properties";
		cr=new Configreader(proppath);
	}
	
	
	public  String CreateQuestion() {
		return cr.getProperty("CreateQuestion");
	}
	public  String MCQ() {
		return cr.getProperty("MCQ");
	}
	public  String MMCQ() {
		return cr.getProperty("MMCQ");
	}
	public  String CodeLab() {
		return cr.getProperty("CodeLab");
	}
	public  String Delete() {
		return cr.getProperty("Delete");
	}
	public  String Space() {
		return cr.getProperty("Space");
	}
	public  String Question() {
		return cr.getProperty("Question");
	}
	public  String Option1() {
		return cr.getProperty("Option1");
	}
	public  String Option2() {
		return cr.getProperty("Option2");
	}
	public  String Option3() {
		return cr.getProperty("Option3");
	}
	public  String Option4() {
		return cr.getProperty("Option4");
	}
	public  String AddChoice() {
		return cr.getProperty("AddChoice");
	}
	public  String Next() {
		return cr.getProperty("Next");
	}
}
