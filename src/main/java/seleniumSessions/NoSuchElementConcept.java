package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoSuchElementConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//driver.findElement method:
//		WebElement firstName = driver.findElement(By.id("Form_submitForm_Name11"));//NoSuchElementException: no such element: Unable to locate element:
//		firstName.sendKeys("nandish");
		// find element is internally using find elements only it gives exception when value is less than zero
		
		//driver.findElements method:
		List<WebElement> list = driver.findElements(By.className("text11"));
		// no exception will be thrown here if element is not found or locator is wrong
		// it will return an empty list
		System.out.println(list.size());// 0 will be printed and not noSuchElementException
		
		

	}
	

}
