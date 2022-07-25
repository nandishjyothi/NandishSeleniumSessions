package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrossBrowserTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		//-------------------
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
