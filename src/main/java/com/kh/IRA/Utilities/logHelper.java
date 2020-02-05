package com.kh.IRA.Utilities;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

public class logHelper {
	public static StringBuffer buffer = new StringBuffer(" ");
	static Logger log = Logger.getLogger(logHelper.class);

	public logHelper(){

		PropertyConfigurator.configure("Log4j.properties");
		//DOMConfigurator.configure("C:\\~\\log4j.xml");
	}

	public static void startTestCase(String sTestCaseName) {
		addMessage("****************************************************************");
		addMessage("\n                 " + sTestCaseName + "             \n");
		addMessage("****************************************************************");

	}

	// Function to add END Message
	public static void addEndMessage() {
		addMessage("\n                 " + "-E---N---D-" + "             \n");
	}

	// Functions to write the log
	public static void debug() {
		log.debug(buffer);
	}

	public static void info() {
		System.out.println("Info Log details ");
		System.out.println(buffer);
		log.info(buffer);
	}

	public static void warn() {
		log.warn(buffer);
	}

	public static void error() {
		log.error(buffer);
		System.out.println("Error Log details ");
		System.out.println(log.toString());
		System.out.println(buffer);
	}

	public static void fatal() {
		log.fatal(buffer);
	}

	// This function will append the log message to a static variable
	public static void addMessage(String message) {
		buffer.append("\n");
		buffer.append(message);
	}

	public static void addIntExceptionMessage(String message,InterruptedException e) {
		buffer.append("\n");
		buffer.append(message);
	}

	public static void addIOExceptionMessage(String message,IOException e) {
		buffer.append("\n");
		buffer.append(message);
	}

	public static void clearBuffer() {
		buffer.delete(0, buffer.length());
	}
}
