package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		// Open chrome
		// enter url
		// get the title --> validation point (actual vs expected)
		// get the url
		// close the browser
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikhil JU\\Downloads\\chromedriver.exe");
		
		// Top casting:
		WebDriver driver = new ChromeDriver();// launch chrome
		driver.get("https://www.google.com");// launch url
		String title = driver.getTitle();// get the title
		System.out.println("Page title is : "+title);
		
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
