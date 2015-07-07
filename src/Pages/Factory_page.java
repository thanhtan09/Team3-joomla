package Pages;

import org.openqa.selenium.WebDriver;


public class Factory_page {

	public static Login_page getLoginPage(WebDriver driver)
	{
		return new Login_page(driver);
	}
	
	public static Home_page getHomePage(WebDriver driver)
	{
		return new Home_page(driver);
	}
	
	public static Article_page getArticlePage(WebDriver driver)
	{
		return new Article_page(driver);
	}
	
	public static NewArticle_page getNewArticlePage(WebDriver driver)
	{
		return new NewArticle_page(driver);
	}
}
