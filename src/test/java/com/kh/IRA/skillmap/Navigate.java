package com.kh.IRA.skillmap;

import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.CMSDashBoardHelper;

public class Navigate extends CMSDashBoardHelper{

	@Test(groups = "skillmap")
	public void navigateToSkillMap() {
		skillMap();
	}
}
