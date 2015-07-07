package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewArticle_page extends Abstract_page {

	private WebDriver driver;

	public NewArticle_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Create new article
	 * 
	 * Parameter: title, category, status, content
	 * 
	 * Author: Tan Vo
	 */
	public Article_page addNewArticle(String _title, String _category,
			String _status, String _content, String _image, String button) {
		enterTitle(_title);
		selectCatetory(_category);
		if (_status != "") {
			selectStatus(_status);
		}
		enterArticleText(_content);

		if (_image != "") {
			insertImage(_image);
		}
		switch (button) {
		case "Save":
			clickSavebutton();
		case "": case "SaveAndClose":
			clickSaveandClosebutton();
		}

		return new Article_page(driver);
	}

	/*
	 * Edit an article
	 * 
	 * Parameter: title, category, status, content
	 * 
	 * Author: Tan Vo
	 */
	public void insertImage(String image) {

		click(driver, By.xpath(Interfaces.NewArticlePage.BTN_IMAGE));
		driver.switchTo().frame(
				driver.findElement(By.xpath("//iframe[@frameborder='0']")));
		switchFrame(driver, By.xpath(Interfaces.NewArticlePage.FRAME_IMAGE));
		click(driver,
				By.xpath("//div[@class='item']/a[@title='" + image + "']/img"));

	}

	/*
	 * Edit an article
	 * 
	 * Parameter: title, category, status, content
	 * 
	 * Author: Tan Vo
	 */
	public Article_page editArticle(String title, String category,
			String status, String content) {

		enterTitle(title);
		selectCatetory(category);
		if (status != "") {
			selectStatus(status);
		}
		enterArticleText(content);
		clickSaveandClosebutton();

		return new Article_page(driver);
	}

	/*
	 * Enter title
	 * 
	 * Parameter: title
	 * 
	 * Author: Tan Vo
	 */
	public void enterTitle(String _title) {
		enter(driver, By.xpath(Interfaces.NewArticlePage.TXT_TITLE), _title);
	}

	/*
	 * Select Category
	 * 
	 * Parameter: category
	 * 
	 * Author: Tan Vo
	 */
	public void selectCatetory(String _cate) {
		select(driver, By.xpath(Interfaces.NewArticlePage.DROP_CATEGORY), _cate);
	}

	/*
	 * Select Status
	 * 
	 * Parameter: Status
	 * 
	 * Author: Tan Vo
	 */
	public void selectStatus(String _status) {
		select(driver, By.xpath(Interfaces.NewArticlePage.DROP_STATUS), _status);
	}

	/*
	 * Enter content
	 * 
	 * Parameter: content
	 * 
	 * Author: Tan Vo
	 */
	public void enterArticleText(String _content) {
		switchFrame(driver, By.xpath(Interfaces.NewArticlePage.FRAME_CONTENT));
		enter(driver, By.xpath(Interfaces.NewArticlePage.TXT_CONTENT), _content);
		driver.switchTo().defaultContent();
	}

	/*
	 * Click on Save button
	 * 
	 * Author: Tan Vo
	 */
	public void clickSavebutton() {
		click(driver, By.xpath(Interfaces.NewArticlePage.BTN_SAVE));
	}

	/*
	 * Click on Save&Close button
	 * 
	 * Author: Tan Vo
	 */
	public void clickSaveandClosebutton() {
		click(driver, By.xpath(Interfaces.NewArticlePage.BTN_SAVEANDCLOSE));
	}

	/*
	 * Click on Save&New button
	 * 
	 * Author: Tan Vo
	 */
	public void clickSaveandNewbutton() {
		click(driver, By.xpath(Interfaces.NewArticlePage.BTN_SAVEANDNEW));
	}

	/*
	 * Click on Cancel button
	 * 
	 * Author: Tan Vo
	 */
	public void clickCancelbutton() {
		click(driver, By.xpath(Interfaces.NewArticlePage.BTN_CANCEL));
	}
}
