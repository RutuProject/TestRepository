package RB_Package;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Red_Bus_Pom_classes.Bus_Selection;
import Red_Bus_Pom_classes.Cab_Booking;
import Red_Bus_Pom_classes.RB_Home_Page;
import Utility_Classes.Util1;

public class Data_Entry_TestNG_runner {
	WebDriver driver;
	RB_Home_Page data;
	Bus_Selection bus;
	Cab_Booking ride;
	String TestID;
	
	@BeforeClass
		public void beforeclass() {
		 System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Browser_Files\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.redbus.in/");
		}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test(priority=0)
	public void test1() throws EncryptedDocumentException, IOException {
		TestID= "101";
		data=new RB_Home_Page(driver);
		 data.form(Util1.excelsheet("Sheet1", 1, 0));
		 data.to(Util1.excelsheet("Sheet1", 1, 2));
		 data.current_day();
		 data.search();
		 System.out.println("Search Successful");
	}
	
	@Test(priority=1)
	public void test2() {
		TestID= "102";
		 bus =new Bus_Selection(driver);
		 int num=bus.bus_booking();
		 System.out.println(num);
		WebElement seat= driver.findElement(
			 By.xpath("(//ul[@class='bus-items']//div[@class='clearfix bus-item'])["+num+"]//div[@class='button view-seats fr']"));
		 JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", seat);
	bus.all_prices();
	}
	
	@Test(priority=2)
	public void test3() {
		TestID= "103";
		driver.navigate().back();
		 List<WebElement> country= driver.findElements(By.xpath("(//div[@class='main-body'])[3]//ul//li"));
		 for(int i=0;i<country.size();i++) {
		 System.out.printf("%s  ",country.get(i).getText());
		 }
			System.out.println();	
	}
	
	@Test(priority=3)
	public void test4() {
		TestID= "104";
		ride=new Cab_Booking(driver);	
		ride.ryde();
	//	Assert.fail();
	}
	
	@Test(priority=4)
	public void test5() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		System.out.println("After Method");
		System.out.println();
		if(ITestResult.FAILURE==result.getStatus()) {
		Util1.screenshot(driver, TestID);}
	}
	
	@AfterClass
	public void afterclass() {
		driver.quit();
		driver=null;
	}
}
