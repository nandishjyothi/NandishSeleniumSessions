package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {

		// Headless mode:
		// no browser launch(not visible)/ hidden browser
		// testing is happening behind the scene
		// Comparatively faster
		// it is blocking the visibilty of the browser on the system
		// it will execute in browser only but visibility is blocked
		// for headless we have to use below 2 lines
		// ChromeOptions co = new ChromeOptions();
		// co.addArguments("--headless");

		WebDriverManager.chromedriver().setup();

		// for chrome browser
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		WebDriver driver = new ChromeDriver(co);

		/**
		 * For firefox driver: WebdriverManager.firefoxdriver().setup(); FirefoxOptions
		 * fo = new FirefoxOptions(); fo.addArguments("--headless"); WebDriver driver =
		 * new FirefoxDriver(fo);
		 */

		driver.get("http://www.amazon.com");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());

		driver.quit();

		// For running the script in INCOGNITO mode:
		System.out.println();
		System.out.println("Running test scripts in incognito mode");
		WebDriverManager.chromedriver().setup();
		ChromeOptions co1 = new ChromeOptions();
		co1.addArguments("--incognito");
		WebDriver driver1 = new ChromeDriver(co1);
		driver1.get("http://www.amazon.com");
		System.out.println(driver1.getTitle());
		System.out.println(driver1.getCurrentUrl());
		driver1.quit();
	}

}
