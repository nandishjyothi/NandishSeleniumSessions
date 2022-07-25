package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickAndSendKeys {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// performing click and sendKeys using action class

		// 1. SendKeys:

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");

		Actions act = new Actions(driver);
		// WebElement firstName = driver.findElement(By.id("input-firstname"));
		// WebElement lastName = driver.findElement(By.id("input-lastname"));

		/*
		 * Equivalent to calling: Actions.click(element).sendKeys(keysToSend). This
		 * method is different from WebElement.sendKeys(CharSequence) - see
		 * sendKeys(CharSequence) for details how.
		 * 
		 * differnce between actions sendkeys and normal webElement.sendKeys is in
		 * actions class we first click on the element and send the value in webelement
		 * we directly send the value
		 */
		// act.sendKeys(firstName, "Tom").build().perform();
		// act.sendKeys(lastName, "Peter").build().perform();

		// act.click(firstName).sendKeys("Tom").build().perform();

		// By locator approach:
		// By firstName = By.id("input-firstname");
		// doActionsSendKeys(firstName, "Tom");
		// doActionsSendKeysOnActiveElement(firstName, "Peter");
		// 3 ways we can enter the values:
		// 1.normal WebElement.sendKeys method
		// 2.Actions class sendkeys
		// 3.making the element active and then sending the value(Actions class click
		// and sendkeys)

		// ********************************************************************************************/
		// 2. Click:
		Thread.sleep(3000);
		By checkBox = By.xpath("//input[@name = 'agree']");
		act.click(getElement(checkBox)).build().perform();
		
		//when to use action class
		//when the element is overlapped by other element 
		//we may get element not intractable exception then use actions class
		// 3 ways for click method also:
		//1. webelement click
		//2. Actions class click
		//3. actions class move to element method and click
		
		//eclipse short cut:
		//1. ctrl+o to see all the methods of that class 
		//2. ctrl+shift+r = to find files

	}

	// generic function for Actions send keys:
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();
	}

	public static void doActionsSendKeysOnActiveElement(By locator, String value) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).sendKeys(value).build().perform();
	}

	/*
	 * 
	 * 
	 * Clicks in the middle of the given element. Equivalent to:
	 * Actions.moveToElement(onElement).click()
	 * 
	 * webElement click may click anywhere on the element 
	 * actions class click clicks on the middle of the element
	 * 
	 */
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}
	public static void doActionsMoveToElementClick(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).click().build().perform();
	}

}
