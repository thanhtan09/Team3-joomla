package TestCases.ARTICLE;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Databases.Article;
import Databases.User;
import Functions.Abstract_test;
import Functions.ReadData;
import Pages.Article_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;
import Pages.NewArticle_page;

public class TC_JOOMLA_ARTICLE_015 extends Abstract_test{

	ReadData data = new ReadData();
	User user = new User();
	Article article1 = new Article();
	
	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	private NewArticle_page newArticlePage;
	
	@BeforeMethod
	public void setup(){
		String url = data.getUrl("Local_url");
		user = data.getUser("Tan");
		article1 = data.getArticle("Article6");
		driver = openJoomla(url);
	}
	
	@Test(description = "Verify user can change the status of articles using the Status column")
	public void TC_ARTICLE_015 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		newArticlePage = articlePage.openNewArticlepage();
		
		articlePage = newArticlePage.addNewArticle(article1.getTitle(), article1.getCategory(), article1.getStatus(), article1.getContent(),"");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article1.getTitle()));	
		
		log.info("Verify the article is unpublished successfully");
		articlePage.clickStatusIcon(article1.getTitle());
		verifyTrue(articlePage.isUnPublish(article1.getTitle()));
		
		log.info("Verify the article is published successfully");
		articlePage.clickStatusIcon(article1.getTitle());
		verifyTrue(articlePage.isPublish(article1.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article1.getTitle());
		shutdown();
	}
}
