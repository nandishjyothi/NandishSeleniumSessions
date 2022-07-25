package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageCount {
static WebDriver driver;
	
	// Interview question:
	// To get the count of all the images on the page then print the src/alt attributes of each link on the console
	// avoid blank text

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		List<WebElement> imagesList = driver.findElements(By.tagName("img"));
		
		System.out.println(imagesList.size());
		
		// to get attribute src and alt values:
		for(WebElement e: imagesList) {
			String altValue = e.getAttribute("alt");
			String srcValue = e.getAttribute("src");
			System.out.println(altValue +"---->"+ srcValue);
		}
		
	}

}
