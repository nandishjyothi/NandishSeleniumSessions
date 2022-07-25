package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.get("https://www.google.com");
		// driver.get("https://classic.crmpro.com/index.html");
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		// driver.get("https://amazon.com");

		// convert driver to javascriptExecutor
//		JavascriptExecutor js = (JavascriptExecutor) driver; 
//		js.executeScript("alert('hi')");

		// how many ways we can get the title ?
		// 1.driver.getTitle
		// 2.using java script executor - document.title

		// 1. to get page title
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		String title = jsUtil.getTitleByJS();
		System.out.println(title);

		// 2.to generate own alert:
		// jsUtil.generateAlert("this is my JS popup");// generally we don use this

		// 3.get the text of the entire page
//		String innerText = jsUtil.getPageInnerText();
//		System.out.println(innerText);
//		System.out.println(innerText.contains("customer service"));

		// 4. for refreshing the page
		// jsUtil.refreshBrowserByJS();

		// 5. drawing border around webElement:
//		WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
		// WebElement loginForm = driver.findElement(By.id("loginForm"));
//		jsUtil.drawBorder(loginForm);
//		// use case if there is any error then we can mark the border 

		// 6. to flash a webElement:
		// WebElement emailId = driver.findElement(By.id("input-email"));
		// WebElement password = driver.findElement(By.id("input-password"));

//		jsUtil.flash(emailId);
//		emailId.sendKeys("test@gmail.com");
//		jsUtil.flash(password);
//		password.sendKeys("test@123");
		// advantage - it gives where exactly the driver is available
		// disAdvantage - performance

		// 7.click element using JS:// not recommended
		// WebElement register = driver.findElement(By.linkText("Register"));
		// jsUtil.clickElementByJS(register);// it is clicking from the DOM so there are
		// chances that the element is not visible on the page
		// interview question:
		// different ways to click
		// 1. WebElement -- click
		// 2. Actions class -- click
		// 3. Actions class -- MoveElement--Click
		// 4. JavaScriptExecutor -- click
		// 5. explicit wait --WE--click

		// 8. scroll Page Down, up, based on height
//		jsUtil.scrollPageDown();
//		Thread.sleep(3000);
//		jsUtil.scrollPageUp();
//		Thread.sleep(3000);
//		jsUtil.scrollPageDown("500");

		// 9. scroll till particular element:
//		WebElement heading = driver.findElement(By.xpath("//span[text() ='Popular products in PC internationally']"));
//		jsUtil.scrollIntoView(heading);
//		System.out.println(heading.getText());

		// 10. sendKeys using JS:
		// it is accessing the value from the DOM so not recommended
		//jsUtil.sendKeysUsingWithId("input-email", "test@gmail.com");

		// Interview Question:
		// how will you get the value of text box?
		WebElement emailId = driver.findElement(By.id("input-email"));
		emailId.sendKeys("test@gmail.com");
		//System.out.println(emailId.getText());// will not give the value test@gmail.com
		String val = emailId.getAttribute("value");
		System.out.println(val);// test@gmail.com

	}

}
