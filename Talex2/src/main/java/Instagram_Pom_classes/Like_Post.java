package Instagram_Pom_classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Like_Post {
	Actions act;
	JavascriptExecutor js;
	@FindBy(xpath="(//span[@class='_aamw'])[1]")
	private WebElement like;
	
	public Like_Post(WebDriver driver) {
		PageFactory.initElements(driver,this);
		act=new Actions(driver);
		js=(JavascriptExecutor)driver;
	}
	
	public void like() {
		//js.executeScript("arguments[0].scrollIntoView();", like);
		//act.moveToElement(like).click().build().perform();
		like.click();
	}
}
