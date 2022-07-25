package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OtherLocators {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//2. driver.get("https://classic.crmpro.com/index.html");
		//3. driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		//4. driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		//driver.get("https://www.orangehrm.com/");
		driver.get("https://www.freshworks.com/");
		
		// 1. id: it is a unique attribute
		// preference- 1st 
//-------------------------------------------------------------------------------------------
		// 2. name: can have duplicate names
		// preference - 2nd 
		
		// driver.findElement(By.name("username")).sendKeys("test@gmail.com");
		
		//by using 6th By locator approach:
//		By emailId = By.name("username");
		ElementUtil elutil = new ElementUtil(driver);
//		elutil.doSendKeys(emailId, "test@gmail.com");
		//--------------------------------------------------------------------------------
		// 3. className:
		// preference - 3
		// className is a attribute, it is not mandatory to be unique
		// we can have same class name for different elements
		// driver.findElement(By.className("form-control")).sendKeys("test");
		
		//-----------------------------------------------------------------------------
		// 4. Xpath:
		// xpath is not an attribute
		// xpath is address of the element inside the HTML Dom
		
		//*[@id="input-email"] --> relative xpath
	//	/html/body/main/div[2]/div/div/div/div[2]/div/div/form/div[1]/input --> absolute 
		
		// absolute xpath --> it starts from the starting node of the html it gives complete address 
		// drawBack --> problem if there are changes in the node then locator will not be located 
		// the chances are high the absolute xpath may change
		
		//relative xpath --> here chances are less of changing the xpath it will change only when the id is changed 
		// we should never use absolute xpath
		
//		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("test@gmail.com");
//		driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div[2]/div/div/form/div[2]/input"))
//				.sendKeys("test@123");
		
		//by using 6th By locator approach:
//		By emailId = By.xpath("//*[@id=\"input-email\"]");
//		elutil.doSendKeys(emailId, "test@gmail.com");
		
		//--------------------------------------------------------------------------------------------------------------

		// 5. cssSelector:
		// it is not an attribute 
		// we have to use attributes to create the css selector
		// driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com");
		
		//-----------------------------------------------------------------------------------------------------------------
		
		// 6. linkText: 
		// only applicable for links, it is not an attribute
		// html tag for links is <a>
		// driver.findElement(By.linkText("Register")).click();
		// using 6th approach:
//		By registerLink = By.linkText("Register");
//		doClick(registerLink);
		
		// using 7th approach: String locator value
//		String register = "Register";
//		elutil.doClick("linktext",register);
		//----------------------------------------------------------------------------------------
		// 7. partialLinkText:
		// partial text of the link
		// works only on link tag
		// this can be used where the text is long text 
		//driver.findElement(By.partialLinkText("Policy")).click();
		//-----------------------------------------------------------------------------------------
		// 8. tagName:
		// tagName is html tagName
//		String header = driver.findElement(By.tagName("h1")).getText();
//		System.out.println(header);
//		if(header.contains("Love your software")) {
//			System.out.println("h1 header is correct");
//		}
		
		// using 6th approach by locator:
		//By header = By.tagName("h1");
		//if(doGetText(header).contains("Love your software")) {
			//System.out.println("h1 header is correct");
		//}
		// using 7th approach string locator value:
		String header = "h1";
		String headrValue = elutil.doGetText("tagname", header);
		if(headrValue.contains("Love your software")) {
		System.out.println("h1 header is correct");
		}
		
		
	
		
		

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static String doGetText(By locator) {
		return getElement(locator).getText();
	}

}
