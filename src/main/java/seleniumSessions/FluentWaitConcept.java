package seleniumSessions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		
		//WebDriverWait(C)--> FluentWait(C)--> Wait(I)(until();)
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		
		By emailId = By.id("input-email");
		waitForElementPresentUsingFluentWait(emailId, 10, 2).sendKeys("test@gmail.com");
	

	}
	
	public static WebElement waitForElementPresentUsingFluentWait(By locator, int timeOut,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage("Element is not found...");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
	}
	
	public static WebElement waitForElementUsingWebDriverWait(By locator, int timeOut,int pollingTime) {
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait
		.pollingEvery(Duration.ofSeconds(pollingTime))
		.ignoring(NoSuchElementException.class)// giving .class because noSuchElementException is a class and ignoring method is asking for class and not for reference
		.ignoring(StaleElementReferenceException.class)
		.withMessage("Element is not found...");
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//Both the methods are same 
	// webdriverWait and fluent wait are explicit wait 
	// can use webdriverWait
	
	// interview question: you are not allowed to use any wait but should create your own custom dynamic wait
	
	
	
	
	

}
