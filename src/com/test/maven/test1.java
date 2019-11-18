package com.test.maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test1 {
	public static WebDriver driver;
	public static WebDriverWait wait;
	@BeforeMethod
	public static void launchDriver()
	{
		 System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDriver/chromedriver.exe");					
	       driver= new ChromeDriver();	
	   	driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 220);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	

	@Test
	public static void Test1()
	{
		driver.get("http://www.zensar.com");
		System.out.println("Test1 Titile : "+driver.getTitle());
	}
	
	@Test
	public static void Test2()
	{
		driver.get("http://www.google.com");
		System.out.println("Test2 Titile : "+driver.getTitle());
	}
	
	@Test
	public static void Test3()
	{
		driver.get("http://www.yash.com");
		System.out.println("Test3 Titile : "+driver.getTitle());
	}
	
	@AfterMethod
	public static void quit()
	{
		driver.quit();
	}
}
