package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// JQuery drop down will not have select tag:

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		Thread.sleep(3000);

		driver.findElement(By.id("justAnInputBox")).click();

		// hard coded way to select choice:
		List<WebElement> choiceList = driver.findElements(By.cssSelector("span.comboTreeItemTitle"));

		for (WebElement e : choiceList) {
			String text = e.getText();
			System.out.println(text);
			// to select specific choice:
			if (text.equals("choice 5")) {
				//e.click();
				break;
			}

		}
		By choices = By.cssSelector("span.comboTreeItemTitle");
		// 1. tc_01: single selection:
		//selectChoice(choices, "choice 2");

		// 2. tc_02: Multi selection:
		// passing String array as parameter
		//selectChoice(choices, "choice 1", "choice 6 2 3", "choice 7");

		// 3. tc_03: select all choices
		selectChoice(choices, "all");//ElementNotInteractableException: element not interactable 
		// because there only 15 choice available out of 45 to interact other choices are hidden so the above exception 

	}

	// another way of passing array is with 3 dots (String... value)
	// for multi selection we have to pass array for the below function
	// if we are passing wrong choice then we have to handle using boolean flag 
	// generic function to select choice:
	public static void selectChoice(By locator, String... value) {

		List<WebElement> choiceList = driver.findElements(locator);
		boolean flag =false;

		if (!value[0].equalsIgnoreCase("all")) {

			for (WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);
				// to select specific choice:
				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						flag = true;
						e.click();
						break;
					}
					
				}

			}
		}
		else {
			// all selection logic:
			try {
				for(WebElement e: choiceList) {
					e.click();
				}
			} catch (ElementNotInteractableException e) {
				System.out.println("all choices are over....");
			}
		}
		if(flag == false) {
			System.out.println("Choice is not available...");
		}

	}

}
