package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForJSAlert {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// wait for ALERT:
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();

		// alert api's are available in selenium we can switch in the below way
		// Alert alert = driver.switchTo().alert();// NoAlertPresentException: no such
		// alert

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());// if the alert is present it will automatically
																		// switch to alert
		// return type is 'Alert'
		System.out.println(alert.getText());
		alert.accept();

	}

	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public static String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

	public static void getAlertAccept(int timeOut) {
		 waitForAlert(timeOut).accept();;
	}

	public static void getAlertDismiss(int timeOut) {
		waitForAlert(timeOut).dismiss();;
	}

	public static void enterAlertText(String text,int timeOut) {
		 waitForAlert(timeOut).sendKeys(text);
	}

}
