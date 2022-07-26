package seleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElementConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");

		By username = By.name("username1");
		By password = By.name("password");
		By loginBtn = By.xpath("//input[@type='submit']");

		// Hard coded way
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement userName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(username));// will return
//																									// webElement
//		userName_ele.sendKeys("nandish");

		// TimeoutException: Expected condition failed: waiting for presence of element
		// located by: By.name: username11
		// (tried for 10 second(s) with 500 milliseconds interval)
		// default polling time is 500 milliseconds (in implicitly wait also same 500
		// milliseconds)
		// here selenium server will check every 500 milliseconds for the specified
		// element in browser

		// By webDriverwait approach:

		// doSendKeys(username, "nandish", 10);
//		doPresenceOfElementLocated(username, 10, 2000);
//		driver.findElement(password).sendKeys("test123");
//		driver.findElement(loginBtn).click();

		By footers = By.xpath("//footer//ul[@class ='footer-nav']//a");
//		List<WebElement> footerList = waitForElementsToBeVisible(footers, 5);
//		for(WebElement e: footerList) {
//			System.out.println(e.getText());
//		}

		if (getElementsTextListWithWait(footers, 5).contains("Partners")) {
			System.out.println("PASS");
		}

	}

	public static void doSendKeys(By locator, String value, int timeOut) {
		doPresenceOfElementLocated(locator, timeOut).sendKeys(value);
	}

	/*
	 * presenceOfElementLocated(locator): An expectation for checking that an
	 * element is present on the DOM of a page. This does not necessarily mean that
	 * the element is visible there are chances that the element is present on the
	 * DOM but not visible on the page so we have to use other method
	 */
	// generic function for WebDriverWait
	public static WebElement doPresenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// generic method to give custom interval time/polling time
	public static WebElement doPresenceOfElementLocated(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * visibilityOfElementLocated(locator): An expectation for checking that an
	 * element is present on the DOM of a page and visible.Visibility means that the
	 * element is not only displayed but also has a height and width that is greater
	 * than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	// generic method for webDriverWait with visibilityOfElementLocated method:
	public static WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// generic method to give custom interval time/polling time with
	// visibilityOfElementLocated method:
	public static WebElement waitForElementToBeVisible(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// generic method to handle multiple elements without interval time
	public static List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	//generic method with visibilityOf.webElement method 
	// not recommended 
	public static WebElement waitForElementToBeVisibleWithWebElement(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}

	// generic method to handle multiple elements
	public static List<WebElement> waitForElementsToBeVisible(By locator, int timeOut, long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofMillis(intervalTime));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	// generic method to get text list with wait and without interval time
	public static List<String> getElementsTextListWithWait(By locator, int timeOut) {

		List<WebElement> eleList = waitForElementsToBeVisible(locator, timeOut);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}

}
