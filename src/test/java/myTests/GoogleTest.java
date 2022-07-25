package myTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	
	/*
	 * INTERVIEW QUESTION:
	 * which is a better approach @beforeTest or @beforeMethod?
	 * 
	 * @BeforeTest and @BeforeMethod are having setup code 
	 * 
	 * it depends on the number of test cases for example we have 30 to 40 test cases 
	 * and we have to validate on the same page then we can use @BeforeTest annotation 
	 * 
	 * if there are 100 test cases then @BeforeMethod is the best approach because
	 * the test coverage will be more and if we are using @BeforeTest annotation it will
	 * execute all the test cases in the same browser, in case if any crash happens at the 4th 
	 * test case then the test coverage is just 4/100 only 4% 
	 * if we are using @BeforeMethod then for each test case a new browser is opened and script is executed
	 * if there is a crash then only the 4th test will be failed and remaining test cases are executed
	 * that becomes 99/100 test cases are covered i.e 99%
	 * 
	 * one disadvantage of @BeforeMethod is it takes time to open and close the browser 
	 * 
	 */
	//Can we use beforeTest and BeforeMethod together?
	// yes we can use 

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://google.com");
	}

	@Test
	public void searchTest() {
		boolean flag = driver.findElement(By.name("q")).isDisplayed();
		// Assert is a class in TestNg
		Assert.assertTrue(flag);
	}

	@Test
	public void googleSearchBtnTest() {
		boolean flag = driver.findElement(By.name("btnk")).isDisplayed();
		// Assert is a class in TestNg
		Assert.assertTrue(flag);
	}

	@Test
	public void urlTest() {

		String url = driver.getCurrentUrl();
		// Assert is a class in TestNg
		Assert.assertTrue(url.contains("google"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
