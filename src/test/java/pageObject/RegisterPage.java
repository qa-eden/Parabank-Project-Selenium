package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	// Locators
@FindBy(xpath="//input[@id='customer.firstName']") WebElement fname;
@FindBy(xpath="//input[@id='customer.lastName']") WebElement lname;
@FindBy(xpath="//input[@id='customer.address.street']") WebElement address_street;
@FindBy(xpath="//input[@id='customer.address.city']") WebElement address_city;
@FindBy(xpath="//input[@id='customer.address.state']") WebElement address_state;
@FindBy(xpath="//input[@id='customer.address.zipCode']") WebElement address_zipCode;
@FindBy(xpath="//input[@id='customer.phoneNumber']") WebElement phoneNumber;
@FindBy(xpath="//input[@id='customer.ssn']") WebElement customer_ssn;
@FindBy(xpath="//input[@id='customer.username']") WebElement customer_username;
@FindBy(xpath="//input[@id='customer.password']") WebElement customer_password;
@FindBy(xpath="//input[@id='repeatedPassword']") WebElement confirm_password;
@FindBy(xpath="//input[@value='Register']") WebElement register;
@FindBy(xpath="//div[@id='rightPanel']//p") WebElement successMsg;
@FindBy(xpath="//span[@id='customer.username.errors']") WebElement usernameErrorMsg;
@FindBy(xpath="//span[@id='repeatedPassword.errors']") WebElement passwordErrorMsg;

public void inputFirstName(String value) {
	fname.sendKeys(value);
}

public void inputLastName(String value) {
	lname.sendKeys(value);
}

public void inputAddress(String value) {
	address_street.sendKeys(value);
}

public void inputCity(String value) {
	address_city.sendKeys(value);
}

public void inputState(String value) {
	address_state.sendKeys(value);
}

public void inputZip(String value) {
	address_zipCode.sendKeys(value);
}

public void inputPhone(String value) {
	phoneNumber.sendKeys(value);
}

public void inputSSN(String value) {
	customer_ssn.sendKeys(value);
}

public void inputUsername(String value) {
	customer_username.sendKeys(value);
}

public void inputPassword(String value) {
	customer_password.sendKeys(value);
}

public void inputConfPassword(String value) {
	confirm_password.sendKeys(value);
}

public void clickRegister()
{
	register.click();
}

public String successRegister()
{
	try {
		return(successMsg.getText());
	} catch(Exception e) {
		return(e.getMessage());
	}
}

public String usernameError()
{
	try {
		return(usernameErrorMsg.getText());
	} catch(Exception e) {
		return(e.getMessage());
	}
}

public String passwordError()
{
	try {
		return(passwordErrorMsg.getText());
	}catch(Exception e) {
		return(e.getMessage());
	}
}

}
