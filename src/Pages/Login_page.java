package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_page extends Abstract_page {

	private WebDriver driver;

	public Login_page(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Login with valid account.
	 * 
	 * Parameter: username, password, language .
	 * 
	 * Author: Tan Vo.
	 */
	public Home_page loginValidAccount(String _username, String _pass,
			String _lang) {

		enterUsername(_username);
		enterPassword(_pass);
		if (_lang != "") {
			selectLanguage(_lang);
		}
		clickLogin();

		return new Home_page(driver);
	}

	/*
	 * Enter username
	 * 
	 * Parameter: username
	 * 
	 * Author: Tan Vo
	 */
	public void enterUsername(String _user) {
		enter(driver, By.xpath(Interfaces.LoginPage.TXT_USERNAME), _user);
	}

	/*
	 * Enter password
	 * 
	 * Parameter: password
	 * 
	 * Author: Tan Vo
	 */

	public void enterPassword(String _pass) {
		enter(driver, By.xpath(Interfaces.LoginPage.TXT_PASSWORD), _pass);
	}

	/*
	 * Select language
	 * 
	 * Parameter: language
	 * 
	 * Author: Tan Vo
	 */
	public void selectLanguage(String _lang) {
		select(driver, By.xpath(Interfaces.LoginPage.DROP_LANGUAGE), _lang);
	}

	/*
	 * Click on Login button
	 * 
	 * Author: Tan Vo
	 */
	public void clickLogin() {
		click(driver, By.xpath(Interfaces.LoginPage.BTN_LOGIN));
	}
}
