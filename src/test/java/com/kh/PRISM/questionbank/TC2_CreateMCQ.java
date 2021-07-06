package com.kh.PRISM.questionbank;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.kh.PRISM.pagehelper.CreateMCQhelper;

public class TC2_CreateMCQ extends CreateMCQhelper{

	@Test
	public void newMCQ() throws InterruptedException, FindFailed {
		
		createQuestion();
		selectQuestionType("MCQ");
		fillQuestionData();
	}
	
}
