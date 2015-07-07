package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewBanner_page extends Abstract_page {

	private WebDriver driver;

	public NewBanner_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Create new banner
	 * 
	 * Author: Tan Vo
	 */
	public void addNew(String name, String category, String client,
			String button) {
		enter(driver, By.xpath(Interfaces.NewBannerPage.TXT_NAME), name);
		selectCategory(category);
		selectClient(client);
		switch (button) {
		case "Save":
			clickSave();
		case "":
		case "SaveAndClose":
			clickSaveandClose();
		}
	}

	/*
	 * Click Save button
	 * 
	 * Author: Tan Vo
	 */
	public void clickSave() {
		click(driver, By.xpath(Interfaces.NewBannerPage.BTN_SAVE));
	}

	/*
	 * Click on Save and Close
	 * 
	 * Author: Tan VO
	 */
	public void clickSaveandClose() {
		click(driver, By.xpath(Interfaces.NewBannerPage.BTN_SAVEANDCLOSE));
	}

	/*
	 * Select category
	 * 
	 * Author: Tan Vo
	 */
	public void selectCategory(String cate) {
		select(driver, By.xpath(Interfaces.NewBannerPage.DROP_CATEGORY), "- "
				+ cate);
	}

	/*
	 * Select client
	 * 
	 * Author: Tan Vo
	 */
	public void selectClient(String client) {
		select(driver, By.xpath(Interfaces.NewBannerPage.DROP_CLIENT), client);
	}
}
