package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import core.Base;
import core.LoginUserContext;

public class SignUp extends Base {
	public SignUp(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/signup")
	private MobileElement signUpBtn1;

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/username")
	public MobileElement userNameField;

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/password")
	public MobileElement passwordField;

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/login")
	public MobileElement loginBtn;

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/password2")
	private MobileElement crfPwdField;

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/skillRxJava")
	private MobileElement javaSlider;

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/skillDocker")
	private MobileElement dockerSlider;

	@AndroidFindBy(id = "com.gabrielhuff.sample.login:id/skillKotlin")
	private MobileElement kotlinSlider;

	public void skillsSlider() {
        Thread.sleep(1500)
		action.dragAndDropBy(javaSlider, 200, 1).perform();
		action.dragAndDropBy(dockerSlider, -100, 1).perform();
		action.dragAndDropBy(kotlinSlider, 150, 1).perform();
	}

	public void credentialsSignUp() {
		userNameField.sendKeys("Test" + randomInt());
		passwordField.sendKeys("test123");
		crfPwdField.sendKeys("test123");
		loginUserContext = new LoginUserContext();
		loginUserContext.setUserName(userNameField.getText());
		signUpBtn1.click();
        Thread.sleep(1500)
	}

}
