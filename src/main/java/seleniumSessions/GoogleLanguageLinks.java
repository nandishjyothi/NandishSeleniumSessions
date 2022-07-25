package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLanguageLinks {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// INTERVIEW QUESTION: To capture the specific language links from the google
		// page
		// function 1 --> click on specific link
		// function 2 --> return list of link text

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");

		// Hard coded way:
//		List<WebElement> langList = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
//		System.out.println(langList.size());
//
//		for (WebElement e : langList) {
//			String text = e.getText();
//			System.out.println(text);
//		}
		
		By langLinks = By.xpath("//div[@id='SIvCob']/a");
		//clickOnElement(langLinks, "ಕನ್ನಡ");
		List<String> actualLinksTextList = getLinksTextList(langLinks);
		if(actualLinksTextList.contains("ಕನ್ನಡ")) {
			System.out.println("ಕನ್ನಡ is present on the page");
		}
		

	}
	
	//generic function to return list of link text
	public static List<String> getLinksTextList(By locator) {
		List<WebElement> langList = driver.findElements(locator);
		List<String> linksTextList = new ArrayList<String>();
		System.out.println(langList.size());

		for (WebElement e : langList) {
			String text = e.getText().trim();
			System.out.println(text);
			linksTextList.add(text);
		}
		return linksTextList;
	}
	
	// generic function to click on specific link:
	public static void clickOnElement(By locator, String linkText) {
		
		List<WebElement> langList = driver.findElements(locator);
		System.out.println(langList.size());

		for (WebElement e : langList) {
			String text = e.getText().trim();
			System.out.println(text);
			if(text.equals(linkText)) {
				e.click();
				break;
			}
		}
		
	}
	
	

}
