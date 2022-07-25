package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// drag and drop can be done only with the element to element on the page
		// selenium does not support desktop for drag and drop
		// drag and drop is rare
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement TargetEle = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		// manually we will first 1.click and hold 
		// 2. move to particular element
		// 3. drop the element
		// total 3 actions we have to perform using chaining method
		
		// 1st approach with all the different methods:
		// builder pattern is used 
		// return type of each method is self class (this class)
		act
			.clickAndHold(sourceEle)
				.moveToElement(TargetEle)
					.release()
						.build()
							.perform();
		
		// 2nd approach using direct dragAndDrop method:
		act.dragAndDrop(sourceEle, TargetEle).build().perform();
		
		
		
		
		

	}

}
