package myTests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	//depends on method : which method we provide as depends on method then that 
	// method becomes super method and will be executed first
	// here it is loginTest is the super method 
	// if loginTest has priority it will not consider because it is super method and will be executed first
	// if the super method i.e loginTest fails then the dependent methods will be skipped 
	// we can pass more than one method for depends on method
	
	//should we use this feature?
	// Unit Test rule:
	// test cases should be independent 
	// never create any dependency b/w 2 methods
	// by using this feature design will be very complex
	// every test should have its own pre condition, test steps,assertion,status

	
	//complex design shown below:
	@BeforeMethod
	public void launchBrowser() {
		System.out.println("Browser launch");
		int i = 9/0;
		// this method will fail and all the other methods are skipped 
	}
	
	@Test
	public void createUserTest() {
		System.out.println("Create user test");
	}
	
	@Test
	public void loginTest() {
		System.out.println("Login Test");
	}
	
	@Test(dependsOnMethods = {"loginTest","createUserTest"},priority = 1)
	public void homePageTest() {
		System.out.println("Home page Test");
	}
	
	@Test(dependsOnMethods = "loginTest",priority = 2)
	public void searchTest() {
		System.out.println("Search Test");
	}
	
}
