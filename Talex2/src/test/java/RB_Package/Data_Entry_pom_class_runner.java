package RB_Package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Red_Bus_Pom_classes.Bus_Selection;
import Red_Bus_Pom_classes.RB_Home_Page;

public class Data_Entry_pom_class_runner {
	public static void main(String[] args) throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver", "C:\\Rutu_Selenium_Testing\\Selenium\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.redbus.in/");
		 
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 
		 RB_Home_Page data=new RB_Home_Page(driver);
		 data.form("Kolhapur");
		 data.to("Hyd");
		 data.current_day();
		 data.search();
		 
		 Bus_Selection bus =new Bus_Selection(driver);
		 int num=bus.bus_booking();
		 System.out.println(num);
		 WebElement seat= driver.findElement(
				 By.xpath("(//ul[@class='bus-items']//div[@class='clearfix bus-item'])["+num+"]//div[@class='button view-seats fr']"));
		 js.executeScript("arguments[0].click();", seat);
		bus.all_prices();
	}
}
