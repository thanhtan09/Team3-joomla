package TestCases.ARTICLE;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Article_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;

public class TC_JOOMLA_ARTICLE_006 extends Abstract_test{

	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	private String article1;
	
	@BeforeMethod
	public void setup(){
		driver = openJoomla();
		article1 = article.getTitle();
	}
	
	@Test(description = "Verify user can check in an article")
	public void TC_ARTICLE_006 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		
		articlePage.addNewArticle(article.getTitle(), article.getCategory(), "", article.getContent(),"","Save");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isMessageArticleDisplay());
		
		shutdown();
		
		driver = openJoomla();
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		
		log.info("Check in an article");
		articlePage.checkinArticle(article1);
	
		log.info("Verify the confirm message is displayed");
		verifyTrue(articlePage.isCheckinMessage());
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article1);
		shutdown();
	}
}
