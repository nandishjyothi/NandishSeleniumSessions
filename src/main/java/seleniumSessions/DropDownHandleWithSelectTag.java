package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithSelectTag {
	static WebDriver driver;

	public static void main(String[] args) {
		
		// drop down with html tag --> select
		// these type of drop down can be handled using select class in selenium 
		// this select class will work only when the html tag has <select >
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
		
		// select class constructors requires webElement 
		//Select select = new Select(country);
		//----------------------------------
		//1. To select by index: 
		// use case: for selecting date, month
		//select.selectByIndex(5);
		//---------------------------------------
		
		//2. To select by visible text:
		// use case: when the drop down is dynamic employees 
		// we should give the visible text of the option/drop down
		//select.selectByVisibleText("India");
		//------------------------------------------
		
		//3. To select by value:
		// value is the attribute in the select tag
		// we have to pass the attribute value 
		// in this example visible text and attribute are same 
		// in other application it may be different 
		//select.selectByValue("Cuba");
		
		// to handle multiple drop downs we have to write generic method
		//By locator approach:
		
		By country = By.id("Form_submitForm_Country");
		doDropDownSelectByIndex(country, 10);
		doDropDownSelectByVisibleText(country, "India");
		doDropDownSelectByAttributeValue(country, "Cuba");

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doDropDownSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	public static void doDropDownSelectByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	public static void doDropDownSelectByAttributeValue(By locator, String AttributeValue) {
		Select select = new Select(getElement(locator));
		select.selectByValue(AttributeValue);
	}
	
	// assignment using the above approach select date month and year in facebook page

}
