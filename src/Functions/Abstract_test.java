package Functions;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Databases.*;

public abstract class Abstract_test {

	protected final Log log;
	protected WebDriver driver;
	
	//Data
	protected ReadData data = new ReadData();
	protected String url;
	protected User user;
	protected Article article,article2,article3,article4,article5,article6,article7;
	protected Client client;
	protected Category category;
	protected Banner banner,banner2;

	protected Abstract_test() {
		log = LogFactory.getLog(getClass());
	}

	/*
	 * Open Joomla page
	 * 
	 * Parameter: url
	 * 
	 * Author: Tan Vo
	 */
	protected WebDriver openJoomla() {
		
		//Get data
		getData();
		
		//Start Joomla
		driver = new FirefoxDriver();
		url = data.getUrl("Local_url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	/*.
	 * Close browser
	 * 
	 * Author: Tan Vo
	 */
	protected void shutdown() {
		driver.close();
		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (Exception e) {
		}
	}

	/*.
	 * Verify True
	 * 
	 * Author: Tan Vo
	 */
	protected void verifyTrue(boolean condition) {
		try {
			Assert.assertTrue(condition);
		} catch (Exception e) {
			log.info("FAIL: "+e);
		}
	}
	
	protected void verifyFalse(boolean condition) {
		try {
			Assert.assertFalse(condition);
		} catch (Exception e) {
			log.info("FAIL: "+e);
		}
	}
	
	/*.
	 * Get data
	 * 
	 * Author: Tan Vo
	 */
	public void getData(){
		user = data.getUser("Tan");
		article = data.getArticle("Article1");
		article2 = data.getArticle("Article2");
		article3 = data.getArticle("Article3");
		article4 = data.getArticle("Article4");
		article5 = data.getArticle("Article5");
		article6 = data.getArticle("Article6");
		article7 = data.getArticle("Article7");
		client = data.getClient("Client1");
		category = data.getCategory("Cate1");
		banner = data.getBanner("Banner1");
		banner2 = data.getBanner("Banner2");
	}
}
