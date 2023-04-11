package Insta_Test_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Instagram_Pom_classes.Insta_Forgot_Password;
import Instagram_Pom_classes.Insta_Login;
import Instagram_Pom_classes.Insta_Sign_Up;


public class Forgotp_SignUp {
WebDriver driver;
Insta_Login logging;	
Insta_Forgot_Password fg;
Insta_Sign_Up sp;
	@BeforeClass
	public void launch_application() {
	 System.out.println("Before class");
	 System.setProperty("webdriver.chrome.driver", "C:\\Rutu_Selenium_Testing\\Selenium\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	
	@BeforeMethod
	public void login_to_application() throws InterruptedException {
		System.out.println("Before method");
		 driver.get("https://www.instagram.com/");
		 logging=new Insta_Login(driver);
		logging.edit_username("8484801704");
		logging.edit_password("alliswellll");
		logging.login_button();
		if(logging.error().equals("Sorry, your password was incorrect. Please double-check your password.")){
			System.out.printf("Error shown=%s\n",logging.error());
			logging.forgot_password_link();
		}
		else {
			System.out.println("Fail");
		}
		fg=new Insta_Forgot_Password(driver);
	}
	
	@Test
	public void forgot_pass() {
		System.out.println("Test1");
		fg.email();
	}

	@Test
	public void forgot_pass_create() {
		System.out.println("Test2");
		fg.create_new_account();
		String expected_URL="https://www.instagram.com/accounts/emailsignup/";
		String expected_Title="Sign up to see photos and videos from your friends.";
		sp= new Insta_Sign_Up(driver);
		if( (sp.header().equals(expected_Title)) &&
				(driver.getCurrentUrl().equals(expected_URL)) ) {
			System.out.println("Launched on sign up page");
			System.out.println(driver.getCurrentUrl());
		}
	}
	
	@AfterMethod
	public void ss() {
		System.out.println("after method");
	}
	
	@AfterClass
	public void ss1() {
		System.out.println("after class");
		driver.quit();
		driver=null;
	}
}
