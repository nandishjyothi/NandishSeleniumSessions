package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImagesUtil {

	static WebDriver driver;

	// Interview question:
	// To get the count of all the images on the page then capture the src/alt
	// attributes of each link on the console in generic way
	// avoid blank text

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		By images = By.tagName("img");
		By links = By.tagName("a");
		System.out.println(getElementsCount(images));
		
		List<String> attrList = getAttributeList(images, "src");
		printElementValues(attrList);
		
		printElementValues(getAttributeList(images, "alt"));
		
		printElementValues(getAttributeList(links, "href"));
		
		

	}

	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	// to print values from the list
	public static void printElementValues(List<String> eleList) {
		for(String e: eleList) {
			System.out.println(e);
		}
	}
	
	public static List<String>  getAttributeList(By locator, String attributeName) {
		List<WebElement> eleList = getElements(locator);
		List<String> attrList = new ArrayList<String>();
		
		for(WebElement e: eleList) {
			String attrValue = e.getAttribute(attributeName);
			attrList.add(attrValue);
		}
		return attrList;
		
		
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
