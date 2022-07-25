package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForNonWebElements {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// wait for URL:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		Thread.sleep(5000);
		driver.findElement(By.linkText("Contact us")).click();

//		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.urlContains("controller=contact"));

		if (waitForURLToContain("controller=contact", 5)) {
			System.out.println("URL is correct");
		}
		
		String title = doGetTitle("Contact us", 5);
		System.out.println(title);

	}

	// generic method to validate URL with contain method
	public static Boolean waitForURLToContain(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlContains(urlFraction));

	}

	// generic method to validate URL with To Be method
	public static Boolean waitForURLToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.urlToBe(url));

	}
	
	//generic method to get title with wait below methods:
	public static String doGetTitleWithFraction(String titleFraction,int timeOut) {
		if(waitForTitleContains(titleFraction, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	//
	public static String doGetTitle(String title,int timeOut) {
		if(waitForTitleToBe(title, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	// contains method
	public static boolean waitForTitleContains(String titleFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleFraction));
	}
	// exact title: title is method
	public static boolean waitForTitleToBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(title));
	}
	
	

}
