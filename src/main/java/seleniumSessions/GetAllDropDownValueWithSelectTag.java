package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllDropDownValueWithSelectTag {

	static WebDriver driver;

	public static void main(String[] args) {
		// INTERVIEW QUESTION: get all drop down values with select tag

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		// what we should pass for select class --> we should pass webElement
		// select class is coming from which package ? -->
		// org.openqa.selenium.support.ui.Select;

		Select select = new Select(country);
		// to get all the values from drop down we should use the getOptions method
		// list is interface
		List<WebElement> countryList = select.getOptions();

		System.out.println("Drop down size: " + countryList.size());
		if (countryList.size() - 1 == 231) {
			System.out.println("Country count is correct");
		}

		// to print all the values of the drop down:
		// with index
		// how to avoid first element in list for each loop
		int i = 0;
		for (WebElement e : countryList) {
			String text = e.getText();
			if (!text.equals("- Select Country -")) {
				System.out.println(i + "::" + text);
			}

			i++;
		}
		
		System.out.println("-----------------------Generic way---------------------------");
		
		By country1 = By.id("Form_submitForm_Country");
		doGetValuesFromDropDown(country1);
		

	}

	// generic function for getOptions:
	public static void doGetValuesFromDropDown(By locator) {
		Select select = new Select(getElement(locator));

		List<WebElement> dropDownList = select.getOptions();
		// drop down values with index
		int i = 0;
		for (WebElement e : dropDownList) {
			String text = e.getText();
			if (!text.equals("- Select Country -")) {
				System.out.println(i + "::" + text);
			}

			i++;
		}

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
