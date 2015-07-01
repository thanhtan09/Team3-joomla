package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Abstract_page {

	/*
	 * Enter value to element
	 * 
	 * Parameter: driver, by, value
	 * 
	 * creator: Tan Vo
	 */
	public void enter(WebDriver driver, By by, String _value) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(_value);
	}

	/*
	 * Click on element
	 * 
	 * Parameter: driver, by
	 * 
	 * Creator: Tan Vo
	 */
	public void click(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		element.click();
	}

	/*
	 * Hover on element
	 * 
	 * Parameter: driver, by
	 * 
	 * Creator: Tan Vo
	 */
	public void hover(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
	}

	/*
	 * Select element
	 * 
	 * Parameter: driver, by
	 * 
	 * Creator: Tan Vo
	 */
	public void select(WebDriver driver, By by, String _value) {
		WebElement element = driver.findElement(by);
		element.sendKeys(_value);
	}

	/*
	 * Switch to new frame
	 * 
	 * Parameter: driver, by
	 * 
	 * Author: Tan Vo
	 */
	public void switchFrame(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		driver.switchTo().frame(element);
	}
	
	/*
	 * Get text
	 * 
	 * Parameter: driver, by
	 * 
	 * Author: Tan Vo
	 */
	public String getText(WebDriver driver, By by){
		WebElement element = driver.findElement(by);
		return element.getText();
	}
	
	/*
	 * Count element
	 * 
	 * Parameter: driver, by
	 * 
	 * Author: Tan Vo
	 */
	public int countElement(WebDriver driver, By by){
		int count =0;
		count = driver.findElements(by).size();
		return count;
	}
	
	/*
	 * Sleep
	 * 
	 * Parameter: timeout
	 * 
	 * Author: Tan Vo
	 */
	public void sleep(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Refresh page
	 * 
	 * Parameter: timeout
	 * 
	 * Author: Tan Vo
	 */
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
}
