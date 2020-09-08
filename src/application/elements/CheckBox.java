package application.elements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.exceptions.ElementNotFoundException;
import application.pages.AbstractPage;

public class CheckBox extends AbstractPage{

	private By locator;
	
	public CheckBox(By locatorValue){
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
			Thread.sleep(700);
			@SuppressWarnings("deprecation")
			WebDriverWait wait 		= new WebDriverWait(driver, 100);
			WebElement element 	= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			isElementDisplayed = element.isDisplayed();
		} catch (Exception e) {
			ElementNotFoundException elementNotFoundException = new ElementNotFoundException(locator);
			elementNotFoundException.printStackTrace();
			Assert.assertTrue(isElementDisplayed);
		}
		
		return isElementDisplayed;
	}
}
