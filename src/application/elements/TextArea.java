package application.elements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.exceptions.ElementNotFoundException;
import application.pages.AbstractPage;

public class TextArea extends AbstractPage{

	private By locator;
	
	public TextArea(By locatorValue){
		this.locator = locatorValue;
	}
	
	public void clear() {
		if(isElementDisplayed()){
			WebElement element = driver.findElement(locator);
			element.clear();
		}
	}
	
	public void setValue(String value) {
			WebElement element = driver.findElement(locator);
			element.sendKeys(value);
	}
	
	public String getValue() {
		String value = "";
		if(isElementDisplayed()){
			WebElement element = driver.findElement(locator);
			value = element.getText();
		}
		
		return value;
	}
	
	private boolean isElementDisplayed(){
		boolean isElementDisplayed = false;
		try {
			@SuppressWarnings("deprecation")
			WebDriverWait wait 		= new WebDriverWait(driver, 30);
			WebElement element 	= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			isElementDisplayed = element.isDisplayed();
			
		} catch (Exception e) {
			ElementNotFoundException elementNotFoundException = new ElementNotFoundException(locator);
			elementNotFoundException.printStackTrace();
			Assert.assertTrue(isElementDisplayed);
		}
		
		return isElementDisplayed;
	}
	
	public void pressEnter() {
		if(isElementDisplayed()){
			WebElement element = driver.findElement(locator);
			element.sendKeys(Keys.ENTER);
		}
	}		
}
