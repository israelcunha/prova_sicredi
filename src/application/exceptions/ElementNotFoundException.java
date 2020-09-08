package application.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

public class ElementNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -5004631855141985837L;

	public ElementNotFoundException(By locatorProgressBarActive){
		super("Element not found: "+ locatorProgressBarActive);
	}

	public ElementNotFoundException(By locator, TimeoutException e) {
		super("Element not found: "+ locator, e);
	}
}
