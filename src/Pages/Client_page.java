package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Client_page extends Abstract_page {

	private WebDriver driver;

	public Client_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Open New client page 
	 * 
	 * Author: Tan Vo
	 */
	public NewClient_page navigateNewCLientpage() {
		clickNew();
		
		return new NewClient_page(driver);
	}

	/*
	 * CLick on New button 
	 * 
	 * Author: Tan Vo
	 */
	public void clickNew() {
		click(driver, By.xpath(Interfaces.ClientPage.BTN_NEW));
	}

	/*
	 * CLick on Edit button 
	 * 
	 * Author: Tan Vo
	 */
	public void clickEdit() {
		click(driver, By.xpath(Interfaces.ClientPage.BTN_EDIT));
	}
	
	/*
	 * CLick on Publish button 
	 * 
	 * Author: Tan Vo
	 */
	public void clickPublish(){
		click(driver, By.xpath(Interfaces.ClientPage.BTN_PUBLISH));
	}
	
	/*
	 * CLick on UnPublish button 
	 * 
	 * Author: Tan Vo
	 */
	public void clickUnblish(){
		click(driver, By.xpath(Interfaces.ClientPage.BTN_UNPUBLISH));
	}
	
	/*
	 * CLick on Archive button 
	 * 
	 * Author: Tan Vo
	 */
	public void clickArchive(){
		click(driver, By.xpath(Interfaces.ClientPage.BTN_ARCHIVE));
	}
	
	/*
	 * CLick on Trash button 
	 * 
	 * Author: Tan Vo
	 */
	public void clickTrash(){
		click(driver, By.xpath(Interfaces.ClientPage.BTN_TRASH));
	}
}
