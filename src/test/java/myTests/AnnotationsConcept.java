package myTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsConcept {

	/*
	 * Before Suite -- DBCOnnection
	 * Before Test -- createUser
	 * Before class --launchBrowser
	 * 
	 * Before Method -- LoginToApp
	 * Test -- accountInfoTest 
	 * After method -- logout
	 * 
	 * Before Method -- LoginToApp
	 * Test -- userInfoTest 
	 * After method -- logout
	 * 
	 * After class -- close browser 
	 * After Test -- deleteUser
	 * 
	 * After suite -- disconnect DB
	 */
	
	// before method executes before each @test method
	// after method also executes after each @test method
	// before suite, test, class will only be executed once
	// After suite, test, class will only be executed once
	
	// if there are 2 @test which one will be picked up first? 
	// it will be picked up based on the alphabetical order here it is accountInfoTest and then userInfoTest
	// testng will not follow the sequence we have written it will follow its own sequence based on the annotations
	
	//interview question:
	// which one will be executed first before test or before class?
	// first before test will be executed and then before class 
	
	
	

	@BeforeSuite
	public void DBConnection() {
		System.out.println("Before Suite -- DBCOnnection");
	}

	@BeforeTest
	public void createUser() {
		System.out.println("Before Test -- createUser");
	}

	@BeforeClass
	public void launchBrowser() {
		System.out.println("Before class -- launchBrowser");
	}

	@BeforeMethod
	public void loginToApp() {
		System.out.println("Before Method -- LoginToApp");
	}

	// test cases:

	@Test
	public void userInfoTest() {
		System.out.println("Test -- userInfoTest");
	}

	@Test
	public void accountInfoTest() {
		System.out.println("Test -- accountInfoTest");
	}

	@AfterMethod
	public void logout() {
		System.out.println("After method -- logout");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("After class -- close browser");
	}

	@AfterTest
	public void deleteUser() {
		System.out.println("After Test -- deleteUser");
	}

	@AfterSuite
	public void disconnectDB() {
		System.out.println("After suite -- disconnect DB");
	}

}
