package seleniumSessions;

public class RediffMailTest {

	public static void main(String[] args) {
		// donot extend browserutil class instead create object
				BrowserUtil br = new BrowserUtil();
				
				br.launchBrowser("chrome");
				br.enterUrl("http://www.rediffmail.com");
				String title = br.getPageTitle();
				if(title.contains("Rediff")) {
					System.out.println("Correct title");
				}
				
				String url = br.getAppCurrentUrl();
				System.out.println(url);
				
				br.closeBrowser();

			}

	}


