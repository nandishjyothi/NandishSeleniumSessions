package seleniumSessions;

public class ExplicitWaitConcept {

	public static void main(String[] args) {
		
		//ExplicitWait: it is high level wait
		// it is a concept
		// it is dynamic 
		// not a global wait
		// it can be applied for a specific element
		// it can be customized for a specific element as per the use case 
		// it can be applied for all non web elements : alert, url, title
		
		//WebDriverWait(class) --extends--> FluentWait(class) --implements-->Wait(interface)(only until method is there in Interface)
		
		//FluentWait(C) --implements-->Wait(I)--has until method
		//FluentWait class has
		// 1.until - overridden
		// 2.individual methods : ignoring(), withMessage(), pollingEvery()
		
		//WebDriverWait(class) --extends--> FluentWait(class)
		// only timeoutException method -> protected
		// 1.until() -- inherited 
		// 2.inherited methods: ignoring(), withMessage(), pollingEvery()
		
		//for each and every element we can apply wait 
		// seeing the gitcode of selenium both webDriver wait and fluent wait are same	

	}

}
