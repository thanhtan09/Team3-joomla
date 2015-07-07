package TestCases.ARTICLE;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.*;

public class TC_JOOMLA_ARTICLE_001 extends Abstract_test{

	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	
	@BeforeMethod
	public void setup(){
		driver = openJoomla();
	}
	
	@Test(description = "Verify user can create new article with valid information")
	public void TC_ARTICLE_001 (){
		
		log.info("Login with valid account");
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(),"");
		
		log.info("Enter Article page");
		articlePage = homePage.navigatetoArticlepage();		
		
		log.info("Create new article");
		articlePage.addNewArticle(article.getTitle(), article.getCategory(), "",article.getContent(),"","");
		
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article.getTitle());
		shutdown();
	}
}
