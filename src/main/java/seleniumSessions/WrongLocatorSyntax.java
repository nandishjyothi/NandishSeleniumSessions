package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WrongLocatorSyntax {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		/**
		 * //*[@id="Form_submitForm_Name"] -- correct xpath
		 * //*[id="Form_submitForm_Name"] -- wrong syntax xpath @ is missing
		 * *[@id="Form_submitForm_Name"] -- wrong syntax xpath // is missing
		 * testing -- wrong syntax xpath there is no proper syntax 
		 * but in selenium 4 there is a bug and it is giving noSuchElementException but it should 
		 * give InvalidSelectorException
		 */
		//By firstName = By.xpath("testing"); exception noSuchElementException
		By lastName = By.cssSelector("Form_submitForm_Contact");// same exception noSuchElementException
		driver.findElement(lastName).sendKeys("nandish");
		
		
		

	}

}
