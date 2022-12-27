package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies	
		driver.get("https://demoqa.com/automation-practice-form");
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\samba\\eclipse-workspace\\DATA_DRIVEN_FRAMEWORK\\src\\main\\java\\com\\testdata\\FreeCrmTestData.xlsx");
		
		int rowCount = reader.getRowCount("contacts");
		
		reader.addColumn("contacts", "Status");
		
		for(int rowNum =2; rowNum<=rowCount; rowNum++)
		{
			System.out.println("=======================");
			String firstname=reader.getCellData("contacts", "firstname", rowNum);
			System.out.println(firstname);
			
			String lastname=reader.getCellData("contacts", "lastname", rowNum);
			System.out.println(lastname);
			
			String Gmail=reader.getCellData("contacts", "Email", rowNum);
			System.out.println(Gmail);
			
			String Gender=reader.getCellData("contacts", "Gender", rowNum);
			System.out.println(Gender);
			
			
			String mobile=reader.getCellData("contacts", "mobile", rowNum);
			System.out.println(mobile);
			
			String Subjects=reader.getCellData("contacts", "Subjects", rowNum);
			System.out.println(Subjects);
			
			String CurrentAddress=reader.getCellData("contacts", "CurrentAddress", rowNum);
			System.out.println(CurrentAddress);
			
			//Webdriver code:
			Thread.sleep(2000);
			driver.findElement(By.id("firstName")).sendKeys(firstname);
			driver.findElement(By.id("lastName")).sendKeys(lastname);
			driver.findElement(By.id("userEmail")).sendKeys(Gmail);
			
			WebElement element=driver.findElement(By.xpath("//input[@value='"+Gender+"']"));
			
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", element);
			
			driver.findElement(By.id("userNumber")).sendKeys(mobile);
			
			driver.findElement(By.id("subjectsInput")).sendKeys(Subjects);
			
			driver.findElement(By.id("currentAddress")).sendKeys(CurrentAddress);
			
			
			WebElement Submit=driver.findElement(By.id("submit"));
			
			js.executeScript("arguments[0].click();", Submit);
			
			WebElement close =driver.findElement(By.id("closeLargeModal"));
			
			js.executeScript("arguments[0].click();", close);
			
			reader.setCellData("contacts", "Status", rowNum, "Pass");
			
		
		}
	}
}
