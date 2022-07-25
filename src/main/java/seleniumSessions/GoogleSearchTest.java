package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Interview question: capture the suggestion list from google search text box
		// and click on one of the suggestion

		// when you search in google then we get suggestion below that is called as
		// suggestion list
		// for this google is using AJAX concept which gives AJAX suggestion list
		// without refreshing the whole page
		// all the values are coming form server not from the browser
		// in xpath '/' is direct allies
		// '//' is direct and indirect allies

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");

		driver.findElement(By.name("q")).sendKeys("selenium tutorial");

		Thread.sleep(5000);

		//hard coded way:
//		List<WebElement> suggList = driver
//				.findElements(By.xpath("//ul[@role = 'listbox']/li//div[@class = 'wM6W7d']/span"));
//
//		System.out.println(suggList.size());
//
//		for (WebElement e : suggList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.equals("selenium tutorial youtube")) {
//				e.click();
//				break;
//			}
//		}
		
//		By suggList = By.xpath("//ul[@role = 'listbox']/li//div[@class = 'wM6W7d']/span");
//		getSuggestionList(suggList, "selenium tutorial youtube");
		
		driver.findElement(By.xpath("//ul[@role = 'listbox']/li//div[@class = 'wM6W7d']/span/b[contains(text(),'youtube')]"))
		.click();

	}

	public static void getSuggestionList(By locator, String value) {
		List<WebElement> suggList = driver.findElements(locator);

		System.out.println(suggList.size());

		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}
	
	// genric method for only google page:
	public static void selectOptionFromSuggList(String value) {
		// generic way to write xpath '"+value+"'
		driver.findElement(By.xpath("//ul[@role = 'listbox']/li//div[@class = 'wM6W7d']/span/b[contains(text(),'"+value+"')]"))
		.click();
	}

}
