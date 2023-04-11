package Instagram_Pom_classes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insta_Login {
	
	//variable declaration
	@FindBy (xpath="//input[@name='username']")
	private WebElement username;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy (xpath="//button//div")
	private WebElement login;
	
	@FindBy (xpath="//p[@role='alert']")
	private WebElement error;
	
	@FindBy (xpath="//a[text()='Forgot password?']")
	private WebElement forgot;
	
	@FindBy (xpath="//p//span")
	private WebElement signup;
	
	@FindBy (xpath="//button[text()='Not Now']")
	private WebElement save_info;
	
	@FindBy (xpath="//h2")
	private List<WebElement> turn_notification;
	
	@FindBy (xpath="//button[text()='Not Now']")
	private WebElement notification;
	
	private WebDriver driver;
	//variable initialization
	public Insta_Login(WebDriver driver) {
		PageFactory.initElements( driver,this);
		this.driver=driver;
	}
	
	//variable use
	public void edit_username(String str) {
		username.sendKeys(str);
	}
	
	public void edit_password(String pass) {
		password.sendKeys(pass);
	}
	
	public void login_button() {
		login.click();
	}
	
	public String error() {
		return error.getText();
	}
	
	public void save_info() {
		save_info.click();
	}
	
	public void turn_notification() {
		if(turn_notification.size()!=0)
			notification.click(); 
		else
			System.out.println("Notifications not present");
	}
	
	public void forgot_password_link() throws InterruptedException {
		forgot.click();
		Thread.sleep(3000);
	}
	
	public void sign_up() {
		signup.click();;
	}
	
	public void logging() {
		username.sendKeys("8484801704");
		password.sendKeys("alliswell1");
		login.click();
	}
}
