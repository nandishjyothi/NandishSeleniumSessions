package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyElement {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		//to verify For multiple elements:
		By formFields = By.className("text11");
		int fieldCount = driver.findElements(formFields).size();
		if(fieldCount == 0) {
			System.out.println("Form fields are not available");
		}
		else {
			System.out.println("Form fields are available");
		}
		
		// to verify for the single element:
		//By contactSalesLink = By.linkText("Contact Sales");// gives noSuchElementException because in the UI it capital "CONTACT SALES" 
		//under dom <a> tag it is "Contact Sales" 
		//it is only applicable to link text and partial link text
		By contactSalesLink = By.linkText("CONTACT SALES11");
		//driver.findElement(contactSalesLink).click();
		
		// to verify single element:
		// 2 methods can be used 
		// 1. by using isDisplayed method
		// 2. by using findElements method dot size >=1 as shown below
		
		if(driver.findElements(contactSalesLink).size()>=1){
			System.out.println("contact sales link is present on the page");
			
		}
		
		System.out.println(isElementExist(contactSalesLink));

	}
	
	public static boolean isElementExist(By locator) {
		int elementCount = driver.findElements(locator).size();
		System.out.println("Total elements found: "+elementCount);
		if(elementCount >= 1) {
			System.out.println("Element is found : "+locator);
			return true;
		}
		else {
			System.out.println("Element is Not found : "+locator);
			return false;
		}
	}

}
