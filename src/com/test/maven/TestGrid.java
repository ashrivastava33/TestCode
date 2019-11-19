package com.test.maven;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestGrid {
	public static WebDriver driver;
	public static WebDriverWait wait;
	@BeforeMethod
	public static void launchDriver() throws MalformedURLException
	{
		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.chrome();
		dr.setBrowserName("chrome");
		dr.setPlatform(Platform.WIN10);
		 System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDriver/chromedriver.exe");					
	       driver= new RemoteWebDriver(new URL("http://192.168.1.10:4444/wd/hub"),dr);
	    		   
	   	driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 220);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	

	@Test
	public static void Test1()
	{
		driver.get("http://www.howtodoinjava.com");
		System.out.println("Test1 Titile in Grid :  "+driver.getTitle());
	}
	
	@Test
	public static void Test2()
	{
		driver.get("http://www.github.com");
		System.out.println("Test2 Titile in Grid :  "+driver.getTitle());
	}
	
	@Test
	public static void Test3()
	{
		driver.get("http://www.softwaretestinghelp.com");
		System.out.println("Test3 Titile in Grid :  "+driver.getTitle());
	}
	
	@AfterMethod
	public static void quit()
	{
		driver.quit();
	}
}
