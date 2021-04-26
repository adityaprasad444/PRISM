package com.qa;

import java.util.HashMap;

import com.kh.IRA.utilities.ExcelReader;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> data=ExcelReader.readTestData("TestCredentials","LearnerLogin" );
	}

}
