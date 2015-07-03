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

public class TC_JOOMLA_ARTICLE_006 extends Abstract_test{

	ReadData data = new ReadData();
	User user = new User();
	Article article = new Article();
	
	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	private NewArticle_page newArticlePage;
	
	@BeforeMethod
	public void setup(){
		String url = data.getUrl("Local_url");
		user = data.getUser("Nga");
		article = data.getArticle("Article1");
		driver = openJoomla(url);
	}
	
	@Test(description = "Verify user can check in an article")
	public void TC_006 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		newArticlePage = articlePage.openNewArticlepage();
		
		articlePage = newArticlePage.addNewArticle(article.getTitle(), article.getCategory(), "", article.getContent(),"");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article.getTitle()));
		
		log.info("Check in an article");
		articlePage.checkinArticle(article.getTitle());
		
		log.info("Verify the confirm message is displayed");
		verifyTrue(articlePage.isCheckinMessage());
		
		log.info("Verify the archived article is displayed on the table grid");
		verifyTrue(articlePage.isArchiveList(article.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article.getTitle());
		shutdown();
	}
}
