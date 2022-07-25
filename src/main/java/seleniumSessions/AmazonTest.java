package seleniumSessions;

public class AmazonTest {

	public static void main(String[] args) {
		
		// donot extend browserutil class instead create object
		BrowserUtil br = new BrowserUtil();
		
		br.launchBrowser("chrome");
		br.enterUrl("http://www.amazon.com");
		String title = br.getPageTitle();
		if(title.contains("Amazon")) {
			System.out.println("Correct title");
		}
		
		String url = br.getAppCurrentUrl();
		System.out.println(url);
		
		br.closeBrowser();

	}

}
