package Red_Bus_Pom_classes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RB_Home_Page {
	@FindBy (xpath="//input[@id='src']")
	private WebElement from;
	
	@FindBy (xpath="//ul[@class='autoFill homeSearch']//li[2]")
	private WebElement listbox;
	
	@FindBy (xpath="//input[@id='dest']")
	private WebElement dest;
	
	@FindBy (xpath="//label[text()='Date']")
	private WebElement date;
	
	@FindBy (id="search_btn")
	private WebElement search;
	
	@FindBy (xpath="//table//td")
	private List<WebElement> td;
	
	public RB_Home_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void form(String from1) {
		from.sendKeys(from1);
		listbox.click();
	}
	
	public void to(String dest1) {
		dest.sendKeys(dest1);
		listbox.click();
	}
	
	public void date() {
		date.click();
	}
	public void search() {
		search.click();
	}
	public void current_day() {
		date.click();
		for(int i=0;i<td.size();i++) {
			if(td.get(i).getText().equals("31")) {
				td.get(i).click();
			}
		}
	}
}
