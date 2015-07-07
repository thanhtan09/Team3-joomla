package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCategory_page extends Abstract_page{

	private WebDriver driver;
	public NewCategory_page(WebDriver driver) {
		this.driver = driver;
	}
	
	public void addNew(String title){
		enter(driver, By.xpath(Interfaces.NewCatetoryPage.TXT_TITLE), title);
		click(driver, By.xpath(Interfaces.NewCatetoryPage.BTN_SAVEANDCLOSE));
	}
}
