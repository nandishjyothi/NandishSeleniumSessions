package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		// to navigate to other URLs we can use navigate method
		driver.navigate().to("https://www.amazon.com");
		System.out.println(driver.getTitle());
		
		// to simulate back and forward in the browser:
		// to come back -- back()
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		// to go forward -- forward()
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		//what is the difference b/w driver.get("url") and driver.navigate().to("some url")?
		// there is no difference b/w these 2 methods they both perform same action
		
		// to refresh the page:
		driver.navigate().refresh();
		
		
		

	}

}
