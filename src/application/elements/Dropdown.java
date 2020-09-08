package application.elements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import application.exceptions.ElementNotFoundException;
import application.pages.AbstractPage;

public class Dropdown extends AbstractPage{

	private By locator;
	
	public Dropdown(By locatorValue){
		this.locator = locatorValue;
	}
	
	public void selectByTitle(String value) {
		if(isElementDisplayed()){
			WebElement elementSelect = driver.findElement(locator);
			Select element = new Select(elementSelect);
			element.selectByVisibleText(value);
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
