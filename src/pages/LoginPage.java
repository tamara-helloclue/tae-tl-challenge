package pages;

import org.testng.Assert;

import core.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
public class LoginPage extends Base {


	public LoginPage (AppiumDriver <MobileElement> driver) {
	super(driver);
	}


	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/username")
	public  MobileElement userNameField;

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/password")
	public  MobileElement passwordField;

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/login")
	public  MobileElement loginbtn ;
	
	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/signup")
	public  MobileElement loginSignUpButton ;
	
	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/description")
	public  MobileElement errordesc ;
	
	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/button")
	public  MobileElement errorDesc_okBtn ;

	
	 public void loginPage()
	 	{
            Thread.sleep(1500)
		    userNameField.sendKeys("Test"+ randomInt());
		    passwordField.sendKeys("test123");
		    loginBtn.click();
	    }
	
	 public void loginpageerror() {
         Thread.sleep(1500)
		 errorDesc.isDisplayed();
		 String exp = "Invalid username and / or password";
		 String act = errorDesc.getText();
		 Assert.assertEquals(exp, act);
		 errorDesc_okBtn.click();
		 loginSignUpButton.click(); 
	 }

	
}







