package com.kh.IRA.SkillMap;

import org.testng.annotations.Test;

import com.kh.IRA.PageHelper.CMSDashBoardHelper;

public class Navigate extends CMSDashBoardHelper{

	@Test(groups = "skillmap")
	public void navigateToSkillMap() {
		skillMap();
	}
}
