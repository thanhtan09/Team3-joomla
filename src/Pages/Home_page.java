package Pages;

import org.openqa.selenium.WebDriver;

public class Home_page extends Abstract_page{

	private WebDriver driver;
		
	public Home_page(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Navigate to Article Page
	 * 
	 * Author: Tan Vo
	 */
	public Article_page navigatetoArticlepage(){
		navigateMenu(driver,"Content|Article Manager");		
		return new Article_page(driver);
	}
	
	/*
	 * Navigate to Article Page
	 * 
	 * Author: Tan Vo
	 */
	public Client_page navigatetoCLientpage(){
		navigateMenu(driver,"Components|Banners|Clients");
		return new Client_page(driver);
	}
	
	
}
