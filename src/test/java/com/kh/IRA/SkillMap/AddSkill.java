package com.kh.IRA.SkillMap;

import org.testng.annotations.Test;

import com.kh.IRA.PageHelper.SkillMapPageHelper;

public class AddSkill extends SkillMapPageHelper {

	
	
	@Test(groups = "skillmap")
	public void AddSillSubskillCompetency() {
		
		createSkill("SkillMap", "AddSkill");
		createSubSkill("SkillMap", "AddSkill");
		createComptency("SkillMap", "AddSkill");
	}
	
}