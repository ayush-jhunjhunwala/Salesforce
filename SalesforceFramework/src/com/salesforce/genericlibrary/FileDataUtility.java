package com.salesforce.genericlibrary;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FileDataUtility {
	
	String urlpath = "./TestData/salesforceurl.properties";
	String credentialpath = "./TestData/salesforce_credentials.xlsx";
	
	public Properties getPropertyFileData() throws Throwable
	{
		FileInputStream fobj = new FileInputStream(urlpath);
		Properties pobj = new Properties();
		pobj.load(fobj);
		return pobj;
	}
	
	public String getExcelSheetData(String sheetName, int rowNum, int colNum) throws Throwable
	{
		FileInputStream fobj = new FileInputStream(credentialpath);
		Workbook workbook =  WorkbookFactory.create(fobj);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell column = row.getCell(colNum);
		String data = column.getStringCellValue();
		return data;
	}
	
	public int getLastCellValue(String sheetName) throws Throwable
	{
		FileInputStream fobj = new FileInputStream(credentialpath);
		Workbook workbook =  WorkbookFactory.create(fobj);
		Sheet sheet = workbook.getSheet(sheetName);
		return sheet.getLastRowNum();
	}

}
