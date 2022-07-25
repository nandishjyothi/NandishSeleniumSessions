package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	public WebDriver driver;
	
	/**
	 * This method is used to launch the browser on the basis of given browser name
	 * @param browser
	 * @return this will return the driver
	 */
	
	public WebDriver launchBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nikhil JU\\Downloads\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();// the above line is not required we can use webdrivermanager for all the browsers
			// Top casting:
			driver = new ChromeDriver();// launch chrome
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println("launch firefox browser");
		}
		else if(browser.equalsIgnoreCase("safari"))
		{
			System.out.println("launch safari browser");
		}
		else {
			System.out.println("Please pass the right browser..."+browser);
		}
		
		return driver;	
		
		
	}
	/**
	 * This method is used to enter url
	 * @param url
	 * custom method wrapper method created on top of selenium method
	 */
	public void enterUrl(String url) {
		if(url == null) {
			System.out.println("Url is null");
			return; //blank return 
		}
		if(url.indexOf("http")==-1) {
			System.out.println("http is missing in the url");
			return; //blank return 
		}
		driver.get(url);
	}
	/**
	 * 
	 * @return this method will return current page URL
	 */
	public String getAppCurrentUrl() {
		return driver.getCurrentUrl();
		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	public void quitBrowser() {
		driver.quit();
	}

}
