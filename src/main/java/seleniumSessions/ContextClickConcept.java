package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		
		// right click in html is called as context click:
		// scenario: to do right click and capture all the options 
		// these are called user actions (right click, double click, drag and drop, move to specific element etc)
		// this actions can be performed using the 'Actions' class  

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickMe = driver.findElement(By.xpath("//span[text() = 'right click me']"));
		
		// for Actions class we have to pass WebDriver and for select class we have pass webElement
		Actions act = new Actions(driver);
		
		// contextClick method is overloaded default method clicks where the cursor is pointing and the below method clicks 
		// on the specified element 
		// whenever we use actions class we have to use .build() and .perform() methods at the end
		// because with out the 2 methods contextClick or any actions class method will not work
		// single action --> build and perform works
		// single action --> build does not work
		// single action --> perform works
		// multiple actions --> compulsory to use build and perform
		act.contextClick(rightClickMe).build().perform();
		
		// to select/ capture the options in the right click:
		List<WebElement> optList =
				driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-icon')]/span"));
		
		for(WebElement e: optList) {
////			String text = e.getText();
////			System.out.println(text);
////			if(text.equals("Copy")) {
//				e.click();
//				break;
//			}
			e.click();
			driver.switchTo().alert().accept();
			act.contextClick(rightClickMe).build().perform();
			
			
			
		}
		
		// assignment to click on all options and handle the alert pop up:
		
		
		
		
		
		
		

	}

}
