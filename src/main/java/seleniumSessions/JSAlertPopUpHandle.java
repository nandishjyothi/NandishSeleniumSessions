package seleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSAlertPopUpHandle {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		// alert
		// alert / js pop up is also called modal dialog
		// confirmation pop up
		// warning/ error pop up
		// submission pop up
		// they are javascript alerts 
		// we cannot inspect on the pop up because they are not part of the html DOM / page they are coming because of browser
		// how to validate this?
		

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(5000);// waiting for the pop up to load
		
		// driver is available on the main page and not on the alert
		// so we have to switch the driver from main page to alert pop up and locate the text or click on ok button
		// we cannot have multiple alerts at the same time
		// one by one alert is possible
		// alert returns Alert class
		// if we are clicking on ok button then we are accepting  
		// if we are clicking on cancel button then we are not accepting that is dismissing the alert
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		if(text.contains("Please enter a valid user name")) {
			System.out.println("Correct validation message");
			
		} 
		
		//alert.accept();// click on ok button
		alert.dismiss();// press esc button / click on cancel/ dismiss the alert button

	}

}
