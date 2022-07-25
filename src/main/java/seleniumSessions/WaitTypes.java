package seleniumSessions;

public class WaitTypes {

	public static void main(String[] args) {
		
		/*
		 * The below concept is also called as Synchronization in selenium 
		 * Two types of waits available:
		 * 1. static wait:
		 * 		Sleep(5 Secs) --> Thread.sleep(5000);
		 * 		this is available in java
		 * 		disadvantage of the static wait is that if the element is available with in 2 seconds then remaining time will
		 * 		wasted and the script is stopped there for remaining time
		 * 
		 * 2. dynamic wait
		 * 		wait applied dynamically i.e we have specified 10 seconds but the element is found with in 
		 * 		2 seconds then program will not wait for the remaining 8 seconds (it is ignored)
		 * 
		 * 		There are 2 types of dynamic waits:
		 *  	1. Implicitly wait
		 *  	2. Explicit wait:
		 *  			under explicit wait we 2 types:
		 *  					a. WebDriver wait
		 *  					b. Fluent Wait
		 *  
		 *  Explicit wait is concept we don have any keyword/ method, webDriver wait and fluent wait classes are available 
		 *  
		 *  Hierarchy:
		 *  
		 *   Wait(Interface)<--implemented by---Fluent wait(Class)<---has child class---WebDriverWait(Class)
		 *   
		 *    element takes --> 2 secs, 5 secs, 10 secs
		 *    therefore dynamic wait --> 10 secs(maximum timeout)
		 *    1st time element takes 2 secs --> remaining 8 secs ignored
		 *    1st time element takes 5 secs --> remaining 5 secs ignored
		 *    1st time element takes 10 secs --> remaining 0 secs ignored
		 *    1st time element takes 0 secs --> remaining 10 secs ignored
		 *    1st time element takes 11 secs --> no such element exception 
		 *    
		 *    Synchronization is the sync between the script and application (pages/ elements)
		 *  
		 *  
		 * 		
		 * 
		 */

	}

}
