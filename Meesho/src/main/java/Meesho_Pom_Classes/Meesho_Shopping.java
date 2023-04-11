package Meesho_Pom_Classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Meesho_Shopping {
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	JavascriptExecutor js;
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement search;
	
	@FindBy(xpath="//div[@class='search-results']//div[2]")
	private WebElement skirt;
	
	@FindBy(xpath="(//div[contains(@class, \"sc-ftTHYK ProductList__GridCol\")])[2]")
	private WebElement second_skirt;
	
	@FindBy(xpath="//span[text()='Add to Cart']")
	private WebElement cart;
	
	@FindBy(xpath="//input[@type='tel']")
	private WebElement phone;
	
	@FindBy(xpath="//span[text()='Continue']")
	private WebElement continuee;
	
	public  Meesho_Shopping(WebDriver driver) {
		PageFactory.initElements( driver,this);
		this.driver=driver;
		wait= new WebDriverWait(driver,20);
		act=new Actions(driver);
		js=(JavascriptExecutor)driver;
	}
	
	public void shopping() throws InterruptedException {
		search.click();
		search.sendKeys("skirt");
		Thread.sleep(3000);
		act.moveToElement(skirt).click().build().perform();
		Thread.sleep(3000);
		act.moveToElement(second_skirt).click().build().perform();
		Thread.sleep(3000);
		cart.click();
		phone.sendKeys("8484801704");
		continuee.click();
		Thread.sleep(3000);
	}
	
	
}
