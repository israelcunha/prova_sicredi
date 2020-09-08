package application.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import application.elements.Button;
import application.elements.Link;
import application.elements.TextArea;
import application.exceptions.ElementNotFoundException;

public class CustomerAddPage extends AbstractPage{

	private static final By LOCATOR_CUSTOMER_ADD_PAGE 	= By.id("crudForm");
	private static final By LOCATOR_CUSTOMER_NAME 		= By.id("field-customerName");
	private static final By LOCATOR_CUSTOMER_LAST_NAME 	= By.id("field-contactLastName");
	private static final By LOCATOR_CONTACT_FIRST_NAME 	= By.id("field-contactFirstName");
	private static final By LOCATOR_PHONE 				= By.id("field-phone");
	private static final By LOCATOR_ADDRESS_LINE_1		= By.id("field-addressLine1");
	private static final By LOCATOR_ADDRESS_LINE_2		= By.id("field-addressLine2");
	private static final By LOCATOR_CITY 				= By.id("field-city");
	private static final By LOCATOR_STATE 				= By.id("field-state");
	private static final By LOCATOR_POSTAL_CODE 		= By.id("field-postalCode");
	private static final By LOCATOR_COUNTRY 			= By.id("field-country");
	private static final By LOCATOR_FROM_EMPLOYEER 		= By.id("field_salesRepEmployeeNumber_chosen");
	private static final By LOCATOR_CREDIT_LIMIT 		= By.id("field-creditLimit");
	private static final By LOCATOR_SAVE_BUTTON 		= By.id("form-button-save");
	private static final By LOCATOR_REPORT_SUCESS 		= By.id("report-success");
	private static final By LOCATOR_GO_BACK_TO_LIST		= By.xpath("//div[@id='report-success']//a[contains(text(),'Go back to list')]");
	private static final By LOCATOR_SEARCH_EMPLOYEER 	= By.xpath("//div[@id='field_salesRepEmployeeNumber_chosen']//input");
	
		
	public CustomerAddPage verifyCustomerAddPageDisplayed(){
		
		try {
			LOGGER.info("Verifing Customer add page is done.");
			WebElement customerView = driver.findElement(LOCATOR_CUSTOMER_ADD_PAGE);
			customerView.isDisplayed();
		} catch (Exception e) {
			ElementNotFoundException elementNotFoundException = new ElementNotFoundException(LOCATOR_CUSTOMER_ADD_PAGE);
			elementNotFoundException.printStackTrace();
			Assert.assertTrue(false);
		}
		return this;
	}
	
	public CustomerAddPage fillName(String value) {
		LOGGER.info("Filling customer name: "+value);
		TextArea element = new TextArea(LOCATOR_CUSTOMER_NAME);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage fillLastName(String value) {
		LOGGER.info("Filling customer last name: "+value);
		TextArea element = new TextArea(LOCATOR_CUSTOMER_LAST_NAME);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage fillContactFirstName(String value) {
		LOGGER.info("Filling contact first name: "+value);
		TextArea element = new TextArea(LOCATOR_CONTACT_FIRST_NAME);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage fillPhone(String value) {
		LOGGER.info("Filling phone: "+value);
		TextArea element = new TextArea(LOCATOR_PHONE);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage fillAddressLine1(String value) {
		LOGGER.info("Filling address line 1: "+value);
		TextArea element = new TextArea(LOCATOR_ADDRESS_LINE_1);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage fillAddressLine2(String value) {
		LOGGER.info("Filling address line 2: "+value);
		TextArea element = new TextArea(LOCATOR_ADDRESS_LINE_2);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage fillCity(String value) {
		LOGGER.info("Filling city: "+value);
		TextArea element = new TextArea(LOCATOR_CITY);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage fillState(String value) {
		LOGGER.info("Filling state: "+value);
		TextArea element = new TextArea(LOCATOR_STATE);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage fillPostalCode(String value) {
		LOGGER.info("Filling postal code: "+value);
		TextArea element = new TextArea(LOCATOR_POSTAL_CODE);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage fillCountry(String value) {
		LOGGER.info("Filling country: "+value);
		TextArea element = new TextArea(LOCATOR_COUNTRY);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage selectFromEmployeer(String value) {
		LOGGER.info("Selecting from employeer: "+value);
		Button element = new Button(LOCATOR_FROM_EMPLOYEER);
		element.click();
		
		TextArea employeerValue = new TextArea(LOCATOR_SEARCH_EMPLOYEER);
		employeerValue.setValue(value);
		employeerValue.pressEnter();
		return this;
	}
	
	public CustomerAddPage fillCreditLimit(String value) {
		LOGGER.info("Filling credit limit: "+value);
		TextArea element = new TextArea(LOCATOR_CREDIT_LIMIT);
		element.setValue(value);
		return this;
	}
	
	public CustomerAddPage clickSave() {
		LOGGER.info("Filling save button.");
		Button saveButton = new Button(LOCATOR_SAVE_BUTTON);
		saveButton.click();
		return this;
	}
	
	public CustomerAddPage checkMessage(String value) {
		LOGGER.info("Checking message: "+value);
		TextArea element = new TextArea(LOCATOR_REPORT_SUCESS);
		String message = element.getValue();
		String successMessage[] = message.split(". Edit");
		Assert.assertEquals(value, successMessage[0]);
		return this;
	}
	
	public CustomerAddPage clickGoBackToList() {
		Link element = new Link(LOCATOR_GO_BACK_TO_LIST);
		element.click();
		return this;
	}		
}
