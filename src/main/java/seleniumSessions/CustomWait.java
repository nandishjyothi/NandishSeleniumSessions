package seleniumSessions;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {
	static WebDriver driver;

	public static void main(String[] args) {
		// interview question: you are not allowed to use any wait but should create
		// your own custom dynamic wait

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");

		By emailId = By.id("input-email11");

		// we should use the below concepts
		// while loop
		// sleep (Static wait) on top of this we have to create dynamic wait

		reTryingElement(emailId, 10).sendKeys("test@gmail.com");

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static WebElement reTryingElement(By locator, int timeOut) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = getElement(locator);
				break;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Element is not found in attempt : " + attempts + ":" + locator);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println("Element is not found exception...tried for : " + timeOut + "with the interval of : "
						+ 500 + "milliseconds");
			}
		}
		return element;

	}

	public static WebElement reTryingElement(By locator, int timeOut, long pollingTime) {
		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {
			try {
				element = getElement(locator);
				break;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				System.out.println("Element is not found in attempt : " + attempts + ":" + locator);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			attempts++;
		}
		if (element == null) {
			try {
				throw new Exception("ELEMENTNOTFOUNDEXCEPTION");
			} catch (Exception e) {
				System.out.println("Element is not found exception...tried for : " + timeOut + "with the interval of : "
						+ pollingTime + "milliseconds");
			}
		}
		return element;

	}

}
