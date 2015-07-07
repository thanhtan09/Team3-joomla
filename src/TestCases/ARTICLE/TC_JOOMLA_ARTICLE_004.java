package TestCases.ARTICLE;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Article_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;

public class TC_JOOMLA_ARTICLE_004 extends Abstract_test{
	
	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	
	@BeforeMethod
	public void setup(){
		driver = openJoomla();
	}
	
	@Test
	public void TC_ARTICLE_004 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		
		articlePage.addNewArticle(article.getTitle(), article.getCategory(), "", article.getContent(),"","");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article.getTitle()));
		
		log.info("UNPublish an article");
		articlePage.unpublishArticle(article.getTitle());
		
		log.info("Verify the article is unpublished successfully");
		verifyTrue(articlePage.isUnPublish(article.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article.getTitle());
		shutdown();
	}
}
