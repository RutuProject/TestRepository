package RB_Package;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Red_Bus_Pom_classes.Bus_Selection;
import Red_Bus_Pom_classes.Cab_Booking;
import Red_Bus_Pom_classes.RB_Home_Page;

public class TestNG {
	SoftAssert soft;
	@BeforeClass
	public void beforeclass() {
		System.out.println("Before Class");
		
	}

@BeforeMethod
public void beforeMethod() {
	System.out.println("Before Method");
	soft=new SoftAssert();
}

@Test(priority=0)
public void test1() {
	 System.out.println("Test 1");
	 
	 String actual="Rutuja";
	 String expected="Rutuja";
	 
	 soft.assertNotEquals(actual,expected,"T1- Not Equal");
	 soft.assertEquals(actual, expected,"T1- Equal");
	 soft.assertFalse(true, "T1- False");
	 
	 soft.assertAll();
	 System.out.println("Test 11");
}

@Test(priority=1)
public void test2() {
	System.out.println("Test 2");
	
	String actual="Rutuja";
	 String expected="Rutuja";
	 
	 soft.assertNotEquals(actual,expected,"T2- Not Equal");
	 soft.assertEquals(actual, expected,"T2-Equal");
	 soft.assertFalse(true, "T2- False");
	 
	 soft.assertAll();
	 System.out.println("Test 22");
}

//@Test(priority=2)
//public void test3()  {
//		System.out.println("Test 3");	
//		Assert.fail();
//}


@AfterMethod
public void aftermethod() {
	System.out.println("After Method");

}

@AfterClass
public void afterclass() {
	System.out.println("After Class");
}
}
