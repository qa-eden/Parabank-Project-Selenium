package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountOverviewPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class AccountOverviewTest extends BaseClass{
	
	@Test(priority=1,description="TC_Acct_001 - View Accounts Overview")
	public void viewAccountOverview()
	{
		LoginPage lp=new LoginPage(driver);
		lp.Login(p.getProperty("username"), p.getProperty("password"));
		
		HomePage hp=new HomePage(driver);
		hp.clickAccountOverview();
		
		AccountOverviewPage acc=new AccountOverviewPage(driver);
		Assert.assertTrue(acc.accountTableDisplayed(),"Account Table not Displayed");
		Assert.assertTrue(acc.accountNumberDisplayed(), "Account Number not Displayed");
		Assert.assertTrue(acc.accountBalanceDisplayed(),"Account Balance Not Displayed");
	}
	
	@Test(priority=2, description= "TC_Acct_002 - Open a New Checking Account")
	public void createCheckingAccount()
	{
		try
		{
		LoginPage lp=new LoginPage(driver);
		lp.Login(p.getProperty("username"), p.getProperty("password"));
		
		HomePage hp=new HomePage(driver);
		hp.clickOpenAccount();
		
		AccountOverviewPage acc=new AccountOverviewPage(driver);
		acc.selectAccountType(p.getProperty("checking"));
		acc.selectAccountNumber();
		acc.clickOpenAccount();
		
		Assert.assertEquals(acc.validateAccountCreated(),"Account Opened!");
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test(priority=3, description="TC_Acct_003 - Open a New Saving Account")
	public void createSavingsAccount()
	{
		try
		{
		LoginPage lp=new LoginPage(driver);
		lp.Login(p.getProperty("username"), p.getProperty("password"));
		
		HomePage hp=new HomePage(driver);
		hp.clickOpenAccount();
		
		AccountOverviewPage acc=new AccountOverviewPage(driver);
		acc.selectAccountType(p.getProperty("savings"));
		acc.selectAccountNumber();
		acc.clickOpenAccount();
		Thread.sleep(3000);
		Assert.assertEquals(acc.validateAccountCreated(),"Account Opened!");
		} catch(Exception e) {
			Assert.fail();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
