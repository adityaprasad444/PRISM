package com.kh.PRISM.skillmap;

import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.SkillMapPageHelper;

public class AddandEdit_skill extends SkillMapPageHelper {

	
	
	@Test(priority=1)
	public void addSkillSubskillCompetency() {
		
		createSkill("SkillMap", "AddSkill");
		createSubSkill("SkillMap", "AddSkill");
		createComptency("SkillMap", "AddSkill");
	}
	
	@Test(priority=2)
	public void editSkillSubskillCompetency() {
		edit();
	}
}