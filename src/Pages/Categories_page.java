package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Categories_page extends Abstract_page {

	private WebDriver driver;
	private String MESSAGESUCCESS = "Category successfully saved";
	private String MESSAGE_TRASH = "1 category successfully deleted";
	private String STATUS_TRASHED = "Trashed";

	public Categories_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Click New button
	 * 
	 * Author: Tan Vo
	 */
	public Categories_page addNewCategory(String title) {
		clickNew();

		NewCategory_page newCate = Factory_page.getNewCategoryPage(driver);
		newCate.addNew(title);
		return new Categories_page(driver);
	}
	
	/*
	 * Navigate to Banner page
	 * 
	 * Author: Tan Vo
	 */
	public Banner_page navigatetoBannerpage(){
		
		hover(driver, By.xpath("//ul[@id='menu']/li/a[contains(text(),'Components')]"));
		hover(driver, By.xpath("//ul[@id='menu']/li/ul/li/a[contains(text(),'Banners')]"));
		click(driver, By.xpath("//ul[@id='menu']/li/ul/li/ul/li/a[contains(text(),'Banners')]"));		
		
		return new Banner_page(driver);
	}

	/*
	 * Check message display
	 * 
	 * Author: Tan Vo
	 */
	public boolean isMessageDisplay() {
		if (getText(driver, By.xpath(Interfaces.CatetoryPage.MESSAGE)).equals(
				MESSAGESUCCESS))
			return true;
		return false;
	}

	/*
	 * Check category is created
	 * 
	 * Author: Tan Vo
	 */
	public boolean isCategoryDisplay(String cate) {
		boolean display = false;

		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[2]/a"));
			if (cell.equals(cate)) {
				display = true;
				break;
			}
		}

		return display;

	}
	
	/*
	 * Delete Category
	 * 
	 * Author: Tan Vo
	 */
	public void deleteCategory(String cate){
		select(driver, By.xpath(Interfaces.CatetoryPage.DROP_STATUS), "All");
		searchCategory(cate);
		click(driver, By.xpath(Interfaces.CatetoryPage.CHECKBOX_1));
		clickTrash();
		select(driver, By.xpath(Interfaces.CatetoryPage.DROP_STATUS), STATUS_TRASHED);
		
		click(driver, By.xpath(Interfaces.CatetoryPage.CHECKBOX_1));
		clickEmptyTrash();
		waitControlExist(
				driver,
				By.xpath(Interfaces.CatetoryPage.MESSAGE
						+ "[contains(text(),'" + MESSAGE_TRASH + "')]"));
	}

	/*
	 * Click New button
	 * 
	 * Author: Tan Vo
	 */
	public void clickNew() {
		click(driver, By.xpath(Interfaces.CatetoryPage.BTN_NEW));
	}
	
	/*
	 * Click Trash button
	 * 
	 * Author: Tan Vo
	 */
	public void clickTrash(){
		click(driver, By.xpath(Interfaces.CatetoryPage.BTN_TRASH));
	}
	
	/*
	 * Click Empty Trash button
	 * 
	 * Author: Tan Vo
	 */
	public void clickEmptyTrash(){
		click(driver, By.xpath(Interfaces.CatetoryPage.BTN_EMPTYTRASH));
	}
	
	/*
	 * Search banner
	 * 
	 * Author: Tan Vo
	 */
	public void searchCategory(String cate){
		enter(driver, By.xpath(Interfaces.CatetoryPage.TXT_SEARCH), cate);
		click(driver, By.xpath(Interfaces.CatetoryPage.BTN_SEARCH));
	}
}
