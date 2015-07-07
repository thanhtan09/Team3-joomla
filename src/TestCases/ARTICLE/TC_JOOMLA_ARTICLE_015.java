package TestCases.ARTICLE;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Article_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;

public class TC_JOOMLA_ARTICLE_015 extends Abstract_test{

	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	
	@BeforeMethod
	public void setup(){
		driver = openJoomla();
	}
	
	@Test(description = "Verify user can change the status of articles using the Status column")
	public void TC_ARTICLE_015 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		
		articlePage.addNewArticle(article6.getTitle(), article6.getCategory(), article6.getStatus(), article6.getContent(),"","");
		log.info("Verify message Article successfully saved displayed");
		verifyTrue(articlePage.isArticleDisplay(article6.getTitle()));	
		
		log.info("Verify the article is unpublished successfully");
		articlePage.clickStatusIcon(article6.getTitle());
		verifyTrue(articlePage.isUnPublish(article6.getTitle()));
		
		log.info("Verify the article is published successfully");
		articlePage.clickStatusIcon(article6.getTitle());
		verifyTrue(articlePage.isPublish(article6.getTitle()));
	}
	
	@AfterMethod
	public void end(){
		articlePage.deleteArticle(article6.getTitle());
		shutdown();
	}
}
