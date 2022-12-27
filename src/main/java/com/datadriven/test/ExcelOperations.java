package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\samba\\eclipse-workspace\\DATA_DRIVEN_FRAMEWORK\\src\\main\\java\\com\\testdata\\FreeCrmTestData.xlsx");
		
		if(!reader.isSheetExist("Homepage"))
		{
		reader.addSheet("Homepage");
		}
		
		int colcount = reader.getColumnCount("contacts");
		System.out.println("Total number of columns present =====: "+colcount);
		System.out.println(reader.getCellRowNum("contacts", "firstname", "Tom"));
		
		
	}

}
