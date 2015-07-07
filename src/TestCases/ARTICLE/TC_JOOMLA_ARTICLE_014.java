package TestCases.ARTICLE;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Article_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;

public class TC_JOOMLA_ARTICLE_014 extends Abstract_test{

	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	
	@BeforeMethod
	public void setup(){
		driver = openJoomla();
	}
	
	@Test(description = "Verify user can change the order of articles using the Ordering column")
	public void TC_ARTICLE_014 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		
		articlePage.addNewArticle(article4.getTitle(), article4.getCategory(), "", article4.getContent(),"","");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article4.getTitle()));	
		
		articlePage.addNewArticle(article5.getTitle(), article5.getCategory(), "", article5.getContent(), "","");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article5.getTitle()));
		
		log.info("Verify the first article changes its position with the second article");
		verifyTrue(articlePage.isArticleChangePosition(article5.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article4.getTitle());
		articlePage.deleteArticle(article5.getTitle());
		shutdown();
	}
}
