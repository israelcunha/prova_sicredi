package application.elements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import application.exceptions.ElementNotFoundException;
import application.pages.AbstractPage;

public class Link extends AbstractPage{

	private By locator;
	
	public Link(By locatorValue){
		this.locator = locatorValue;
	}
	
	public void click() {
		if(isElementDisplayed()){
			WebElement element = driver.findElement(locator);
			element.click();
		}
	}
	
	private boolean isElementDisplayed() {
		boolean isElementDisplayed = false;
		try {
			isElementDisplayed = driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			ElementNotFoundException elementNotFoundException = new ElementNotFoundException(locator);
			elementNotFoundException.printStackTrace();
			Assert.assertTrue(isElementDisplayed);
		}
		
		return isElementDisplayed;
	}
}
