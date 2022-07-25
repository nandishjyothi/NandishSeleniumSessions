package seleniumSessions;

import java.net.URL;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverCastings {

	public static void main(String[] args) {
		
		//Different castings available
		
		//1.) WebDriver -- chromeDriver -- local
		//WebDriver driver = new ChromeDriver();// industry standard way of using
		
		//2.) ChromeDriver driver = new ChromeDriver();// local works only for chrome browser
		
		//3.) Remote web driver -- ChromeDriver -- local
//		RemoteWebDriver driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		driver = new SafariDriver();
		
		//4.) WebDriver -- Remote Web Driver -- Remote machine/server/vm/docker/cloud/cloud vendor
		//WebDriver driver = new RemoteWebDriver(new URL("192.45.1.10.4444"), capabilities);
		
		//5.) Search context -- ChromeDriver
		// not a good way because we can access only 2 methods
		//SearchContext driver = new ChromeDriver();
		
		//6.) Search context -- remote web driver:
		// not a good way because we can access only 2 methods
		//SearchContext driver = new RemoteWebDriver(new URL("192.45.1.10.4444"), capabilities);
		
		
		

	}

}
