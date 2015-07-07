package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Client_page extends Abstract_page {

	private WebDriver driver;
	
	private String MESSAGESUCCESS = "Client successfully saved";
	private String MESSAGE_TRASH = "1 client successfully deleted";
	private String STATUS_TRASH = "Trashed";

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
	 * Is new client created
	 * 
	 * Author: Tan Vo
	 */
	public boolean isClientcreated(String client){
		boolean display = false;
		
		int iCount = 0;
		iCount = countElement(driver,
				By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[2]/a"));
			if (cell.equals(client)) {
				display = true;
				break;
			}
		}
		
		return display;
	}

	/*
	 * Open New client page 
	 * 
	 * Author: Tan Vo
	 */
	public NewClient_page addNewClient(String name, String contact, String email, String status) {
		clickNew();	
		
		NewClient_page newClient = Factory_page.getNewClientPage(driver);
		newClient.addClient(name, contact, email, status);
		
		return new NewClient_page(driver);
	}
	
	/*
	 * Open Category page 
	 * 
	 * Author: Tan Vo
	 */
	public Categories_page navigateCategoriespage(){
		
		hover(driver, By.xpath("//ul[@id='menu']/li/a[contains(text(),'Components')]"));
		hover(driver, By.xpath("//ul[@id='menu']/li/ul/li/a[contains(text(),'Banners')]"));
		click(driver, By.xpath("//ul[@id='menu']/li/ul/li//ul/li/a[contains(text(),'Categories')]"));
		
		return new Categories_page(driver);
	}

	/*
	 * Delete client 
	 * 
	 * Author: Tan Vo
	 */
	public void deleteClient(String client){
		select(driver, By.xpath(Interfaces.ClientPage.DROP_STATUS), "All");
		searchClient(client);
		click(driver, By.xpath(Interfaces.ClientPage.CHECKBOX_1));
		clickTrash();
		
		select(driver, By.xpath(Interfaces.ClientPage.DROP_STATUS), STATUS_TRASH);
		click(driver, By.xpath(Interfaces.ClientPage.CHECKBOX_1));
		clickEmptyTrash();
		
		waitControlExist(
				driver,
				By.xpath(Interfaces.ClientPage.MESSAGE
						+ "[contains(text(),'" + MESSAGE_TRASH + "')]"));
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
	
	/*
	 * Click Empty Trash button
	 * 
	 * Author: Tan Vo
	 */
	public void clickEmptyTrash(){
		click(driver, By.xpath(Interfaces.ClientPage.BTN_EMPTYTRASH));
	}
	
	/*
	 * Search client
	 * 
	 * Author: Tan Vo
	 */
	public void searchClient(String client){
		enter(driver, By.xpath(Interfaces.ClientPage.TXT_SEARCH), client);
		click(driver, By.xpath(Interfaces.ClientPage.BTN_SEARCH));
	}
	
	
}
