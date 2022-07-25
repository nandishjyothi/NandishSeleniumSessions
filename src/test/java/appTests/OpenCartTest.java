package appTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest {

	// how to call the baseTest class here?
	// can use inheritence
	
	// advantage is that we can concentrate only @Test (test cases)
	// beforeTest and AfterTest is executed from BaseTest class
	
	// if run the OpenCartTest it will first go to BaseTest it will check for
	// precondition(@beforeTest,..)
	// after executing the preconditions then will pick the priority/ non priority
	// @tests from OpenCatrTest
	// then after executing the @Tests it will come back to BaseTest and execute
	// PostConditions(@AfterTest,..)

	@Test(priority = 1)
	public void registerLinkTest() {
		//driver.get("https://demo.opencart.com/index.php?route=account/login&language=en-gb");
		boolean flag = driver.findElement(By.linkText("Register")).isDisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void urlTest() {

		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("account/login"));
	}

}
