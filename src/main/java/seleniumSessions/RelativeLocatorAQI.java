package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorAQI {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement ele = driver.findElement(By.linkText("Hamilton, Canada"));
		
		String aqNum = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(aqNum);//67
		
		String rankNum = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rankNum);//1
		
		String city = driver.findElement(with(By.tagName("a")).below(ele)).getText();// we can use 'p' tag also
		System.out.println(city);
		
		String aboveCity = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(aboveCity);
		
		String nearEle = driver.findElement(with(By.tagName("p")).near(ele)).getText();// gives element within 15 pixels distance
		System.out.println(nearEle);
	}

}
