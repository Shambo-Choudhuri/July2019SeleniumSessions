package SeleniumSessions;

import UtilityMethods.XLS_Reader;

//import com.excel.lib.util.XLS_Reader;

public class ReadExcelDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		XLS_Reader xls_Reader=new XLS_Reader("./src/main/java/com/excel/lib/util/Excel_Test_Data.xlsx");
		
		//Fetching Cell data using Column Number
		
		String Username=xls_Reader.getCellData("Sheet1", 0, 2);
		
		System.out.println("Username="+Username);
		
		String Password=xls_Reader.getCellData("Sheet1", 1, 2);
		
		System.out.println("Password="+Password);
		
		//Getting the row count
		
		System.out.println("Row Count="+xls_Reader.getRowCount("Sheet1"));
		
		//Adding a new column
		
		xls_Reader.addColumn("Sheet1", "Status");
		
		//Adding a new Sheet
		
		xls_Reader.addSheet("Registration");
		
		//Checking Whether there is any existing Sheet with a particular name or not
		
		if(xls_Reader.isSheetExist("Registration"))
		{
			System.out.println("Sheet Already Exists");
		}
		else
		{
			xls_Reader.addSheet("Registration");
		}
		
		//Write data into file.Please close the file while writing data into the file.
		
		xls_Reader.setCellData("Registration", "Username", 2, "Naveen");
		
		//Fetching Cell data using Column Name
		
		xls_Reader.getCellData("Registration", "Username", 2);
		
		//Get Column Count
		
		System.out.println("Column Count="+xls_Reader.getColumnCount("Registration"));
		
		//Remove Column
		
		xls_Reader.removeColumn("Sheet1",2);
		
		/*Whenever you are writing any numerical data into the file then compulsory start with single quote(') otherwise we will get
		unpredictable results.But not applicable for formula based data since we can't put manually any single quote in the cell*/
		
		xls_Reader.getCellData("Registration", "Status", 3);
		
		
		
		
		
		
		
	}

}
