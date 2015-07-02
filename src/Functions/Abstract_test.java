package Functions;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class Abstract_test {

	protected final Log log;
	protected WebDriver driver;

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
	protected WebDriver openJoomla(String _url) {
		driver = new FirefoxDriver();
		driver.get(_url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;
	}

	/*
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

	protected void verifyTrue(boolean condition) {
		try {
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			VerifyFailures.getFailures().addFailureForTest(
					Reporter.getCurrentTestResult(), e);
		}
	}
}
