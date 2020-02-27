package com.kh.IRA.SkillMap;

import org.testng.annotations.Test;

import com.kh.IRA.PageHelper.SkillMapPageHelper;

public class SkillMapTest extends SkillMapPageHelper {

	
	
	@Test
	public void skillTest() throws InterruptedException {
		
		createSkill("SkillMap", "AddSkill");
		Thread.sleep(3000);
		createSubSkill("SkillMap", "AddSkill");
		Thread.sleep(3000);
		createComptency("SkillMap", "AddSkill");
	}
	
}