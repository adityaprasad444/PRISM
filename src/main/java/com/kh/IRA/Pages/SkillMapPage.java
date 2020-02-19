package com.kh.IRA.Pages;

import com.kh.IRA.Utilities.Configreader;

public class SkillMapPage {

	Configreader cr;
	public SkillMapPage() {
		
		String proppath="//src//main//resources//com//kh//IRA//Locators//cms_SkillMap.properties";
		cr=new Configreader(proppath);
	}
	
	public  String skillmap() {
		return cr.getProperty("skillmap");
	}
	
	public  String addnewskill() {
		return cr.getProperty("addnewskill");
	}
	
	public  String popup() {
		return cr.getProperty("popup");
	}
	
	public  String addbutton() {
		return cr.getProperty("addbutton");
	}
	
	public  String cancelbutton() {
		return cr.getProperty("cancelbutton");
	}
	
	public  String textbox() {
		return cr.getProperty("textbox");
	}
	
	public  String addsubskill() {
		return cr.getProperty("addsubskill");
	}
	
	public  String addcompetency() {
		return cr.getProperty("addcompetency");
	}
	
	public  String editbutton() {
		return cr.getProperty("editbutton");
	}
}
