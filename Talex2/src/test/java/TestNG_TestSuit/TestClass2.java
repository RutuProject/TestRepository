package TestNG_TestSuit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browser_SetUP.Base_Class;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass2 {
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void beforetest(String browserName) {
		//System.out.println("Before Test");
		
		if(browserName.equals("Chrome")) {
		driver=Base_Class.openChromeBrowser(driver);
		}
		
		if(browserName.equals("FireFox")) {
		driver=Base_Class.openFirefoxBrowser(driver);
		}
		
		if(browserName.equals("Edge")) {
		driver=Base_Class.openEdgeBrowser(driver);
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void beforeclass() {
		//System.out.println("Before Class");
		driver.get("https://www.Instagram.com/");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@Test(priority=0)
	public void test1() {
		System.out.println("Test1");
		System.out.println(driver.getTitle());
	}

	@Test(priority=1)
	public void test2() {
		System.out.println("Test2");
	System.out.println(driver.getCurrentUrl());
	}

	@AfterMethod
	public void aftermethod() {
	System.out.println("After Method");
	}

	@AfterClass
	public void afterclass() {
	System.out.println("After Class");
	System.out.println();
		}
	
	@AfterTest
	public void aftertest() {
		//System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();
		
	}	
	
	
}
