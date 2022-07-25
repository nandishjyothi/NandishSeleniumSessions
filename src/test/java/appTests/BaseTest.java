package appTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	// since orangeHRMTest, GoogleTest, OpenCartTest class having same code for before
	// Test and After Test methods(precondition and postconditions ) but only different url
	// so we are creating baseTest Class in the base class we are moving the precondition and postconditions 
	// baseTest will be the super test class of all the test classes 
	// how this will work?
	// if run the OpenCartTest it will first go to BaseTest  it will check for precondition(@beforeTest,..)
	// after executing the preconditions then will pick the priority/ non priority @tests form OpenCatrTest
	// then after executing the @Tests it will come back to BaseTest and execute PostConditions(@AfterTest,..)
	
	// If we want to execute only one particular test then double click on that @test method right click -> run as -> testng 
	
	
	// problem here is we have to run each Test class separately  everyTime
	// to overcome this problem we bundle all the test classes by using testNG.xml file 
	
	// for all the non java files like xml, json,properties,xlsx , we should create new 
	// source folder --> right click on project--> new -> source folder ->src/test/resources
	
	// what is the difference b/w package and folder 
	// package should be created for java classes 
	// folder should be created for normal files 
	
	
	/*
	 * In the testng.xml file
	 * <test></test> --> test block we can have more than one file 
	 * and can also define different test blocks 
	 * 
	 * xml file behaves like runner class 
	 * it will run based on the given order in the xml file 
	 * once you run the xml file right click on project and refresh the project
	 * test-output folder will be created --> index.html file --> open in chrome 
	 * 
	 * 
	 */
	
	
	
	
	
	
	WebDriver driver;

	@Parameters({"url","browser"})
	@BeforeTest
	public void setup(String url, String browser) {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("please pass correct browser:");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
