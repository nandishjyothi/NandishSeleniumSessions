package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownWithoutUsingSelectMethods {

	static WebDriver driver;

	public static void main(String[] args) {
		// INTERVIEW QUESTION: Select drop down without using select methods (i.e
		// getByvalue, getByVisibleText, getByIndex)

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		// hard coded way:
//		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
//
//		Select select = new Select(country);
//		List<WebElement> countryList = select.getOptions();
//
//		for (WebElement e : countryList) {
//			String text = e.getText();
//			System.out.println(text);
//			if (text.equals("India")) {
//				e.click();
//				break;
//			}
//		}
		
		By country = By.id("Form_submitForm_Country");
		doSelectDropDownValue(country, "India");

	}

	// Interview question: how will you handle for the drop downs? above code is
	// hard coded
	// below is the generic way:
	// should we use this method to select value from drop down?
	// if we have the required value at 200th position then it will be iterating till 200th position/index to get the value
	// so this will take time it is important for interview point 
	public static void doSelectDropDownValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	
	

}
