package com.kh.PRISM.skillmap;

import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.CMSDashBoardHelper;

public class Navigate extends CMSDashBoardHelper{

	@Test(groups = "skillmap")
	public void navigateToSkillMap() {
		skillMap();
	}
}
