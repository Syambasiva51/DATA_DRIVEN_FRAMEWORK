package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excel.utility.TestUtil;




public class DemoqaTest {

	WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		driver = new ChromeDriver(); // launch chrome
		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies	
		driver.get("https://demoqa.com/automation-practice-form");
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider="getTestData",priority=1)
	public void demoqaPage(String firstname,String lastname,String Gmail,String mobile,String Subjects,String CurrentAddress,String Gender) throws InterruptedException {
		
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
		
		//reader.setCellData("contacts", "Status", rowNum, "Pass");
		
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
