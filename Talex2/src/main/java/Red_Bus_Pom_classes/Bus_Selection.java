package Red_Bus_Pom_classes;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bus_Selection {
	JavascriptExecutor js;
	@FindBy (xpath="//ul[@class='bus-items']//div[text()='']")
	private List<WebElement> busses;
	
	@FindBy (xpath="//ul[@class='clearfix multiFare']//li")
	private List<WebElement> prices;
	
	public Bus_Selection(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int bus_booking() {
		for(int i=0;i<busses.size();i++) {
			if(busses.get(i).getText().equals("Konduskar Travels Pvt. Ltd")) {
				System.out.printf("%s=  ",busses.get(i).getText());
				return i+1;
			}
		}
		return 0;
	}
	
	
	public void all_prices() {
		for(int i=1;i<prices.size();i++) {
				System.out.printf("%s  ",prices.get(i).getText());
		}
		System.out.println();
	}
	
}
