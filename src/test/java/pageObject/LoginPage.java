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
	
	
}
