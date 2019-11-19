package com.test.maven;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBrowserStack {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static final String USERNAME = "anumehaparijatsh1";
	  public static final String AUTOMATE_KEY = "Dzp6Kpvn6zhUqVcnzSF4";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	@BeforeMethod
	public static void launchDriver() throws MalformedURLException
	{
/*		DesiredCapabilities dr = null;
		dr = DesiredCapabilities.chrome();
		dr.setBrowserName("chrome");
		dr.setPlatform(Platform.WIN10);
		 System.setProperty("webdriver.chrome.driver", "src/test/resources/BrowserDriver/chromedriver.exe");					
	       driver= new RemoteWebDriver(new URL("http://192.168.1.10:4444/wd/hub"),dr);*/
	    		   
		DesiredCapabilities caps = new DesiredCapabilities();
	/*    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "60.0");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "7");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("name", "Bstack-[Java] Sample Test");*/
	 //set from capability generator   
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "62.0");
	    caps.setCapability("project", "TestingOnBrowserStack");
	    caps.setCapability("build", "1.0");
	    caps.setCapability("name", "TestBroserStackSel");
	    caps.setCapability("browserstack.local", "false");
	    caps.setCapability("browserstack.selenium_version", "3.5.2");
	    
	     driver = new RemoteWebDriver(new URL(URL), caps);
		driver.manage().deleteAllCookies();
		wait = new WebDriverWait(driver, 220);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}
	

	@Test
	public static void Test1()
	{
		  driver.get("http://www.google.com/ncr");
		    WebElement element = driver.findElement(By.name("q"));

		    element.sendKeys("BrowserStack");
		    element.submit();

		    System.out.println(driver.getTitle());
	}
/*	
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
	}*/
	
	@AfterMethod
	public static void quit()
	{
		driver.quit();
	}
}
