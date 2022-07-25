package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPageTest2 {

	public static void main(String[] args) throws InterruptedException {
		// 7th approach String loactor value assignment:

		// FOr launching browser(to access browser related methods) create object for
		// browserUtil class

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome");
		brUtil.enterUrl("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
		String title = brUtil.getPageTitle();
		System.out.println(title);

		String firstName = "input-firstname";
		String lastName = "input-lastname";
		String email = "input-email";
		String password = "input-password";

		// to access element related methods create object for ElementUtil class
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", firstName,"nandish");
		eleUtil.doSendKeys("id", lastName,"Jyothi" );
		eleUtil.doSendKeys("id", email, "test@gmail.com");
		eleUtil.doSendKeys("id", password, "Test@123");

		Thread.sleep(5000);

		brUtil.closeBrowser();

	}

}
