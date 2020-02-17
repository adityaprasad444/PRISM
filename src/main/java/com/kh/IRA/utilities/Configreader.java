package com.kh.IRA.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configreader {

	public FileInputStream fis;
	public Properties p;
	public Configreader(String path) {
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+path);
			System.out.println(fis);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		p= new Properties();
		try {

			p.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return p.getProperty(key);
	}
}
