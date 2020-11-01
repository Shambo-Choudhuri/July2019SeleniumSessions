package com.qa.hubspot.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	
	private static Workbook workbook;
	private static Sheet sheet;
	
	public static String TEST_DATA_WORKBOOK_PATH=".\\src\\main\\java\\com\\qa\\hubspot\\TestData\\Demo_Framework_Test_Data.xls";
	// "."----represents the Root Directory
	
	//Utility Method 1
	
	//Utility-----Provide any Sheet Name of the Workbook as input parameter and get the corresponding test data of that particular sheet.
	//e.g---Get Contacts Test Data from Sheet Name "Contacts" of Workbook mentioned in the path.
	
	//There can be multiple sheets within a workbook
	
	public static Object[][] getTestData(String SheetName)
	{
		Object data[][]=null;
		try 
		{
			FileInputStream FIP=new FileInputStream(TEST_DATA_WORKBOOK_PATH);
			
			try 
			{
				workbook=WorkbookFactory.create(FIP);
				sheet=workbook.getSheet(SheetName);
				data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 
				
				for(int row=0;row<sheet.getLastRowNum();row++)
				{
					for(int column=0;column<sheet.getRow(0).getLastCellNum();column++)
					{
						data[row][column]=sheet.getRow(row+1).getCell(column).toString();
					}
				}
			} 
			catch (EncryptedDocumentException | IOException e) 
			{
				
				e.printStackTrace();
			}
		} 
		catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
		}
		
		return data;
		
		
		
		
	}
	
	
	
	
	

}
