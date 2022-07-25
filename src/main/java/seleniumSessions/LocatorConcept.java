package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		// first create the webelement and perform actions (click, sendkeys, gettext, isDisplayed, iseneabled)
		
		// There are 8 locators available 
		// Locator 1.) id 
		// 1st approach: in this approach there is no re-usability every time we are writing driver.findElement and hitting server
		// not good way to code
//		driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
//		
//		// 2nd approach: in this approach we are storing the driver.findElement in webElement so that it can be reused 
//		// but this approach is hitting the server every time and keeping the server busy 
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		
//		emailId.sendKeys("test@gmail.com");
//		password.sendKeys("test@123");
//		// after logout: we can again use emaiID for logging in
//		emailId.sendKeys("test1@gmail.com");
//		
//		
//		// 3rd Approach By locator: in this approach the advantage is we are not hitting the server every time 
//		// but hitting the server whenever it is required
//		// to maintain by locator no need to hit the server
//		
//		By username = By.id("input-email");
//		By pass = By.id("input-password");
//		
//		WebElement emailId2 = driver.findElement(username);
//		WebElement pwd = driver.findElement(pass);
//		
//		emailId2.sendKeys("test@gmail.com");
//		pwd.sendKeys("test@123");
//		
		// in the above approach for example there are 100 element then we have to write driver.findelement for 100 times
		// this can be overcome from below approach
		
		// 4th approach By locator with generic method (getElement()):
		// in this approach we are writing driver.findElement only once
//		By username1 = By.id("input-email");
//		By password1 = By.id("input-password");
//		
//		getElement(username1).sendKeys("test@gmail.com");
//		getElement(password1).sendKeys("test@123");
		
		// 5th Approach: By locator with generic method (getElement() with action methods )
		// in this approach we are defining the actions as wrapper method by this we are calling sendkeys method once
		// it is a clean code compared to the above approaches
		
//		By username1 = By.id("input-email");
//		By password1 = By.id("input-password");
//		doSendKeys(username1, "test@gmail.com");
//		doSendKeys(password1, "test@123");
		
		// 6th Approach: ElementUtil class with generic methods this class can be used globally it can be used for any kind of application
//		By username1 = By.id("input-email");
//		By password1 = By.id("input-password");
//		
//		// Creating object for elementUtil class:
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(username1, "test@gmail.com");
//		eleUtil.doSendKeys(password1, "test@123");
		
		// 7th Approach: String locator values: instead of By we are using string to store locator values(id)
		
		String userName2 = "input-email";
		String password2 = "input-password";
		
		doSendKeys("id", userName2,"String@gamil.com");
		doSendKeys("id", password2,"String@123" );
		
		
		
		
		

	}
	
	public static By getBy(String locatorType, String locatorValue){
		By locator = null;
		
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;

		default:
			break;
		}
		return locator;
	}
	
	public static WebElement getElement(By locator) {
		//generic wrapper method 
		return driver.findElement(locator);
	}
	// overloaded getElement method for String locator values
	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
		
		
	}
	
	public static void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	// overloaded doSendKeys method for String locator values
	public static void doSendKeys(String locatorType, String locatorValue,String value) {
		getElement(locatorType, locatorValue).sendKeys(value);
	}

}
