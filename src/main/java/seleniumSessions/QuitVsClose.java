package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {

		// difference between quit and close
		// session id
		// Case 1: driver.close()
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikhil JU\\Downloads\\chromedriver.exe");

		// Top casting:
		WebDriver driver = new ChromeDriver();// launch chrome
		//Session id = ChromeDriver: chrome on WINDOWS (00807caa7592247c86e36bcbd65bec7a)
		
		driver.get("https://www.google.com");// launch url
		//Session id = ChromeDriver: chrome on WINDOWS (00807caa7592247c86e36bcbd65bec7a)
		
		String title = driver.getTitle();// get the title
		//Session id = ChromeDriver: chrome on WINDOWS (00807caa7592247c86e36bcbd65bec7a)
		System.out.println("Page title is : " + title);// Page title is : Google
		
		
		driver.close();
		//Session id = ChromeDriver: chrome on WINDOWS (00807caa7592247c86e36bcbd65bec7a)
		System.out.println(driver.getTitle());// NoSuchSessionException: invalid session id
		// because the session id is expired 
		
		//how to come the issue NoSuchSessionException: invalid session id
		// re-initialize the driver as shown below
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
		
		//Case 2: driver.quit();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title1 = driver.getTitle();
		System.out.println("Page title is : " + title1);
		
		driver.quit();
		
		System.out.println(driver.getTitle());// NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
		
	}

}
