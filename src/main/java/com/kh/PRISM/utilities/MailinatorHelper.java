package com.kh.PRISM.utilities;

import com.kh.PRISM.testbase.TestBase;

public class MailinatorHelper extends TestBase {
	
	public String emailReader(String email) {
		
		initialization("chrome");
		browsersettings();
		driver.get("https://www.mailinator.com/");
		
		
		return null;
	}

}
