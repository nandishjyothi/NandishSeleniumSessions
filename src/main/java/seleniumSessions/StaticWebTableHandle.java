package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableHandle {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// table[@id='customers'] -- gives 5 results-- better way to use this approach
		// *[@id = 'customers']-- gives 100 results

		// in the web table we will be able to see the below pattern i.e rows are
		// changing and column is constant
		// table[@id='customers']/tbody/tr[2]/td[1]
		// table[@id='customers']/tbody/tr[3]/td[1]
		// table[@id='customers']/tbody/tr[4]/td[1]
		// table[@id='customers']/tbody/tr[5]/td[1]
		// table[@id='customers']/tbody/tr[6]/td[1]
		// table[@id='customers']/tbody/tr[7]/td[1]

		// so we can create expression for the above pattern
		String beforeXpath_comp = "//table[@id='customers']/tbody/tr[";
		String afterXpath_comp = "]/td[1]";

		int rowCount = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();

		// for getting the first column values
		for (int i = 2; i <= rowCount; i++) {
			String compXpath = beforeXpath_comp + i + afterXpath_comp;
			System.out.println("Final Xpath generated: " + compXpath);
			String compName = driver.findElement(By.xpath(compXpath)).getText();
			System.out.println("Company Name: " + compName);
			System.out.println();
		}
		
		// here the same pattern but for the second column:
		// table[@id='customers']/tbody/tr[2]/td[2]
		// table[@id='customers']/tbody/tr[3]/td[2]
		// table[@id='customers']/tbody/tr[4]/td[2]
		System.out.println("-----------------------------------------------");
		System.out.println(" ");
		By row = By.xpath("//table[@id='customers']/tbody/tr");
		By col = By.xpath("//table[@id='customers']/tbody/tr[1]/th");
		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[";
		printTable(row, col, beforeXpath, afterXpath);
		


	}
	
	//Generic way to iterate/ handle static webTable:
	public static void printTable(By rowLocator, By colLocator, String beforeXpath, String afterXpath) {
		int rowCount = driver.findElements(rowLocator).size();
		int colCount = driver.findElements(colLocator).size();
		for(int row=2; row<=rowCount; row++) {
			for(int col=1; col<=colCount; col++) {
				String xpath = beforeXpath+row+afterXpath+col+"]";
				String text = driver.findElement(By.xpath(xpath)).getText();
				System.out.print(text+" || ");
			}
			System.out.println();
		}
	}

}
