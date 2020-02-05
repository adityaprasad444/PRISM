package com.kh.IRA.CMS_QuestionBank;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.kh.IRA.PageHelper.CreateMCQhelper;

public class TC3_CreateMCQ extends CreateMCQhelper{

	@Test
	public void newMCQ() throws InterruptedException, FindFailed {
		
		createQuestion();
		selectQuestionType("MCQ");
		fillQuestionData();
	}
	
}
