package TestCases.BANNERS;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Banner_page;
import Pages.Categories_page;
import Pages.Client_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;

public class TC_JOOMLA_BANNERS_BANNERS_001 extends Abstract_test{

	private Login_page loginPage;
	private Home_page homePage;
	private Client_page clientPage;
	private Categories_page categoriesPage;
	private Banner_page bannerPage;
	
	@BeforeMethod
	public void setup(){
		driver = openJoomla();
	}
	
	@Test(description = "Verify user can create new article with valid information")
	public void TC_BANNERS_001 (){
		
		log.info("Login with valid account");
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(),"");
		
		clientPage = homePage.navigatetoCLientpage();	
		clientPage.addNewClient(client.getName(), client.getContact(), client.getEmail(), "");		
		verifyTrue(clientPage.isMessageDisplay());
		
		categoriesPage = clientPage.navigateCategoriespage();
		categoriesPage.addNewCategory(category.getTitle(), category.getDescription());
		verifyTrue(categoriesPage.isMessageSuccessDisplay());
		
		bannerPage = categoriesPage.navigatetoBannerpage();
		
		
	}
	
	@AfterMethod
	public void end(){
		
		shutdown();
	}
}
