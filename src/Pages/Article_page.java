package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Article_page extends Abstract_page{

	private WebDriver driver;
	
	//Message
	private String MESSAGESUCCESS = "Article successfully saved";
	private String MESSAGEPUBLISH = "1 article published.";
	private String MESSAGEUNPUBLISH = "1 article unpublished.";
	private String MESSAGEARCHIVE = "1 article archived.";
	private String MESSAGEDELETE = "1 article deleted.";
	
	//Status
	private String STATUS_TRASHED = "Trashed";
	private String STATUS_ARCHIVED = "Archived";
	private String PUBLISH = "Published";
	private String UNPUBLISH = "Unpublished";
	
	public Article_page(WebDriver driver){
		this.driver = driver;
	}
	
	/*
	 * Open new article page
	 * 
	 * Author: Tan Vo
	 */
	public NewArticle_page openNewArticlepage(){
		clickNewbutton();		
		return new NewArticle_page(driver);
	}
	
	/*
	 * Click on New button
	 * 
	 * Author: Tan Vo
	 */
	public void clickNewbutton(){
		click(driver,By.xpath(Interfaces.ArticlePage.BTN_NEW));
	}

	/*
	 * Is message Article successfully saved displayed 
	 * 
	 * Author: Tan Vo
	 */
	public boolean isArticleDisplay(String article){
		boolean show = false;
		show = getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE)).contains(MESSAGESUCCESS);	
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(article)){
				show = true;
				break;
			}
		}
		return show;
	}
	
	/*
	 * Is article publish
	 * 
	 * Author: Giang Nguyen
	 */
	public boolean isPublish(String article){
		boolean show = false;
		if(getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE)).equals(MESSAGEPUBLISH))
			show = true;
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(article)){
				if(getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+3+"]/a/span/span")).equals(PUBLISH))
					show = true;
				break;
			}
		}
		
		return show;
	}
	
	/*
	 * Is article unpublish
	 * 
	 * Author: Giang Nguyen
	 */
	public boolean isUnPublish(String article){
		boolean show = false;
		
		if(getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE)).equals(MESSAGEUNPUBLISH))
			show = true;
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(article)){
				if(getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a/span")).equals(UNPUBLISH))
					show = true;
				break;
			}
		}
		
		return show;
	}
	
	/*
	 * Is article archive
	 * 
	 * Author: Nga Nguyen
	 */
	public boolean isArchiveMessage(){
		boolean show = false;
		if(getText(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE)).equals(MESSAGEARCHIVE))
			show = true;
		
		return show;
	}
	
	/*
	 * Is article in archive list
	 * 
	 * Author: Nga Nguyen
	 */
	public boolean isArchiveList(String article){
		boolean show = false;

		select(driver, By.xpath(Interfaces.ArticlePage.DROP_STATUS), STATUS_ARCHIVED);
		refresh(driver);
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(article)){
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
	public NewArticle_page enterArticle(String article){
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(article)){
				click(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+1+"]/input[@type='checkbox']"));
				break;
			}
		}
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_EDIT));
		
		return new NewArticle_page(driver);
	}
	
	/*
	 * Delete an article 
	 * 
	 * Parameter: article name
	 * 
	 * Author: Tan Vo
	 */
	public void deleteArticle(String _article){
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(_article)){
				click(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+1+"]/input[@type='checkbox']"));
				break;
			}
		}
		click(driver,By.xpath(Interfaces.ArticlePage.BTN_TRASH));		
		select(driver, By.xpath(Interfaces.ArticlePage.DROP_STATUS), STATUS_TRASHED);
		
		int iCount1 = 0;
		iCount1 = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount1;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(_article)){
				click(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+1+"]/input[@type='checkbox']"));
				break;
			}
		}		
		click(driver, By.xpath(Interfaces.ArticlePage.BTN_EMPTYTRASH));
		waitControlExist(driver, By.xpath(Interfaces.ArticlePage.CONTROL_MESSAGE+"[contains(text(),'"+MESSAGEDELETE+"')]"));
		
	}
	
	/*
	 * Publish article 
	 * 
	 * Parameter: article name
	 * 
	 * Author: Giang Nguyen
	 */
	public void publishArticle(String article){
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(article)){
				click(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+1+"]/input[@type='checkbox']"));
			
				break;
			}
		}
		click(driver,By.xpath(Interfaces.ArticlePage.BTN_PUBLISH));
	}
	
	/*
	 * UnPublish article 
	 * 
	 * Parameter: article name
	 * 
	 * Author: Giang Nguyen
	 */
	public void unpublishArticle(String article){
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(article)){
				click(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+1+"]/input[@type='checkbox']"));
			
				break;
			}
		}
		click(driver,By.xpath(Interfaces.ArticlePage.BTN_UNPUBLISH));
	}
	
	/*
	 * Archive article 
	 * 
	 * Parameter: article name
	 * 
	 * Author: Nga Nguyen
	 */
	public void archiveArticle(String article){
		int iCount = 0;
		iCount = countElement(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR));
		for(int i=1;i<=iCount;i++){
			String cell = getText(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+2+"]/a"));
			if(cell.equals(article)){
				click(driver, By.xpath(Interfaces.ArticlePage.TABLE_TR+"["+i+"]/td["+1+"]/input[@type='checkbox']"));
			
				break;
			}
		}
		click(driver,By.xpath(Interfaces.ArticlePage.BTN_ARCHIVE));
	}
}
