package com.kh.IRA.pagehelper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.kh.IRA.pages.DashboardPage;
import com.kh.IRA.testbase.TestBase;

public class DashboardHelper extends TestBase {

	public static DashboardPage dp;

	public DashboardHelper() {
		dp=new DashboardPage();
		asrt=new SoftAssert();
	}

	public void verifyDashboard() {
		WebElement dash=driver.findElement(By.xpath(dp.getDashboard()));
		List<WebElement> Dashlinks= dash.findElements(By.tagName("a"));
		for (int i=0;i<Dashlinks.size();i++) {
			String Text=Dashlinks.get(i).getText();
			driver.findElement(By.linkText(Text)).click();
			String urlappend=Dashlinks.get(i).getAttribute("href");
			asrt.assertEquals(driver.getCurrentUrl(), urlappend);
			asrt.assertAll();
		}}

	public static void logout() {
		driver.findElement(By.xpath(dp.profilecircle())).click();
		List <WebElement> menu=driver.findElements(By.xpath(dp.profileitems()));
		waitUntilVisibilityOfElement(menu.get(0));
		menu.get(1).click();
	}
}