package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Categories_page extends Abstract_page{

	private WebDriver driver;
	
	public Categories_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Click New button
	 * 
	 * Author: Tan Vo
	 */
	public NewCategory_page openNewCatetorypage(){
		clickNew();
		return new NewCategory_page(driver);
	}
	
	/*
	 * Click New button
	 * 
	 * Author: Tan Vo
	 */
	public void clickNew(){
		click(driver, By.xpath(Interfaces.CatetoryPage.BTN_NEW));
	} 
}
