package application.pages;

import org.openqa.selenium.WebDriver;

import application.util.GeneralConfiguration;
import driver.RunWebDriverTestBase;

public abstract class AbstractPage {
	protected static WebDriver driver;
	public static final org.apache.log4j.Logger LOGGER 	= org.apache.log4j.Logger.getLogger("AbstractPage");

	static {
		org.apache.log4j.PropertyConfigurator.configure(GeneralConfiguration.LOG4J_CONFIG_FILE);
	}
	 
    public AbstractPage() {}
    
    public static void accessApplication(String websiteValue) {
    	LOGGER.info("Before");
    	driver.manage().window().maximize();
    	driver.navigate().to(websiteValue);    	    	
    	
	}
    
    public static WebDriver startWebDriver(){
    	LOGGER.info("Staring Selenium WebDriver.");
    	LOGGER.info("Before class.");
    	return driver = RunWebDriverTestBase.getDriver(); 
    }
    
    public static void closeBrowser(){
    	LOGGER.info("After");
    	LOGGER.info("Closing browser.");
    	driver.close();
    	driver = RunWebDriverTestBase.reset();
    }
    
    public static void closeWebDriver(){
    	LOGGER.info("After class.");
    	LOGGER.info("Quiting Selenium WebDriver.");
    	driver.quit();
    }    
}
