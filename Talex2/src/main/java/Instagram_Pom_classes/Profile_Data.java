package Instagram_Pom_classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile_Data {
	WebDriver driver;
	//variable declaration
	@FindBy (xpath="//a[@href='/_rutu_1711/']")
	private WebElement profile;
	
	@FindBy (xpath="//h1")
	private WebElement bio;
	
	public Profile_Data(WebDriver driver) {
		PageFactory.initElements( driver,this);
		this.driver=driver;
	}
	
	public void profile() throws InterruptedException {
		profile.click();
		Thread.sleep(10000);
		System.out.println(bio.getText());
		driver.navigate().back();
	}
}
