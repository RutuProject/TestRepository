package Meesho_Pom_Classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Meesho_Sign_Up {
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	JavascriptExecutor js;
	
	@FindBy(xpath="//span[text()='Profile']")
	private WebElement profile;
	
	@FindBy(xpath="//span[text()='Sign Up']")
	private WebElement sign_up;
	
	@FindBy(xpath="(//div[@class='sc-gKPRtg gJtZfu'])[2]")
	private WebElement header;
	
	public  Meesho_Sign_Up(WebDriver driver) {
		PageFactory.initElements( driver,this);
		this.driver=driver;
		wait= new WebDriverWait(driver,20);
		act=new Actions(driver);
		js=(JavascriptExecutor)driver;
	}
	
	public void profile() throws InterruptedException {
		act.moveToElement(profile).build().perform();
		act.moveToElement(sign_up).click().build().perform();
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
	}
	
	public void header() {
		System.out.println(header.getText());
	}
}
