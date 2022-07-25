package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentForFrame {

	public static void main(String[] args) {
		
		// click on search icon in design corporation frame and search for testing 

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://allwebco-templates.com/support/S_script_IFrame.htm");
		

	}

}
