package application.elements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import application.exceptions.ElementNotFoundException;
import application.pages.AbstractPage;

public class Dialog extends AbstractPage{

	private By locator;
	
	public Dialog(By locatorValue){
		this.locator = locatorValue;
	}
	
	public boolean isDialogDisplayed() {
		boolean isElementDisplayed = false;
		try {
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 20);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			isElementDisplayed = element.isDisplayed();
		} catch (Exception e) {
			ElementNotFoundException elementNotFoundException = new ElementNotFoundException(locator);
			elementNotFoundException.printStackTrace();
			Assert.assertTrue(isElementDisplayed);
		}
		
		return isElementDisplayed;
	}
}
