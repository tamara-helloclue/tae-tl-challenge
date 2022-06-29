package pages;

import org.testng.Assert;
import core.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
public class ProfilePage extends Base {

	public ProfilePage (AppiumDriver <MobileElement> driver) {
	super(driver);
	}

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/username")
	public  MobileElement userName;
	
	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/logout")
	public  MobileElement logoutBtn;

	 public void profilePage() throws InterruptedException
	 {
		 Thread.sleep(1500)
		 userName.isDisplayed();
		 String act = userName.getText();
		 Assert.assertEquals(loginUserContext.getUserName(), act);
		 logoutBtn.click();
	 	
	 	}
}







