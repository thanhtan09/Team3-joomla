package TestCases.BANNERS;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Banner_page;
import Pages.Categories_page;
import Pages.Client_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;
import Pages.NewBanner_page;

public class TC_JOOMLA_BANNERS_BANNERS_001 extends Abstract_test{

	private Login_page loginPage;
	private Home_page homePage;
	private Client_page clientPage;
	private Categories_page categoriesPage;
	private Banner_page bannerPage;
	private NewBanner_page newbannerPage;
	
	@BeforeClass
	public void setup(){
		driver = openJoomla();
	}
	
	@Test(description = "Verify that user can create new banner")
	public void TC_BANNERS_001 (){
		
		log.info("Login with valid account");
		loginPage = Factory_page.getLoginPage(driver);
		homePage = loginPage.loginValidAccount(user.getUsername(), user.getPassword(),"");
		
		log.info("Create new client");
		clientPage = homePage.navigatetoCLientpage();
		clientPage.addNewClient(client.getName(), client.getContact(), client.getEmail(), "");
		
		log.info("A message : Client successfully saved shows and new client is created");
		verifyTrue(clientPage.isMessageDisplay());
		verifyTrue(clientPage.isClientcreated(client.getName()));
		
		log.info("Create new category");
		categoriesPage = clientPage.navigateCategoriespage();
		categoriesPage.addNewCategory(category.getTitle());
		
		log.info("A message : Category successfully saved shows and new category is created");
		verifyTrue(categoriesPage.isMessageDisplay());
		verifyTrue(categoriesPage.isCategoryDisplay(category.getTitle()));
		
		log.info("Create new banner");
		bannerPage = categoriesPage.navigatetoBannerpage();
		bannerPage.addNewBanner(banner.getName(), category.getTitle(), client.getName(), "");
		
		log.info("A message : Banner successfully saved shows and new banner is created");
		verifyTrue(bannerPage.isMessageSuccessDisplay());
		verifyTrue(bannerPage.isBannerDisplay(banner.getName()));
	}
	
	@Test(description = "Verify that user can edit a banner")
	public void TC_BANNERS_002(){
		
		log.info("Add new banner");
		bannerPage.addNewBanner(banner2.getName(), category.getTitle(), client.getName(), "Save");
		
		log.info("A message : Banner successfully saved shows and Edit Banner page displays");
		newbannerPage = Factory_page.getNewBannerPage(driver);
		verifyTrue(newbannerPage.isSuccessMessageDisplay());
		verifyTrue(newbannerPage.isEditBannerPage());
	}
	
	@AfterClass
	public void end(){
		log.info("Delete banner");
		bannerPage.deleteBanner(banner.getName());
		bannerPage.deleteBanner(banner2.getName());
		
		log.info("Delete client");
		homePage = Factory_page.getHomePage(driver);
		clientPage = homePage.navigatetoCLientpage();
		clientPage.deleteClient(client.getName());
		
		log.info("Delete category");
		categoriesPage = clientPage.navigateCategoriespage();
		categoriesPage.deleteCategory(category.getTitle());		
		
		shutdown();
	}
}
