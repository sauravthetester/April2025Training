package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import base.Base;

public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Base.getDriver(), 30), this);
	}
	
	@FindBy(css = ".desktop-searchBar")
	private WebElement searchInput;
	
	@FindBy(css = ".desktop-submit")
	@CacheLookup
	private WebElement searchIcon;
	
	@FindBy(xpath = "//span[normalize-space()='Wishlist']")
	@CacheLookup
	private WebElement wishlist;
	
	public void enterSearchText(String text)
	{
		searchInput.sendKeys(text);
	}
	
	public void clickSearchIcon()
	{
		searchIcon.click();
	}
	
	public void clickWishlist()
	{
		wishlist.click();
	}

}
