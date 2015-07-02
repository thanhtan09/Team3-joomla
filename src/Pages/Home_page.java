package Pages;

import org.openqa.selenium.By;
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
		navigateMenu("Content|Article Manager");		
		return new Article_page(driver);
	}
	
	/*
	 * Navigate menu
	 * 
	 * Parameter: menu (e.g: Content|Article Manager)
	 * 
	 * Author: Tan Vo
	 */
	public void navigateMenu(String list){
		String menu = list;
		String lastItem = "";
		String[] subMenu = menu.split("[|]");
		
		for (String r: subMenu){
			hover(driver, By.xpath("//ul[@id='menu']/descendant::a[contains(text(),'"+r+"')]"));
			lastItem = r;
		}
		click(driver, By.xpath("//ul[@id='menu']/descendant::a[contains(text(),'"+lastItem+"')]"));
	}
}
