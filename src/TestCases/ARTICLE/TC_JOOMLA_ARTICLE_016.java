package TestCases.ARTICLE;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Article_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;

public class TC_JOOMLA_ARTICLE_016 extends Abstract_test{

	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	
	@BeforeMethod
	public void setup(){
		driver = openJoomla();
	}
	
	@Test(description = "Verify user can change the feature property of articles using the Featured column")
	public void TC_ARTICLE_016 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		
		articlePage.addNewArticle(article7.getTitle(), article7.getCategory(), article7.getStatus(), article7.getContent(),"","");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article7.getTitle()));	
		
		log.info("Verify the article is featured successfully");
		articlePage.clickFeaturedIcon(article7.getTitle());
		verifyTrue(articlePage.isFeaturedArticle(article7.getTitle()));		
		
		log.info("Verify the article is unfeatured successfully");
		articlePage.clickFeaturedIcon(article7.getTitle());
		verifyTrue(articlePage.isUnFeaturedArticle(article7.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article7.getTitle());
		shutdown();
	}
}
