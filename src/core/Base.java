package core;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Base  {
	public AppiumDriver<MobileElement> driver;
	public WebDriver wait;
	public Actions action;	
	public static LoginUserContext loginUserContext;

	
	  public Base (AppiumDriver<MobileElement> driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	        action = new Actions(driver);
	    }

	public void clickElement (MobileElement element){
		element.click();

	}
	public void sendKeysElement (MobileElement element){
		element.sendKeys();
}
	public void isDisplayedElement (MobileElement element){
		element.isDisplayed();
} 
	
	  public int randomInt () {
		 Random rd = new Random();
		 return rd.nextInt(2000);  
	}
	
}

