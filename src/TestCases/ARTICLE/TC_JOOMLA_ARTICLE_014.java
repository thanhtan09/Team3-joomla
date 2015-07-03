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

public class TC_JOOMLA_ARTICLE_014 extends Abstract_test{

	ReadData data = new ReadData();
	User user = new User();
	Article article1,article2 = new Article();
	
	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	private NewArticle_page newArticlePage;
	
	@BeforeMethod
	public void setup(){
		String url = data.getUrl("Local_url");
		user = data.getUser("Tan");
		article1 = data.getArticle("Article4");
		article2 = data.getArticle("Article5");
		driver = openJoomla(url);
	}
	
	@Test(description = "Verify user can change the order of articles using the Ordering column")
	public void TC_ARTICLE_014 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		newArticlePage = articlePage.openNewArticlepage();
		
		articlePage = newArticlePage.addNewArticle(article1.getTitle(), article1.getCategory(), "", article1.getContent(),"");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article1.getTitle()));	
		
		newArticlePage = articlePage.openNewArticlepage();
		articlePage = newArticlePage.addNewArticle(article2.getTitle(), article2.getCategory(), "", article2.getContent(), "");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article2.getTitle()));
		
		log.info("Verify the first article changes its position with the second article");
		verifyTrue(articlePage.isArticleChangePosition(article1.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle("all");
		shutdown();
	}
}
