package com.kh.IRA.pages;

import com.kh.IRA.utilities.Configreader;

public class SkillMapPage {

	Configreader cr;
	public SkillMapPage() {
		
		String proppath="//src//main//resources//com//kh//IRA//Locators//SkillMap.properties";
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
	public  String edit() {
		return cr.getProperty("edit");
	}
	public  String save() {
		return cr.getProperty("save");
	}
	public  String searchbox() {
		return cr.getProperty("searchbox");
	}
}
