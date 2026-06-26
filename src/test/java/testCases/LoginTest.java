package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import testBase.BaseClass;

public class LoginTest  extends BaseClass{ 
	
	@Test(priority = 1, description = "TC_Auth_001 - Login with Valid Credentials")
	public void loginWithValidCredentials()
	{
		try {
		LoginPage lp=new LoginPage(driver);
		lp.inputUsername(p.getProperty("username"));
		lp.inputPassword(p.getProperty("password"));
		lp.clickLogin();
		Assert.assertTrue(lp.isAccountsOverviewDisplayed(), "Accounts Overview page was not displayed after login");
		lp.clickLogout();
		} catch (Exception e){
			Assert.fail();
		}
	}
	
	@Test(priority=2, description = "TC_Auth_002 - Login with Invalid Password")
	public void loginWithInvalidPassword()
	{
		try {
		LoginPage lp=new LoginPage(driver);
		lp.inputUsername(p.getProperty("username"));
		lp.inputPassword("wrongpassword");
		lp.clickLogin();
		String actual = lp.errorLogin();
		Assert.assertEquals(actual,"Error!");
		} catch (Exception e){
			e.toString();
			Assert.fail();
		}
	}
	
	@Test(priority=3, description="TC_Auth_003 - Login in with Invalid Username")
	public void loginWithInvalidUsername()
	{
		try {
			LoginPage lp=new LoginPage(driver);
			lp.inputUsername("wrongusername");
			lp.inputPassword(p.getProperty("password"));
			lp.clickLogin();
			String actual = lp.errorLogin();
			Assert.assertEquals(actual,"Error!");
			} catch (Exception e){
				e.toString();
				Assert.fail();
			}
	}

	@Test(priority=4, description="TC_Auth_004 - Login in with Empty Field")
	public void loginWithEmptyField()
	{
		try {
			LoginPage lp=new LoginPage(driver);
			lp.inputUsername("");
			lp.inputPassword("");
			lp.clickLogin();
			String actual = lp.errorLogin();
			Assert.assertEquals(actual,"Error!");
			} catch (Exception e){
				e.toString();
				Assert.fail();
			}
	}
}