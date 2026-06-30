package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	@FindBy(xpath="//img[@title='ParaBank']") WebElement logoDisplay;
	@FindBy(xpath="//input[@name='username']") WebElement txtUsername;
	@FindBy(xpath="//input[@name='password']") WebElement txtPassword;
	@FindBy(xpath="//input[@value='Log In']") WebElement btnLogin;
	@FindBy(xpath="//a[normalize-space()='Forgot login info?']") WebElement btnForgotLogin;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement btnRegister;
	@FindBy(xpath="//a[normalize-space()='Log Out']") WebElement btnLogout;
	@FindBy(xpath="//h1[normalize-space()='Accounts Overview']") WebElement headingAccountsOverview;
	@FindBy(xpath="//p[@class='error']") WebElement errorMsg;
	@FindBy(xpath="//h1[normalize-space()='Error!']") WebElement loginError;
		
	// Actions
	//1. Validate Login Page
	public Boolean logoDisplay()
	{
		try
		{
			return(logoDisplay.isDisplayed());
		} catch(Exception e)
		{
			return false;
		}
	}
	
	//2. Login Action
	
	public void Login(String username, String password)
	{
		txtUsername.sendKeys(username);
		txtPassword.sendKeys(password);
		btnLogin.click();	
	}
	
	
	public void inputUsername(String value)
	{
		txtUsername.sendKeys(value);
	}
	
	public void inputPassword(String value)
	{
		txtPassword.sendKeys(value);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
	
	public void clickRegister()
	{
		btnRegister.click();
	}
	
	public Boolean isAccountsOverviewDisplayed()
	{
		try
		{
			return(headingAccountsOverview.isDisplayed());
		} catch(Exception e)
		{
			return false;
		}
	}
	
	public String validateErrorMsg()
	{
		try {
			return(errorMsg.getText());
		}catch (Exception e) {
			return(e.getMessage());
		}
	}
	
	public String errorLogin()
	{
		try {
			return (loginError.getText());
		} catch (Exception e) {
		return(e.getMessage());
		}
	}
	
}

