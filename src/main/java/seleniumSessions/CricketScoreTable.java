package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketScoreTable {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.espncricinfo.com/series/india-in-england-2022-1276893/england-vs-india-3rd-t20i-1276906/full-scorecard");
		System.out.println(getWicketTakerName("Jos Buttler"));
		System.out.println(getPlayerScoreCard("Dawid Malan"));
		System.out.println(getPlayerBowlingDetails("Harshal Patel"));
		System.out.println(getNumerOfWicketsTaken("Ravi Bishnoi"));
		

	}
	
	public static String getWicketTakerName(String playerName) {
		String xpath = "//a/span/span[text()='"+playerName+"']/ancestor::td/following-sibling::td/span/span";
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static List<String> getPlayerScoreCard(String playerName) {
		String xpath = "//a/span/span[text()='"+playerName+"']/ancestor::td/following-sibling::td";
		List<WebElement>scoreList = driver.findElements(By.xpath(xpath));
		List<String>scoreValList = new ArrayList<String>();
		for(int i=1; i<scoreList.size();i++) {
			String text = scoreList.get(i).getText();
			scoreValList.add(text);
			
		}
		return scoreValList;
		
	}
	//assignment to print bowler stats 
	public static List<String> getPlayerBowlingDetails(String playerName) {
		String xpath = "//a/span[text()='"+playerName+"']/ancestor::td/following-sibling::td";
		List<WebElement>bowlerStats = driver.findElements(By.xpath(xpath));
		List<String>bowlerStatsList = new ArrayList<String>();
		for(int i=1; i<bowlerStats.size();i++) {
			String text = bowlerStats.get(i).getText();
			bowlerStatsList.add(text);
			
		}
		return bowlerStatsList;
	}
	
	//assignment- to get number of wickets:
	public static String getNumerOfWicketsTaken(String playerName) {
		
		String xpath = "//a/span[text()='"+playerName+"']/ancestor::td/following-sibling::td//strong";
		return driver.findElement(By.xpath(xpath)).getText();
		
	}

}
