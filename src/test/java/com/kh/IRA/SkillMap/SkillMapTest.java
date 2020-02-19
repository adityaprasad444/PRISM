package com.kh.IRA.SkillMap;

import org.testng.annotations.Test;

import com.kh.IRA.PageHelper.SkillMapPageHelper;

public class SkillMapTest extends SkillMapPageHelper {

	
	
	@Test
	public void skillTest() {
		
		createSkill("SkillMap", "Skill");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createSubSkill("SkillMap1", "Subskill");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createComptency("SkillMap2", "Competency");
	}
	
}