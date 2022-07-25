package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTextUtil {
	static WebDriver driver;

	// Interview question:
	// To get the count of all the links on the page
	// return a list<String> --> this will hold the text of each link


	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		// By locator approach:
		By links = By.tagName("a");
		System.out.println(getElementsCount(links));
		
		List<String> actList = getElementsTextList(links);
		for(String e: actList) {
			System.out.println(e);
		}
		
		// Validation:
		if(getElementsTextList(links).contains("Careers")) {
			System.out.println("Careers link is present");
		}

	}
	
	// for storing the link text in list<String>
	public static List<String> getElementsTextList(By locator){
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String eleText = e.getText();
			if(!eleText.isEmpty()) {
				eleTextList.add(eleText);
			}
		}
		return eleTextList;
	}
	
	
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
