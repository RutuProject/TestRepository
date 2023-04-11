package Red_Bus_Pom_classes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cab_Booking {
	@FindBy (xpath="(//div[@class='fl clearfix'])//li[2]")
	private WebElement ryde;
	
	@FindBy (xpath="//div[@class='jPh6ep5ChZtDg5e4FH9G']//div[@class='lp_OXJGecPx7FENIgnfi']")
	private List<WebElement> reviews;
	
	public Cab_Booking(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ryde() {
		ryde.click();
		 for(int i=0;i<reviews.size();i++) {
			 System.out.printf("%s  ",reviews.get(i).getText());
			 }
		 System.out.println();
	}
}
