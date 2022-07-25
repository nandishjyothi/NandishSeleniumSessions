package myTests;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {

	String name = "Tom";
	
	@Test(expectedExceptions = {ArithmeticException.class,NullPointerException.class})
	public void loginTest() {
		System.out.println("login");
		int a =9/0;
		ExpectedExceptionConcept obj = new ExpectedExceptionConcept();
		obj = null;
		System.out.println(obj.name);
		
		// if we have defined expectedException and there is no exception then the test will be failed 
		// if we handle the exception using try catch then the method will not throw any exception and the test will be failed
	}
	
	
	
	
	
}
