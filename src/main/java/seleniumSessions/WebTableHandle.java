package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.freecrm.com/index.html");

		driver.findElement(By.name("username")).sendKeys("TestNJ");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(5000);

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.linkText("CONTACTS")).click();

//		String xpath = "//a[text()='Deepti Gupta']/parent::td/preceding-sibling::td/input";
//		driver.findElement(By.xpath(xpath)).click();
		selectContact("Deepti Gupta");
		selectContact("Harindra Test");
//      can also be written -->//a[text()='Harindra Test']/../preceding-sibling::td/child::input
//		ancestor concept --> //a[text()='Harindra Test']//ancestor::tr
		System.out.println(getCompanyName("Harindra Test"));
		System.out.println(getContactPhoneList("Harindra Test"));
		System.out.println(getContactEmail("Harindra Test"));

	}

	// generic function for this application to select contact:
	public static void selectContact(String contactName) {
		String xpath = "//a[text()='" + contactName + "']/parent::td/preceding-sibling::td/input";
		driver.findElement(By.xpath(xpath)).click();
	}

	// generic function for this application to get company name:
	public static String getCompanyName(String contactName) {
		String xpath = "//a[text()='" + contactName + "']//parent::td//following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(xpath)).getText();
	}

	// generic function for this application to get contact phone list:
	public static List<String> getContactPhoneList(String contactName) {
		String xpath = "//a[text()='" + contactName + "']//parent::td//following-sibling::td/span[@context='phone']";
		List<WebElement> phoneList = driver.findElements(By.xpath(xpath));
		List<String> phoneValList = new ArrayList<String>();
		for(WebElement e: phoneList) {
			String text = e.getText();
			phoneValList.add(text);
		}
		return phoneValList;
	}
	//generic function for this application to get contact email:
	public static String getContactEmail(String contactName) {
		String xpath = "//a[text()='"+contactName+"']//parent::td//following-sibling::td/a[contains(@href,'mailto')]";
		return driver.findElement(By.xpath(xpath)).getText();
	}

}
