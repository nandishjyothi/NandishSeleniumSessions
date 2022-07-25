package appTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {

	@Test(priority = 1)
	public void contactSalesTest() {
		//driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		boolean flag = driver.findElement(By.linkText("CONTACT SALES")).isDisplayed();
		// Assert is a class in TestNg
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void urlTest() {

		String url = driver.getCurrentUrl();
		// Assert is a class in TestNg
		Assert.assertTrue(url.contains("orangehrm"));
	}

	
}
