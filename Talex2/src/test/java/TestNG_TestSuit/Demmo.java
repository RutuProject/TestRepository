package TestNG_TestSuit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

import Utility_Classes.Util1;


public class Demmo {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//	 System.setProperty("webdriver.edge.driver", "C:\\Rutu_Selenium_Testing\\Talex\\msedgedriver.exe");     
//	 WebDriver driver =  new EdgeDriver();
//		
//	 System.setProperty("webdriver.gecko.driver", "C:\\Rutu_Selenium_Testing\\Talex\\geckodriver.exe");     
//	 WebDriver driver =  new FirefoxDriver();
//		
//   WebDriverManager.firefoxdriver().arch64().setup();
//   WebDriver driver =  new FirefoxDriver();
//		
//   driver.navigate().to("http://www.javatpoint.com/");  
//   System.out.println(driver.getTitle());
		
		System.setProperty("webdriver.chrome.driver", "C:\\Rutu_Selenium_Testing\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.meesho.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		Util1.screenshot(driver,"Rutu");
		Util1.excelsheet("Sheet1", 1, 0);
	}

}
