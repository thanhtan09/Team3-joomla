package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Client_page extends Abstract_page {

	private WebDriver driver;
	
	private String MESSAGESUCCESS = "Client successfully saved";

	public Client_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Is messagge success displays
	 * 
	 * Author: Tan Vo
	 */
	public boolean isMessageDisplay(){
		if(getText(driver, By.xpath(Interfaces.ClientPage.MESSAGE)).equals(MESSAGESUCCESS))
			return true;
		return false;
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
	 * Open Category page 
	 * 
	 * Author: Tan Vo
	 */
	public Categories_page navigateCategoriespage(){
		navigateMenu(driver, "Components|Banners|Categories");
		
		return new Categories_page(driver);
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
