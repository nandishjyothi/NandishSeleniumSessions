package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownValueWithoutSelectClass {
	static WebDriver driver;

	public static void main(String[] args) {
		// Interview question: you are not allowed to use the Select class also to
		// select the value from drop down:

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
//		// hard coded way
//		List<WebElement> countryList = driver.findElements(By.xpath("//select[@id = 'Form_submitForm_Country']/option"));
//		System.out.println(countryList.size());
//		for(WebElement e:countryList) {
//			String text = e.getText();
//				if(text.equals("Cuba")) {
//					e.click();
//					break;
//				}
//		}
		
		By countryOptions = By.xpath("//select[@id = 'Form_submitForm_Country']/option");
		doSelectDropDownValueWithoutSelectClass(countryOptions, "Cuba");

	}
	
	//generic way:
	
	public static void doSelectDropDownValueWithoutSelectClass(By locator, String value) {
		List<WebElement> optionsList = driver.findElements(locator);
		
		System.out.println(optionsList.size());
		
		for(WebElement e:optionsList) {
			String text = e.getText();
				if(text.equals(value)) {
					e.click();
					break;
				}
		}
	}
	

}
