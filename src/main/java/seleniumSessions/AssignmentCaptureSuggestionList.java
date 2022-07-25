package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentCaptureSuggestionList {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// Interview question: capture the suggestion list from automationpractice.com
		// search for dress--> casual dresses --> validate the title in that page
		// and click on one of the suggestion

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

		driver.findElement(By.id("search_query_top")).sendKeys("dress");

		Thread.sleep(7000);
		
//		By suggList = By.xpath("//div[@class = 'ac_results']/ul/li");
//		getSuggestionList(suggList, "Casual Dresses > Printed Dress");
		
		By suggList = By.xpath("//div[@class='ac_results']//li[contains(text(),'Casual Dresses > Printed Dress')]");
		
		//one more way is directly clicking on the element instead of iterating over the list
		//driver.findElement(By.xpath("//div[@class='ac_results']/ul/li[contains(text(),'Casual Dresses > Printed Dress')]"))
			//.click();
		driver.findElement(suggList).click();
		
		String text = driver.findElement(By.xpath("//h1")).getText();
		if(text.equals("Printed Dress")) {
			System.out.println("Navigated to correct page: "+text);
		}

	}
	
	public static void getSuggestionList(By locator, String value) {
		List<WebElement> suggList = driver.findElements(locator);

		System.out.println(suggList.size());

		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(value)) {
				e.click();
				break;
			}
		}

	}

}
