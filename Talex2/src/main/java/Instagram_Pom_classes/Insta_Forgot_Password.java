package Instagram_Pom_classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Insta_Forgot_Password {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	JavascriptExecutor js;
	
	//variable declaration
		@FindBy (xpath="//input[@type='text']")
		private WebElement email;
		
		@FindBy (xpath="//button")
		private WebElement login;
		
		@FindBy (xpath="(//a[@role='link'])[2]")
		private WebElement reset;
		
		@FindBy (xpath="//a[text()='Create new account']")
		private WebElement create_new_account;
		
		@FindBy (xpath="(//a//div)[15]")
		private WebElement meta_verified;
		
	//variable initialization
		public Insta_Forgot_Password(WebDriver driver) {
			PageFactory.initElements( driver,this);
			this.driver=driver;
			wait= new WebDriverWait(driver,20);
			act=new Actions(driver);
			js=(JavascriptExecutor)driver;
		}
		
		//variable use
		public void email() {
			email.sendKeys("raje4910@gmail.com");
		}
		
		public void login_button() {
			login.click();
		}
		
		public void reset() {
			reset.click();
		}
		
		public void create_new_account() {
			create_new_account.click();
		}
		
		public void meta_verified() throws InterruptedException {
			js.executeScript("window.scrollBy(0, 2000)");
			Thread.sleep(5000);
			act.moveToElement(meta_verified).click().build().perform();
		}
}
