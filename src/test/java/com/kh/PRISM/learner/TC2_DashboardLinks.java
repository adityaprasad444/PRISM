package com.kh.PRISM.learner;

import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.DashboardHelper;

public class TC2_DashboardLinks extends DashboardHelper {

	@Test
	public void dashboardVerify() {
		verifyDashboard();
	}
}
