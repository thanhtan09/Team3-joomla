package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Article_page extends Abstract_page {

	private WebDriver driver;

	// Message
	private String MESSAGESUCCESS = "Article successfully saved";
	private String MESSAGEPUBLISH = "1 article published.";
	private String MESSAGEUNPUBLISH = "1 article unpublished.";
	private String MESSAGEARCHIVE = "1 article archived.";
	private String MESSAGEDELETE = "1 article deleted.";
	private String MESSAGECHECKIN = "1 article successfully checked in";

	// Status
	private String STATUS_TRASHED = "Trashed";
	private String STATUS_ARCHIVED = "Archived";
	private String STATUS_ALL = "All";
	private String PUBLISH = "Published";
	private String UNPUBLISH = "Unpublished";
	private String FRATURED = "Featured article";
	private String UNFRATURED = "Unfeatured article";
	private String ACCESS_PUBLIC = "Public";

	public Article_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Add new article
	 * 
	 * Author: Tan Vo
	 */
	public void addNewArticle(String _title, String _category,
			String _status, String _content, String _image, String button) {
		clickNewbutton();
		
		NewArticle_page newarticle = Factory_page.getNewArticlePage(driver);
		
		newarticle.addNewArticle(_title, _category, _status, _content, _image, button);
		
	}

	/*
	 * Click on New button
	 * 
	 * Author: Tan Vo
	 */
	public void clickNewbutton() {
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_NEW));
	}
	
	/*
	 * Is message Article successfully saved displayed
	 * 
	 * Author: Nga Nguyen
	 */
	public boolean isMessageArticleDisplay(){
		if(getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE))
				.equals(MESSAGESUCCESS))
			return true;
		return false;
	}

	/*
	 * Is Article successfully saved displayed
	 * 
	 * Author: Tan Vo
	 */
	public boolean isArticleDisplay(String article) {
		boolean show = false;
		if (getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE))
				.equals(MESSAGESUCCESS)) {
			int iCount = 0;
			iCount = countElement(driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR));
			for (int i = 1; i <= iCount; i++) {
				String cell = getText(
						driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 2 + "]/a"));
				if (cell.equals(article)) {
					show = true;
					break;
				}
			}
		}
		return show;
	}

	/*
	 * Is article publish
	 * 
	 * Author: Giang Nguyen
	 */
	public boolean isPublish(String article) {
		boolean show = false;
		if (getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE))
				.equals(MESSAGEPUBLISH)) {
			int iCount = 0;
			iCount = countElement(driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR));
			for (int i = 1; i <= iCount; i++) {
				String cell = getText(
						driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 2 + "]/a"));
				if (cell.equals(article)) {
					if (isControlExist(
							driver,
							By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
									+ "]/td[3]/a/span/span[contains(text(),'"
									+ PUBLISH + "')]")))
						show = true;
					break;
				}
			}
		}

		return show;
	}

	/*
	 * Is article unpublish
	 * 
	 * Author: Giang Nguyen
	 */
	public boolean isUnPublish(String article) {
		boolean show = false;

		if (getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE))
				.equals(MESSAGEUNPUBLISH)) {
			int iCount = 0;
			iCount = countElement(driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR));
			for (int i = 1; i <= iCount; i++) {
				String cell = getText(
						driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 2 + "]/a"));
				if (cell.equals(article)) {
					if (isControlExist(
							driver,
							By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
									+ "]/td[3]/a/span/span[contains(text(),'"
									+ UNPUBLISH + "')]")))
						show = true;
					break;
				}
			}
		}

		return show;
	}

	/*
	 * Is article archive
	 * 
	 * Author: Nga Nguyen
	 */
	public boolean isArchiveMessage() {
		if (getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE))
				.equals(MESSAGEARCHIVE))
			return true;

		return false;
	}

	/*
	 * Is article in archive list
	 * 
	 * Author: Nga Nguyen
	 */
	public boolean isArchiveList(String article) {
		boolean show = false;

		select(driver, By.xpath(Interfaces.ArticlePage.DROP_STATUS),
				STATUS_ARCHIVED);
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				show = true;
				break;
			}
		}
		return show;
	}

	/*
	 * Enter edit article page
	 * 
	 * Parameter: article name
	 * 
	 * Author: Tan Vo
	 */
	public Article_page editArticle(String oldtitle,String title,String category, String status, String content) {
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(oldtitle)) {
				click(driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 1 + "]/input[@type='checkbox']"));
				break;
			}
		}
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_EDIT));

		NewArticle_page newarticle = Factory_page.getNewArticlePage(driver);
		newarticle.editArticle(title, category, status, content);
		
		return new Article_page(driver);
	}

	/*
	 * Delete article
	 * 
	 * Parameter: article name
	 * 
	 * Author: Tan Vo
	 */
	public void deleteArticle(String _article) {
		select(driver, By.xpath(Interfaces.ArticlePage.DROP_STATUS),
				"All");
		searchforArticle(_article);
		click(driver, By.xpath(Interfaces.BannerPage.CHECKBOX_1));
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_TRASH));
		select(driver, By.xpath(Interfaces.ArticlePage.DROP_STATUS),
				STATUS_TRASHED);
		
		click(driver, By.xpath(Interfaces.BannerPage.CHECKBOX_1));
		
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_EMPTYTRASH));
		waitControlExist(
				driver,
				By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE
						+ "[contains(text(),'" + MESSAGEDELETE + "')]"));		
	}

	/*
	 * Publish article
	 * 
	 * Parameter: article name
	 * 
	 * Author: Giang Nguyen
	 */
	public void publishArticle(String article) {
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				click(driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 1 + "]/input[@type='checkbox']"));

				break;
			}
		}
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_PUBLISH));
	}

	/*
	 * UnPublish article
	 * 
	 * Parameter: article name
	 * 
	 * Author: Giang Nguyen
	 */
	public void unpublishArticle(String article) {
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				click(driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 1 + "]/input[@type='checkbox']"));

				break;
			}
		}
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_UNPUBLISH));
	}

	/*
	 * Archive article
	 * 
	 * Parameter: article name
	 * 
	 * Author: Nga Nguyen
	 */
	public void archiveArticle(String article) {
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				click(driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 1 + "]/input[@type='checkbox']"));

				break;
			}
		}
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_ARCHIVE));
	}

	/*
	 * Click on filter ordering
	 * 
	 * Author: Tan Vo
	 */
	public void clickOrdering() {
		click(driver, By.xpath(Interfaces.ArticlePage.FILTER_ORDERING));
	}

	public boolean isArticleChangePosition(String article) {
		int first, second = 0;

		clickOrdering();
		first = getPositionArticle(article);
		clickOrdering();
		second = getPositionArticle(article);
		clickOrdering();		
		if (first != second)
			return true;
		return false;
	}

	/*
	 * Get position of article in table
	 * 
	 * Parameter: article name
	 * 
	 * Author: Tan Vo
	 */
	public int getPositionArticle(String article) {
		int iCount = 0;
		int position = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				position = i;
				break;
			}
		}
		return position;
	}

	/*
	 * Click on status icon
	 * 
	 * Parameter: article name
	 * 
	 * Author: Tan Vo
	 */
	public void clickStatusIcon(String article) {
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				click(driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[1]/input"));
				click(driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[3]/a/span"));
				break;
			}
		}
	}

	/*
	 * Click on Featured icon
	 * 
	 * Parameter: article name
	 * 
	 * Author: Tan Vo
	 */
	public void clickFeaturedIcon(String article) {

		select(driver, By.xpath(Interfaces.ArticlePage.DROP_STATUS), STATUS_ALL);
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				click(driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[1]/input"));
				click(driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[4]/a/img"));
				break;
			}
		}
	}

	/*
	 * Is Featured article
	 * 
	 * Parameter: article name
	 * 
	 * Author: Tan Vo
	 */
	public boolean isFeaturedArticle(String article) {

		boolean show = false;
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				if (isControlExist(
						driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[4]/a/img[@alt='" + FRATURED + "']"))) {
					show = true;
					break;
				}
			}
		}

		return show;
	}

	/*
	 * Is UnFeatured icon
	 * 
	 * Parameter: article name
	 * 
	 * Author: Tan Vo
	 */
	public boolean isUnFeaturedArticle(String article) {

		boolean show = false;
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				if (isControlExist(
						driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[4]/a/img[@alt='" + UNFRATURED + "']"))) {
					show = true;
					break;
				}
			}
		}

		return show;
	}

	/*
	 * Is Article is public access icon
	 * 
	 * Parameter: article name
	 * 
	 * Author: Giang Nguyen
	 */
	public boolean isPublicAccessArticle(String article) {

		boolean show = false;
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				String access = getText(
						driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 7 + "]"));
				if (access.equals(ACCESS_PUBLIC)) {
					show = true;
					break;
				}
			}
		}

		return show;
	}

	/*
	 * Search for an article
	 * 
	 * Parameter: article name
	 * 
	 * Author: Giang Nguyen
	 */
	public void searchforArticle(String article) {
		enter(driver, By.xpath(Interfaces.ArticlePage.TXT_SEARCH), article);
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_SEARCH));

	}

	/*
	 * Is Search Article Display
	 * 
	 * Parameter: article name
	 * 
	 * Author: Giang Nguyen
	 */
	public boolean isSearchArticleDisplay(String article) {
		boolean search = false;
		if (getText(
				driver,
				By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + 1 + "]/td["
						+ 2 + "]/a")).equals(article)) {
			search = true;
		}
		return search;
	}

	/*
	 * Check in article
	 * 
	 * Author: Nga Nguyen
	 */
	public void checkinArticle(String article) {
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				click(driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 1 + "]/input[@type='checkbox']"));

				break;
			}
		}
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_CHECKIN));
	}

	/*
	 * Is Check in archive
	 * 
	 * Author: Nga Nguyen
	 */
	public boolean isCheckinMessage() {
		if (getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE))
				.equals(MESSAGECHECKIN))
			return true;

		return false;
	}

	/*
	 * Is Checked archive list
	 * 
	 * Author: Nga Nguyen
	 */
	public boolean isCheckinArticle(String article) {
		boolean show = false;

		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for (int i = 1; i <= iCount; i++) {
			String cell = getText(
					driver,
					By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
							+ "]/td[" + 2 + "]/a"));
			if (cell.equals(article)) {
				if (isControlExist(
						driver,
						By.xpath(Interfaces.ArticlePage.TABLE_TR + "[" + i
								+ "]/td[" + 2 + "]/a/span/span")))
					show = true;
				break;
			}
		}
		return show;
	}

	public void selectDisplayItem(String _item) {

		select(driver, By.xpath(Interfaces.ArticlePage.DROP_DISPLAY), _item);

	}

	public boolean isPaging(String _item) {
		boolean paging = false;
		int row = countElement(driver,
				By.xpath(Interfaces.ArticlePage.TABLE_TR));
		String row1 = Integer.toString(row);
		if (row1.equals(_item)) {
			paging = true;
		}
		return paging;
	}
}
