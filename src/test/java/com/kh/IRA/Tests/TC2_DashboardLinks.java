package com.kh.IRA.Tests;

import org.testng.annotations.Test;

import com.kh.IRA.PageHelper.DashboardHelper;

public class TC2_DashboardLinks extends DashboardHelper {

	@Test
	public void dashboardVerify() {
		verifyDashboard();
	}
}
