package application.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import application.elements.Button;
import application.elements.CheckBox;
import application.elements.Dialog;
import application.elements.Dropdown;
import application.elements.TextArea;
import application.exceptions.ElementNotFoundException;

public class CustomerViewPage extends AbstractPage{

	private static final By LOCATOR_CUSTOMER_VIEW_PAGE	= By.id("gcrud-search-form");
	private static final By LOCATOR_SELECT_VERSION 		= By.id("switch-version-select");
	private static final By LOCATOR_ADD_CUSTOMER_BUTTON = By.xpath("//div[@class='floatL t5']/a");
	private static final By LOCATOR_DELETE_BUTTON 		= By.xpath("//a[@title='Delete' and @class='btn btn-outline-dark delete-selected-button']");
	private static final By LOCATOR_MODAL_DELETE_MSG	= By.xpath("//div[@class='alert alert-success growl-animated animated bounceInDown']/span[@data-growl='message']");
	private static final By LOCATOR_ALERT_MESSAGE_VALUE	= By.className("alert-delete-multiple-one");
	private static final By LOCATOR_DELETE_RECORD 		= By.className("delete-multiple-confirmation-button");
	private static final By LOCATOR_ACTIONS_CHECKBOX 	= By.className("select-all-none");
	private static final By LOCATOR_SEARCH_NAME 		= By.cssSelector("td:nth-child(3) .form-control.searchable-input.floatL");	
	
	public CustomerViewPage verifyCustomerViewPageDisplayed(){
		
		try {
			LOGGER.info("Verifing Customer View page is done.");
			WebElement customerView = driver.findElement(LOCATOR_CUSTOMER_VIEW_PAGE);
			customerView.isDisplayed();
		} catch (Exception e) {
			ElementNotFoundException elementNotFoundException = new ElementNotFoundException(LOCATOR_CUSTOMER_VIEW_PAGE);
			elementNotFoundException.printStackTrace();
			Assert.assertTrue(false);
		}
		return this;
	}
	
	public CustomerViewPage selectVersion(String value) {
		LOGGER.info("Selecting version: "+value);
		Dropdown version = new Dropdown(LOCATOR_SELECT_VERSION);
		version.selectByTitle(value);
		return this;
	}
	
	public CustomerViewPage clickAddCustomer() {
		LOGGER.info("Selecting Add Customer button.");
		Button addCustomerButton = new Button(LOCATOR_ADD_CUSTOMER_BUTTON);
		addCustomerButton.click();
		return this;
	}
	
	public CustomerViewPage searchByName(String value) {
		LOGGER.info("Filling the serach value.");
		TextArea elementValue = new TextArea(LOCATOR_SEARCH_NAME);
		elementValue.setValue(value);
		elementValue.pressEnter();
		return this;
	}
	
	public CustomerViewPage clickActionsCheckbox() {
		CheckBox actionsCheckBox = new CheckBox(LOCATOR_ACTIONS_CHECKBOX);
		actionsCheckBox.click();
		return this;
	}
	
	public CustomerViewPage clickDeleteButton() {
		LOGGER.info("Deleting records.");
		Button deleteButton = new Button(LOCATOR_DELETE_BUTTON);
		deleteButton.click();
		return this;
	}
	
	public CustomerViewPage checkDeleteAlertMessagePopup(String value) {
		TextArea alertMessageDeleteValue = new TextArea(LOCATOR_ALERT_MESSAGE_VALUE);
		Assert.assertEquals(value, alertMessageDeleteValue.getValue());		
		return this;
	}
	
	public CustomerViewPage clickDeleteRecords() {
		Button deleteRecordsButton = new Button(LOCATOR_DELETE_RECORD);
		deleteRecordsButton.click();
		return this;
	}
	
	public CustomerViewPage checkSucessfullyDeleteRecordsMessage(String value) {
		LOGGER.info("Checking sucessfully delete records.");		
		Dialog modalDelete = new Dialog(LOCATOR_MODAL_DELETE_MSG);
		modalDelete.isDialogDisplayed();
		
		TextArea alertMessageDeleteValue = new TextArea(LOCATOR_MODAL_DELETE_MSG);
		Assert.assertEquals(value, alertMessageDeleteValue.getValue());		
		return this;
	}	
}
