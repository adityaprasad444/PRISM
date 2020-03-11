package com.kh.IRA.learner;

import org.testng.annotations.Test;

import com.kh.IRA.pagehelper.DashboardHelper;

public class TC2_DashboardLinks extends DashboardHelper {

	@Test
	public void dashboardVerify() {
		verifyDashboard();
	}
}
