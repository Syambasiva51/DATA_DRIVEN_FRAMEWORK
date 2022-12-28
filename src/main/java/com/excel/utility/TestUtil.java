package com.excel.utility;

import java.util.ArrayList;

public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("C:\\Users\\samba\\eclipse-workspace\\DATA_DRIVEN_FRAMEWORK\\src\\main\\java\\com\\testdata\\FreeCrmTestData.xlsx");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for (int rowNum =2; rowNum <=reader.getRowCount("contacts");rowNum++)
		{
		String firstname = reader.getCellData("contacts", "firstname", rowNum);
		String lastname = reader.getCellData("contacts", "lastname", rowNum);
		String Email = reader.getCellData("contacts", "Email", rowNum);
		String mobile = reader.getCellData("contacts", "mobile", rowNum);
		String Subjects = reader.getCellData("contacts", "Subjects", rowNum);
		String CurrentAddress = reader.getCellData("contacts", "CurrentAddress", rowNum);
		String Gender = reader.getCellData("contacts", "Gender", rowNum);
		
		
		Object ob[] = {firstname,lastname,Email,mobile,Subjects,CurrentAddress,Gender};
		myData.add(ob);
		}
		
		return myData;
		
	}
	
}
