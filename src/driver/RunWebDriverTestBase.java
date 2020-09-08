package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

public abstract class RunWebDriverTestBase {
	protected static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null){
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		return driver;
	}
	
	public static WebDriver reset() {
		driver = null;
		return getDriver();
	}
}
