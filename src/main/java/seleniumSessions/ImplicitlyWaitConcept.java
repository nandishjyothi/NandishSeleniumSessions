package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		// Implicitly wait:
		// it is a dynamic wait 
		// it is a global wait --> it will be applicable only for all the webElements 
		// can not be applied for non web Elements: alerts, URL, title 
		
		// it can be implemented as shown below
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://classic.crmpro.com/index.html");
		
		// login page: 10 secs
		driver.findElement(By.name("username")).sendKeys("nandish");
		driver.findElement(By.name("password")).sendKeys("nandish123");
		
		//click on login
		
		//home page: 15 sec
		//home page requires 15 seconds then we have to override the wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// so latest implicit wait is 15 seconds
		//ele4
		//ele5
		//ele6
		
		//contacts page: requires only 5 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// latest implicit wait is 5 seconds
		
		//home page: now 5 seconds (latest)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// every time we have to override implicitly wait we have to keep changing the global wait value 
		// Unnecessary wait is applied to all the elements
		// we have to override all the time
		// if we pass 0 seconds then we are doing nullify of implicitly wait
		
		//click on logout
		//login page: again change the value 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		

		
		
		// What is the disadvantage of implicitly wait?
		// 1.the problem is global wait by default it is applied to all the elements
		// 2.every time we have to override implicitly wait we have to keep changing the global wait value 
		// 		Unnecessary wait is applied to all the elements
		// 		we have to override all the time
		// 3. everytime it is hitting api 
		// we should not use implicitly wait

	}

}
