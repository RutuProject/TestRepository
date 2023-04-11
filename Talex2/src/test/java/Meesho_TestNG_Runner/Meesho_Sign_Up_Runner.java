package Meesho_TestNG_Runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browser_SetUP.Base_Class;
import Meesho_Pom_Classes.Meesho_Sign_Up;

public class Meesho_Sign_Up_Runner {
	WebDriver driver;
	Meesho_Sign_Up sign;
	
	@Parameters("browser")
	@BeforeTest
	public void beforetest(String browserName) {
		
		//Browser Setup is done in before setup
		
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
		
		//System.out.println("Test Class object creation");
		
		//System.out.println("Before Class");
		driver.get("https://www.meesho.com/");
		sign=new Meesho_Sign_Up(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@Test(priority=0)
	public void test1() throws InterruptedException {
		System.out.println("Test1");
		sign.profile();
		System.out.println(driver.getTitle());
	}

	@Test(priority=1)
	public void test2() {
		System.out.println("Test2");
		sign.header();
	}

	@AfterMethod
	public void aftermethod() {
	System.out.println("After Method");
	}

	@AfterClass
	public void afterclass() {
	//System.out.println("Test Class object clear");
		
	System.out.println("After Class");
	sign=null;
	System.out.println();
		}
	
	@AfterTest
	public void aftertest() {
		
		//System.out.println("Close Browser");
		
		//System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();
		
	}	
	
	
}
