package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.RegisterPage;
import testBase.BaseClass;

public class RegisterTest extends BaseClass {
	@Test(priority=1, description="TC_Auth_005 - Verify User Successful Registration")
	public void successfulUserRegistration()
	{
		RegisterPage Reg = new RegisterPage(driver);
		LoginPage lp= new LoginPage(driver);
		try {
			lp.clickRegister();
			Reg.inputFirstName(p.getProperty("firstName"));
			Reg.inputLastName(p.getProperty("lastName"));
			Reg.inputAddress(p.getProperty("street"));
			Reg.inputCity(p.getProperty("city"));
			Reg.inputState(p.getProperty("state"));
			Reg.inputZip(p.getProperty("zipCode"));
			Reg.inputPhone(p.getProperty("phone"));
			Reg.inputSSN(p.getProperty("ssn"));
			Reg.inputUsername(p.getProperty("regUsername"));
			Reg.inputPassword(p.getProperty("regPassword"));
			Reg.inputConfPassword(p.getProperty("confirmPassword"));
			Reg.clickRegister();
			String Actual=Reg.successRegister();
			Assert.assertEquals(Actual, p.getProperty("successMessage"));
			lp.clickLogout();			
		} catch(Exception e)
		{
			e.getStackTrace();
			Assert.fail();
		}}
	
		@Test(priority=2, description="TC_Auth_006 - Registration with Existing Username")
		public void registrationWithExistingUsername()
		{
			RegisterPage Reg = new RegisterPage(driver);
			LoginPage lp= new LoginPage(driver);
			try {
				lp.clickRegister();
				Reg.inputFirstName(p.getProperty("firstName"));
				Reg.inputLastName(p.getProperty("lastName"));
				Reg.inputAddress(p.getProperty("street"));
				Reg.inputCity(p.getProperty("city"));
				Reg.inputState(p.getProperty("state"));
				Reg.inputZip(p.getProperty("zipCode"));
				Reg.inputPhone(p.getProperty("phone"));
				Reg.inputSSN(p.getProperty("ssn"));
				Reg.inputUsername(p.getProperty("regUsername"));
				Reg.inputPassword(p.getProperty("regPassword"));
				Reg.inputConfPassword(p.getProperty("confirmPassword"));
				Reg.clickRegister();
				String Actual=Reg.usernameError();
				Assert.assertEquals(Actual, p.getProperty("usernameError"));
			} catch(Exception e)
			{
				e.getStackTrace();
				Assert.fail();
			}
		}
		
		@Test(priority=3, description="TC_Auth_007 - Registration with Mismatched Password")
		public void registrationWithMismatchedPassword()
		{
			RegisterPage Reg = new RegisterPage(driver);
			LoginPage lp= new LoginPage(driver);
			try {
				lp.clickRegister();
				Reg.inputFirstName(p.getProperty("firstName"));
				Reg.inputLastName(p.getProperty("lastName"));
				Reg.inputAddress(p.getProperty("street"));
				Reg.inputCity(p.getProperty("city"));
				Reg.inputState(p.getProperty("state"));
				Reg.inputZip(p.getProperty("zipCode"));
				Reg.inputPhone(p.getProperty("phone"));
				Reg.inputSSN(p.getProperty("ssn"));
				Reg.inputUsername(p.getProperty("regUsername"));
				Reg.inputPassword(p.getProperty("regPassword"));
				Reg.inputConfPassword("Wrongpassword");
				Reg.clickRegister();
				String Actual=Reg.passwordError();
				Assert.assertEquals(Actual, p.getProperty("passwordError"));
			} catch(Exception e)
			{
				e.getStackTrace();
				Assert.fail();
			}
		}
		
		@Test(priority=4, description="TC_Auth_008 - Registration with Empty Required Fields")
		public void registrationWithEmptyFields()
		{
			RegisterPage Reg = new RegisterPage(driver);
			LoginPage lp= new LoginPage(driver);
			try {
				lp.clickRegister();
				Reg.inputFirstName("");
				Reg.inputLastName("");
				Reg.inputAddress("");
				Reg.inputCity("");
				Reg.inputState("");
				Reg.inputZip("");
				Reg.inputPhone("");
				Reg.inputSSN("");
				Reg.inputUsername("");
				Reg.inputPassword("");
				Reg.inputConfPassword("");
				Reg.clickRegister();
				String Actual=Reg.passwordError();
				Assert.assertEquals(Actual, p.getProperty("empryfieldError"));
			} catch(Exception e)
			{
				e.getStackTrace();
				Assert.fail();
			}
		}
}
	
