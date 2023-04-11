package Browser_SetUP;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	
  public static WebDriver openChromeBrowser(WebDriver driver) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Rutu_Selenium_Testing\\Selenium\\chromedriver.exe");
	  driver=new ChromeDriver();
	  return driver;
  }
  
  public static WebDriver openFirefoxBrowser(WebDriver driver) {
	  WebDriverManager.firefoxdriver().setup();
	  driver =  new FirefoxDriver();
	  return driver;
  }
  
  public static WebDriver openEdgeBrowser(WebDriver driver) {
	  System.setProperty("webdriver.edge.driver", "C:\\Rutu_Selenium_Testing\\Talex\\msedgedriver.exe");     
	  driver =  new EdgeDriver();
	  return driver;
  }
}
