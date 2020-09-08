package tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.pages.AbstractPage;
import application.pages.CustomerAddPage;
import application.pages.CustomerViewPage;

public class DesafioSicrediTest {
	
	@BeforeClass
	public static void startWebDriver(){
		AbstractPage.startWebDriver();
	}
	
	@Before
	public void accessApplicaton(){
		AbstractPage.accessApplication("https://www.grocerycrud.com/demo/bootstrap_theme");
	}
	
	//Test - Challenge 1
	@Test
	public void addCustomerTest() { 
		final CustomerViewPage customerView = new CustomerViewPage();
		final CustomerAddPage customerAdd = new CustomerAddPage();

		customerView.verifyCustomerViewPageDisplayed().selectVersion("Bootstrap V4 Theme").clickAddCustomer();

		customerAdd.verifyCustomerAddPageDisplayed().fillName("Teste Sicredi").fillLastName("Teste")
				.fillContactFirstName("Israel").fillPhone("51 9999-9999").fillAddressLine1("Av Assis Brasil, 3970")
				.fillAddressLine2("Torre D").fillCity("Porto Alegre").fillState("RS").fillPostalCode("91000-000")
				.fillCountry("Brasil").selectFromEmployeer("Fixter").fillCreditLimit("200").clickSave()
				.checkMessage("Your data has been successfully stored into the database");
	}

	// Test - Challenge 2
	@Test
	public void deleteCustomerTest() {

		final CustomerViewPage customerView = new CustomerViewPage();
		final CustomerAddPage customerAdd = new CustomerAddPage();
		
		customerView
			.verifyCustomerViewPageDisplayed().selectVersion("Bootstrap V4 Theme").clickAddCustomer();
		
		customerAdd
			.verifyCustomerAddPageDisplayed().fillName("Teste Sicredi").fillLastName("Teste")
			.fillContactFirstName("Israel").fillPhone("51 9999-9999").fillAddressLine1("Av Assis Brasil, 3970")
			.fillAddressLine2("Torre D").fillCity("Porto Alegre").fillState("RS").fillPostalCode("91000-000")
			.fillCountry("Brasil").selectFromEmployeer("Fixter").fillCreditLimit("200").clickSave()
			.checkMessage("Your data has been successfully stored into the database").clickGoBackToList();
		
		customerView
			.verifyCustomerViewPageDisplayed().searchByName("Teste Sicredi").clickActionsCheckbox()
			.clickDeleteButton().checkDeleteAlertMessagePopup("Are you sure that you want to delete this 1 item?")
			.clickDeleteRecords()
			.checkSucessfullyDeleteRecordsMessage("Your data has been successfully deleted from the database.");
	}
	
	@After
	public void closeBrowser(){
		AbstractPage.closeBrowser();
	}
	
	@AfterClass
	public static void closeWebDriver(){
		AbstractPage.closeWebDriver();
	}
}
