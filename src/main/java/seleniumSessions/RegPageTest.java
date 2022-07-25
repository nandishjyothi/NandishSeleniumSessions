package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest {

	public static void main(String[] args) throws InterruptedException {
		// 6th approach By locator 
		// FOr launching browser(to access browser related methods) create object for browserUtil class
		
		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.enterUrl("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		String title = brUtil.getPageTitle();
		System.out.println(title);
		
		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		
		// to access element related methods create object for ElementUtil class
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Sharmin");
		eleUtil.doSendKeys(lastName, "Hoque");
		eleUtil.doSendKeys(email, "Sharmin@gmail.com");
		eleUtil.doSendKeys(password, "TestBy@123");
		
		Thread.sleep(5000);
		
		brUtil.closeBrowser();

	}

}
