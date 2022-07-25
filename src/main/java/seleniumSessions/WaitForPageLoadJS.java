package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForPageLoadJS {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://api.cogmento.com/register/");
		driver.findElement(By.partialLinkText("Log in here")).click();
		JavaScriptUtil js = new JavaScriptUtil(driver);
		js.waitForPageLoaded();
		driver.findElement(By.name("email")).sendKeys("testing");
		
		// interview question: can you write custom wait for page loading 
		// refer js.waitForPageLoaded(); using document.readyState 

	}

}
