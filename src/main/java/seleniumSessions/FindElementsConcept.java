package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {
	
	static WebDriver driver;
	
	// Interview question:
	// To get the count of all the links on the page then print the text of each link on the console
	// avoid blank text

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		// find elements is for multiple webElements 
		// we don need to perform actions because we are having multiple elements, we cannot click 100 elements together 
		// find elements returns list of webElements 
		// it is returning list because in future it may increase, so list is returned as it is dynamic 
		// list is order based 
		
		//List<WebElement> linksList = driver.findElements(By.tagName("a"));
		
		//By locator approach:
		By links = By.tagName("a");
		List<WebElement> linksList = getElements(links);
		
		
		System.out.println("Total links: "+linksList.size());
		
		for(int i=0; i<linksList.size();i++) {
			String text = linksList.get(i).getText();
			
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
		
		// for each loop:
		for(WebElement e:linksList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				System.out.println(text);
			}
		}
		
		
		

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
