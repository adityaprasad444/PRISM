package com.kh.IRA.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static String filePath;
	
	public ExcelReader(String path) throws FileNotFoundException{
	filePath=	new FileInputStream(System.getProperty("user.dir")+path);
	System.out.println(filePath);
	}

	public HashMap<String,String> readTestData(String sheetName,String testName)
	{
		HashMap<String,String> testDataMap=new HashMap<String,String>();

		XSSFWorkbook workbook=null;
		String name=null;
		try
		{
			FileInputStream fis=new FileInputStream(new File(filePath));
			workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			System.out.println("Sheet Name:"+sheet.getSheetName());
			int rowsize=sheet.getLastRowNum();
			System.out.println("Number of rows in the Excel sheet:: "+rowsize);
			for(int i=1;i<=rowsize;i++)
			{
				XSSFRow currentRow=sheet.getRow(i);
				if(currentRow!=null)
				{
					XSSFCell currentCell=currentRow.getCell(1);
					name=currentCell.getStringCellValue();

					if(name.equalsIgnoreCase(testName))
					{
						XSSFRow previousRow=sheet.getRow(i-1);
						int cols=currentRow.getLastCellNum();
						for(int col=2;col<cols;col++)
						{
							String key=previousRow.getCell(col).getStringCellValue();
							String value=currentRow.getCell(col).getStringCellValue();

							testDataMap.put(key, value);
						}
						break;
					}
				}

			}

		}catch(IOException e)
		{
			System.out.println(e.getMessage());

		}
		return testDataMap;

	}


	public String[][] readDataSet(String sheetName,String testName) { 
		String[][] testdata=null; 
		XSSFWorkbook workbook=null;
		String name=null;
		try { 
			FileInputStream fis=new FileInputStream(new File(filePath));
			workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			System.out.println("Sheet Name"+sheet.getSheetName());

			int rows=sheet.getLastRowNum();
			System.out.println("No of rows in Excel sheet:"+rows);


			testdata=findNumberOfRows(sheet,testName);

			int numberOfRows=0;

			for(int i=1;i<=rows;i++) {
				XSSFRow currentRow=sheet.getRow(i);
				if(currentRow!=null)
				{ 
					XSSFCell currentCell=currentRow.getCell(1);

					name=currentCell.getStringCellValue(); 
					if(name.equalsIgnoreCase(testName)) {
						int cols=currentRow.getLastCellNum();
						int noOfCols=0;

						for(int col=2;col<cols;col++) { 
							String value=currentRow.getCell(col).getStringCellValue();
							testdata[numberOfRows][noOfCols]=value; noOfCols++; 
						}
						numberOfRows++;
					}
				}
			}
		}catch(IOException e)
		{ System.out.println("Error occured "+e.getMessage());
		}

		return testdata; 
	}


	private String[][] findNumberOfRows(XSSFSheet sheet, String testName) {

		int noOfRows=0;
		int noOfCols=0;
		int rows=sheet.getLastRowNum();
		for(int i=1;i<=rows;i++)
		{
			XSSFRow currentRow=sheet.getRow(i);
			if(currentRow!=null)
			{
				XSSFCell currentCell=currentRow.getCell(1);
				String name=currentCell.getStringCellValue();
				if(name.equalsIgnoreCase(testName))
				{
					noOfCols=currentRow.getLastCellNum();
					noOfRows++;
				}
			}
		}
		return null;
	}
}
