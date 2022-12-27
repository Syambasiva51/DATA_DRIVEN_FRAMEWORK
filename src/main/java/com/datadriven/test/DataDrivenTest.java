package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\samba\\eclipse-workspace\\DATA_DRIVEN_FRAMEWORK\\src\\main\\java\\com\\testdata\\FreeCrmTestData.xlsx");
		
		String firstname=reader.getCellData("contacts", "firstname", 2);
		System.out.println(firstname);
		
		String lastname=reader.getCellData("contacts", "lastname", 2);
		System.out.println(lastname);
		
		String Gmail=reader.getCellData("contacts", "Email", 2);
		System.out.println(Gmail);
		
		String Gender=reader.getCellData("contacts", "Gender", 2);
		System.out.println(Gender);
		
		
		String mobile=reader.getCellData("contacts", "mobile", 2);
		System.out.println(mobile);
		
		String Subjects=reader.getCellData("contacts", "Subjects", 2);
		System.out.println(Subjects);
		
		String CurrentAddress=reader.getCellData("contacts", "CurrentAddress", 2);
		System.out.println(CurrentAddress);
		
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies	
		driver.get("https://demoqa.com/automation-practice-form");
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
	}
}
