package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Base;

// Page Factory Model
public class LoginPage {
	
	public LoginPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Base.getDriver(), 30), this);
	}
	
	@FindBy(xpath = "//input[contains(@class,'mobileNumberInput')]")
	private WebElement mobileNumberInput;
	
	@FindBy(xpath = "//div[text()='CONTINUE']")
	@CacheLookup
	private WebElement continueBtn;
	
	public void enterMobileNumberInput()
	{
		mobileNumberInput.sendKeys("8972389749");
	}
	
	public void clickContinueBtn()
	{
		continueBtn.click();
	}
}
