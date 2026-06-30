package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountOverviewPage extends BasePage{

	// Constructor
	public AccountOverviewPage(WebDriver driver) {
		super(driver);
	}
	
	// Locators
	@FindBy(xpath="//table[@id='accountTable']") WebElement accountTable;
	@FindBy(xpath="//table[@id='accountTable']//tbody/tr[td/a]")  List<WebElement> accountRows;
	@FindBy(xpath="//select[@id='type']") WebElement accountDropDown;
	@FindBy(xpath="//select[@id='fromAccountId']") WebElement accountFrom;
	@FindBy(xpath="//input[@value='Open New Account']") WebElement btnOpenAccount;
	@FindBy(xpath="//h1[normalize-space()='Account Opened!']") WebElement txtAccountOpened;
	@FindBy(xpath="//table[@id='accountTable']//tbody/tr[td/a]//td[1]//a") WebElement btnFirstAccount;
	@FindBy(xpath="//h1[normalize-space()='Account Details']") WebElement successMsg;
	@FindBy(xpath = "//table[@id='accountTable']/tbody/tr[last()]/td[2]") WebElement totalBalanceCell;
	
	
	// Actions
	public boolean accountTableDisplayed()
	{
		try {
			return accountTable.isDisplayed();
		} catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean accountNumberDisplayed() {
		try {
			if(accountRows.isEmpty()) return false;
			for(WebElement row:accountRows) {
				WebElement accountLink=row.findElement(By.xpath(".//td[1]"));
				if(!accountLink.isDisplayed()) {
					return false;
				}
			} return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean accountBalanceDisplayed()
	{
		try {
			if(accountRows.isEmpty()) return false;
			for(WebElement row:accountRows) {
				WebElement balanceCell=row.findElement(By.xpath(".//td[2]"));
				if(balanceCell.getText().trim().isEmpty()) {
					return false;
				}
			}
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public void selectAccountType(String value)
	{
		Select dropdown=new Select(accountDropDown);
		dropdown.selectByVisibleText(value);
	}
	
	public void selectAccountNumber()
	{
		Select dropdown =new Select(accountFrom);
		List<WebElement> options=dropdown.getOptions();
		String firstact=options.get(0).getAttribute("value");
		dropdown.selectByValue(firstact);
	}
	
	public void clickOpenAccount()
	{
		btnOpenAccount.click();
	}
	
	public String validateAccountCreated()
	{
		try
		{
			return txtAccountOpened.getText();
		} catch(Exception e)
		{
			return e.getMessage();
		}
		
	}
	
	public void clickFirstAccount()
	{
		btnFirstAccount.click();
	}
	
	public String validateSuccessMessage()
	{
		try{
			return successMsg.getText();
		} catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	public boolean isTotalBalanceCorrect()
	{
		try {
			double calculatedTotal = 0;

			for(WebElement row : accountRows) {
				WebElement balanceCell = row.findElement(By.xpath(".//td[2]"));
				String balanceText = balanceCell.getText();
				
				double amount = parseAmount(balanceText);
				calculatedTotal += amount;
			}

			String displayedTotalText = totalBalanceCell.getText();
			double displayedTotal = parseAmount(displayedTotalText);

			return calculatedTotal == displayedTotal;

		} catch(Exception e) {
			return false;
		}
	}

	private double parseAmount(String rawText)
	{
		String cleaned = rawText
			.replace("$", "")
			.replace(",", "")
			.trim();
		return Double.parseDouble(cleaned);
	}
	
	
}
