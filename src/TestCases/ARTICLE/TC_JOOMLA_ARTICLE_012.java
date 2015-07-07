package TestCases.ARTICLE;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Article_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Interfaces;
import Pages.Login_page;

public class TC_JOOMLA_ARTICLE_012 extends Abstract_test{

	private Login_page loginPage;
	private Home_page homePage;
	private Article_page articlePage;
	
	@BeforeMethod
	public void setup(){
		driver = openJoomla();
	}
	
	@Test(description = "User can paging the article using the paging control")
	public void TC_ARTICLE_012 (){
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(), "");
		articlePage = homePage.navigatetoArticlepage();
		articlePage.selectDisplayItem("5");
		verifyTrue(articlePage.isPaging("5"));
		articlePage.selectDisplayItem("All");
		verifyFalse(articlePage.isControlExist(driver, By.xpath(Interfaces.ArticlePage.BAR_PAGING)));		
	}
	
	@AfterMethod
	public void end(){
		shutdown();
	}
}

