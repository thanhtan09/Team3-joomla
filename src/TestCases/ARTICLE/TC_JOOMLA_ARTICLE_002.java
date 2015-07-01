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

public class TC_JOOMLA_ARTICLE_002 extends Abstract_test{

	ReadData data = new ReadData();
	User user = new User();
	Article article,article2 = new Article();
	
	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	private NewArticle_page newArticlePage;
	
	@BeforeMethod
	public void setup(){
		String url = data.getUrl("Local_url");
		user = data.getUser("default user");
		article = data.getArticle("Article1");
		article2 = data.getArticle("Article2");
		driver = openJoomla(url);
	}
	
	@Test
	public void TC_002 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		newArticlePage = articlePage.openNewArticlepage();
		
		articlePage = newArticlePage.addNewArticle(article.getTitle(), article.getCategory(), "", article.getContent(),"");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article.getTitle()));
		
		newArticlePage = articlePage.enterArticle(article.getTitle());
		articlePage = newArticlePage.editArticle(article2.getTitle(), article2.getCategory(), "", article2.getContent());
		
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article2.getTitle());
		shutdown();
	}
}
