package com.kh.PRISM.pages;

import com.kh.PRISM.utilities.Configreader;

public class CreateMCQPage {

	Configreader cr;
	public CreateMCQPage() {
		
		String proppath="//src//main//resources//com//kh//PRISM//Locators//CreateQuestion.properties";
		cr=new Configreader(proppath);
	}
	
	
	public  String createQuestion() {
		return cr.getProperty("CreateQuestion");
	}
	public  String mcq() {
		return cr.getProperty("MCQ");
	}
	public  String mmcq() {
		return cr.getProperty("MMCQ");
	}
	public  String codeLab() {
		return cr.getProperty("CodeLab");
	}
	public  String delete() {
		return cr.getProperty("Delete");
	}
	public  String space() {
		return cr.getProperty("Space");
	}
	public  String question() {
		return cr.getProperty("Question");
	}
	public  String option1() {
		return cr.getProperty("Option1");
	}
	public  String option2() {
		return cr.getProperty("Option2");
	}
	public  String option3() {
		return cr.getProperty("Option3");
	}
	public  String option4() {
		return cr.getProperty("Option4");
	}
	public  String addChoice() {
		return cr.getProperty("AddChoice");
	}
	public  String next() {
		return cr.getProperty("Next");
	}
}
