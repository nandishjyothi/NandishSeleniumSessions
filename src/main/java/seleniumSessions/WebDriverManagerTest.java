package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();// for chrome
		//WebDriverManager.firefoxdriver().setup();// for firefox 

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikhil JU\\Downloads\\chromedriver.exe");// no need to write this as we are using webDriverManager 

		// Top casting:
		WebDriver driver = new ChromeDriver();// launch chrome
		driver.get("https://www.google.com");// launch url
		String title = driver.getTitle();// get the title
		System.out.println("Page title is : " + title);
		
		//Validation point/checkpoint: (Actual vs Excepted)
		if(title.equals("Google"))
		{
			System.out.println("PASS - Correct title");
		}
		else
		{
			System.out.println("FAIL - incorrect title");
		}
		
		//Automation steps + validation point ===> automation testing 
		
		String url = driver.getCurrentUrl();// get url
		System.out.println("URL: "+url);
		
		driver.quit();// close browser
		//driver.close();//

	}

}
