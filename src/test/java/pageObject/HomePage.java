package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	// Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	// Locators
	@FindBy(xpath="//a[normalize-space()='Accounts Overview']") WebElement btnAccount;
	@FindBy(xpath="//a[normalize-space()='Open New Account']") WebElement btnCreateAccount;
	
	// Action
	public void clickAccountOverview() {
		btnAccount.click();
	}
	
	public void clickOpenAccount() {
		btnCreateAccount.click();
	}
}
