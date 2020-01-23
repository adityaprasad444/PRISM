package com.kh.IRA.ContentAuthor;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.kh.IRA.PageHelper.CreateMCQhelper;

public class TC3_CreateMCQ extends CreateMCQhelper{

	@Test
	public void newMCQ() throws InterruptedException, FindFailed {
		
		createQuestion();
		Thread.sleep(2000);
		selectQuestionType("MCQ");
		Thread.sleep(2000);
		fillQuestionData();
	}
	
}
