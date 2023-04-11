package Insta_Test_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Instagram_Pom_classes.Insta_Login;
import Instagram_Pom_classes.Like_Post;
import Instagram_Pom_classes.Profile_Data;

public class Profile_and_Like {
	WebDriver driver;
	
	@BeforeClass
	public void launch_application() {
	 System.setProperty("webdriver.chrome.driver", "C:\\Rutu_Selenium_Testing\\Selenium\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.get("https://www.instagram.com/");
	}
	
	
	@BeforeMethod
	public void login_to_application() {
		Insta_Login logging=new Insta_Login(driver);
		logging.edit_username("8484801704");
		logging.edit_password("alliswell1");
		logging.login_button();
		logging.save_info();
		
		logging.turn_notification();
	}
	
	@AfterMethod
	public void aftermethod() {
		WebElement settings=driver.findElement(By.xpath("//div[@class='xl5mz7h xhuyl8g']")) ;
		settings.click();
		WebElement logout=driver.findElement(By.xpath("(//div[@class='_aa61']//div[@class='_abm4'])[7]")) ;
		logout.click();
	}
	
	@AfterClass
	public void afterclass() {
		driver.quit();
	}
	
	
	  @Test (priority=0)
	 public void profile_bio() throws InterruptedException {
	  Profile_Data check_profile=new Profile_Data(driver);
	  check_profile.profile();
	  }
	 
	
	@Test  (priority=1)
	public void like_post()  {
		Like_Post like=new Like_Post(driver);
		like.like();
	}
}
