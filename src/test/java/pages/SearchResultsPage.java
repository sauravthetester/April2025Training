package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import base.Base;

public class SearchResultsPage {
	public SearchResultsPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(Base.getDriver(), 30), this);
	}
	
	@FindBy(xpath = "//*[@class='results-base']//img")
	private WebElement imageProduct;
	
	
	public void verifyThereIsAtLeastOneImg()
	{
		Assert.assertTrue(imageProduct.isDisplayed());
	}
}
