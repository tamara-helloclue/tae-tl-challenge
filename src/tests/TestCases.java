package clueTestCases;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProfilePage;
import pages.SignUp;
import core.AppiumManager;


public class TestCases extends AppiumManager 
{

    	@Test (priority = 1, description = "Verifying login page for non-existent user & Signup")
    	public void loginPage() throws Exception 
    	{
    		LoginPage lp = new LoginPage (driver);
            lp.loginPage();
            lp.loginpageerror();

    	}
    	
    	@Test (priority = 2, description = "Successful sign up")
    	public void signupPage() throws Exception 
    	{
    		SignUp sp = new SignUp (driver);
            sp.skillsSlider();
            sp.credentialsSignUp();

    	}
    	
       	@Test (priority = 3 , description = "Verifying successful profile screen")
    	public void userProfilePage () throws Exception 
    	{

    		ProfilePage pp = new ProfilePage (driver);
            pp.profilePage();

    	}
    	
    
    	
 
}

