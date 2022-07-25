package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassicCrmFrameHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://classic.freecrm.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("TestNJ");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
		// what if we want click element in the page and not inside the frame then we cannot interact
		// so driver should come back to page -> defaultcontent() method should be used
		// parentFrame method will not work here because there is no parent frame only main page is available
		driver.switchTo().defaultContent();// coming back to main page
		
		// if there are nested frames we can go into frame 2 directly but if we want to interact with frame 1 the 
		// we can use parentFrame() method as shown below
		//driver.switchTo().parentFrame();// rare case
		
		// if there are 2 parallel frames available
		// the best practice to handle is first switch to frame 1 after interacting come back to main page using defaultContent
		// method and then switch to frame 2  // rare case
		
		

	}

}
