package myTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

//	@BeforeSuite
//	public void DBConnection() {
//		System.out.println("Before Suite -- DBCOnnection");
//	}
	// only above method is there in the class
	// when we right click we don have run as testNG option why?
	// because pre conditions and post conditions are not test cases only @test is
	// the test case
	// once @test is added we will get the option to run as testNg
	// compulsory to have '@Test' annotation to run the script
	
	//in the below code browser opens only once as before test runs only once 

	WebDriver driver;

	@BeforeTest
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

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
