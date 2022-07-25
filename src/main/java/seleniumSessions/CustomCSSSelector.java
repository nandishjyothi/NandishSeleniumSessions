package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomCSSSelector {
	
	static WebDriver driver;

	public static void main(String[] args) {

		// CSS selector:
		// it is not an attribute

		// Formula 1:
		// By.cssSelector("");
		// id --> #id
		// we can also write for id with tagName --> htmlTag#id
		// example 1: with id
		By.cssSelector("#input-email");
		// using htmlTag name with id:
		By.cssSelector("input#input-email");

		
		// Formula 2:
		// class --> .class
		// we can also write for class with tagName --> htmlTag.className
		// example 2: with class name
		By.cssSelector(".form-control");
		// using htmlTag name with className:
		By.cssSelector("input.form-control");

		
		// formula 3:
		// #id.className
		// example 3:
		By.cssSelector("#input-email.form-control");
		
		
		// Formula 4:
		// htmlTag#id.className
		// example 4: 
		By.cssSelector("input#input-email.form-control");
		
		// Formula 5:
		// .className#id
		// example 5:
		By.cssSelector(".form-control#input-email");
		
		// Formula 6:
		// htmlTagName.className#id
		// example 6:
		By.cssSelector("input.form-control#input-email");
		
		// whenever we are using id use "#" and while using class use "."
		
		// how to handle when there are multiple classes:
		// Formula 7:
		// .class1.class2.class3.....classN
		// example 7:
		By.cssSelector(".form-control.private-form_control.login-email");
		// we can add html tage also for the above formula
		// htmlTag.class1.class2.class3.....classN
		// example 8:
		By.cssSelector("input.form-control.private-form_control.login-email");
		// we can use id also for the formula
		// htmlTag.class1.class2.class3.....classN#id
		// example 9:
		By.cssSelector("input.form-control.private-form_control.login-email#username");
		
		// Formula 8:
		// htmlTag#id.class1.class2.class3.....classN
		// example 10:
		By.cssSelector("input#username.form-control.private-form_control.login-email");
		
		// what if id and class is not available:
		// Formula 9:
		// htmlTag[attribute = 'Value']
		// input[name = 'Name'] --- CSS
		// //input[@name = 'Name']--- xpath
		// example 11:
		By.cssSelector("input[name='Name']");
		
		// if we want to use multiple attributes:
		// htmlTag[attribute 1 = 'value'][attribute 2 = 'value']....
		// input[name='Name'][text = 'Text'][][]... --- CSS
		// //input[@name='Name' and @text = 'Text'] --- xpath
		// example 12:
		By.cssSelector("input[name='Name'][text = 'Text']");
		
		
		// Contains in css is *
		// Formula 10:
		// htmlTag[attribute* = 'value'] -- contains
		// example 13:
		By.cssSelector("input[id*='Name']");
		
		// Starts with in css is ^
		// Formula 11:
		// htmlTag[attribute ^ = 'value'] -- starts with
		// example 14:
		By.cssSelector("input[placeholder^='E-Mail']");
		
		// Ends with in css is $
		// Formula 12:
		// htmlTag[attribute $ = 'value'] -- ends with
		// example 15:
		By.cssSelector("input[placeholder$ = 'Address']");
		
		
		//Parent to child - forward direction
		// for direct and indirect child in css we have to use space 
		// ex: div.private-form__input-wrapper input --2
		// ex: form#hs-login div --20 matching (direct and indirect div's)
		
		// for direct child we have to use '>'
		// ex: div.private-form__input-wrapper > input -- 2
		// ex: form#hs-login > div --20-- 8 matching (only direct div's)
		
		// child to parent :
		// there is no backward traversing in CSS
		// preceding-sibling is not allowed 
		
		// sibling concept:
		// following-sibling is allowed 
		// not regularly used 
		// we have to use '+' for sibling
		// ex: div.private-form__input-wrapper+div
		// ex: footer>.container>.row>div>.ul.list-unstyled>li+li
		
		
		// Comma in CSS:
		// by using comma multiple elements can be validated 
		// input#username, input#password, button#loginBtn, label#UIFormControl-label-4
		List<WebElement> formFields = driver.findElements(By.cssSelector("input#username, input#password, button#loginBtn, label#UIFormControl-label-4"));
		System.out.println(formFields.size());
		if(formFields.size()==4) {
			System.out.println("all imp fields are present on the page");
		}
		
		
		// indexing concept:
		// In CSS we have nth-of-type concept:
		// collect all the elements and pass the index 
		// ex: div.footer-main ul li:nth-of-type(2)
		// xpath indexing is more flexible 
		
		
		//                          XPath                 |               CSS
		//1. Syntax                 complex               |               simple
        //2. functions              better                |               limited  
		//3. text                   yes -- text()         |               NA  
		//4. backward traversing    yes                   |               NA  
		//5. webTable               better handling       |               limited options  
		//6. performance            good                  |               good  
		//7. multiple ele check     NA                    |               comma feature to handle multiple elements  
		//8. attribute validations  good                  |               better   
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
