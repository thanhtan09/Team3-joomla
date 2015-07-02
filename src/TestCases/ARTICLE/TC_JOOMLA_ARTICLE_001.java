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

public class TC_JOOMLA_ARTICLE_001 extends Abstract_test{

	ReadData data = new ReadData();
	User user = new User();
	Article article = new Article();
	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	private NewArticle_page newarticlePage;
	
	@BeforeMethod
	public void setup(){
		String url = data.getUrl("Local_url");
		user = data.getUser("Tan");
		article = data.getArticle("Article1");
		driver = openJoomla(url);
	}
	
	@Test(description = "Verify user can create new article with valid information")
	public void TC_001 (){
		
		log.info("Login with valid account");
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(),"");
		
		log.info("Enter Article page");
		articlePage = homePage.navigatetoArticlepage();		
		
		log.info("Create new article");
		newarticlePage = articlePage.openNewArticlepage();
		articlePage = newarticlePage.addNewArticle(article.getTitle(), article.getCategory(), "",article.getContent(),"");
		
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article.getTitle());
		shutdown();
	}
}
