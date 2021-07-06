package com.kh.PRISM.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomDataGenerator {

	
	public static int getRandomNumber()
	{
		Random ran=new Random();
		int num=ran.nextInt(123);
		return num;
	}
	public static String getTodayDate()
	{
		SimpleDateFormat dateFormat=new SimpleDateFormat("ddMMyyyy");
		String date=dateFormat.format(new Date());
		System.out.println("Today date: "+date);
		return date;
	}
	public static String getDateAndTime()
	{
		SimpleDateFormat scrDateFormat=new SimpleDateFormat("ddMMyyHHmmss");
		String date=scrDateFormat.format(new Date());
		System.out.println(date);
		return date;
	}
}
