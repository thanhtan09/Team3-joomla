package TestCases.ARTICLE;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Article_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;
import Pages.NewArticle_page;

public class TC_JOOMLA_ARTICLE_017 extends Abstract_test {
	
	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	private NewArticle_page newArticlePage;
	
	@BeforeMethod
	public void setup(){
		driver = openJoomla();
	}
	
	@Test(description = "User can create a new article with 'Public' Access Level property")
	public void TC_ARTICLE_017 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		newArticlePage = articlePage.openNewArticlepage();
		
		articlePage = newArticlePage.addNewArticle(article.getTitle(), article.getCategory(), "", article.getContent(),"");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article.getTitle()));	
		
		log.info("Verify the Access Level of the article is displayed as 'Public'");
		verifyTrue(articlePage.isPublicAccessArticle(article.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article.getTitle());
		shutdown();
	}
}