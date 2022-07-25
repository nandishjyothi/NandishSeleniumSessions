package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) {
		
		// frame and iframe both are same
		// frame also has its own DOM
		// driver directly cannot access the frame
		// browser-> page(page elements)-> frame(frame elements)
		// example of overloading in selenium is frame method
		// frame is also a webElement and not any diff browser
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		// 3 methods available to switchTo frame
		//1. frame(index):
		//driver.switchTo().frame(2);
		
		//2. frame(name/id):
		driver.switchTo().frame("main");
		
		//3. frame(webElement):
		//driver.switchTo().frame(driver.findElement(By.name("main")));
		
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		

	}

}
