package appTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	
	@Test(priority = 1)
	public void searchTest() {
		//driver.get("https://www.google.com");
		boolean flag = driver.findElement(By.name("q")).isDisplayed();
		// Assert is a class in TestNg
		Assert.assertTrue(flag);
	}

//	@Test(priority = 2)
//	public void googleSearchBtnTest() {
//		boolean flag = driver.findElement(By.name("btnk")).isDisplayed();
//		// Assert is a class in TestNg
//		Assert.assertTrue(flag);
//	}

	@Test(priority = 3)
	public void urlTest() {

		String url = driver.getCurrentUrl();
		// Assert is a class in TestNg
		Assert.assertTrue(url.contains("google"));
	}



}
