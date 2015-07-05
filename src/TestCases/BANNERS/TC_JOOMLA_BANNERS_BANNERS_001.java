package TestCases.BANNERS;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Functions.Abstract_test;
import Pages.Client_page;
import Pages.Factory_page;
import Pages.Home_page;
import Pages.Login_page;
import Pages.NewClient_page;

public class TC_JOOMLA_BANNERS_BANNERS_001 extends Abstract_test{

	private Login_page loginPage;
	private Home_page homePage;
	private Client_page clientPage;
	private NewClient_page newclientPage;
	
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
		newclientPage = clientPage.navigateNewCLientpage();
		
		newclientPage.addClient(client.getName(), client.getContact(), client.getEmail(), "");
		
	}
	
	@AfterMethod
	public void end(){
		//shutdown();
	}
}
