package Instagram_Pom_classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Insta_Sign_Up {
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	JavascriptExecutor js;
	
	//variable declaration
			@FindBy (xpath="//input[@name='emailOrPhone']")
			private WebElement email;
			
			@FindBy (xpath="//input[@name='fullName']")
			private WebElement fullname;
			
			@FindBy (xpath="//input[@name='username']")
			private WebElement username;
			
			@FindBy (xpath="//input[@name='password']")
			private WebElement password;
			
			@FindBy (xpath="(//button)[2]")
			private WebElement sign_up;
			
			@FindBy (xpath="//h2")
			private WebElement header;
			
			//variable initialization
			public Insta_Sign_Up(WebDriver driver) {
				PageFactory.initElements( driver,this);
				this.driver=driver;
				wait= new WebDriverWait(driver,20);
				act=new Actions(driver);
				js=(JavascriptExecutor)driver;
			}
			
			//variable use
			public String header() {
				return header.getText();
			}
			public void email() {
				email.sendKeys("raje4910@gmail.com");
			}
			
			public void fullname() {
				fullname.sendKeys("rutuja");
			}
			
			public void username() {
				username.sendKeys("_rutu_1711");
			}
			public void password() {
				password.sendKeys("alliswell1");
			}
			
			public void sign_up() {
				sign_up.click();
			}
			
}
