package steps;

import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.SearchResultsPage;

public class MyntraSteps {
	
	HomePage homePage = null;
	SearchResultsPage resultsPage = null;
	
	@Before
	public void before() {
		Base.setDriver();
		Base.getDriver().get("https://www.myntra.com/");
	}

	@Given("myntra home page is laoded")
	public void myntra_home_page_is_laoded() {
		homePage = new HomePage();
	}
	
	@Given("I search for shirt")
	public void i_search_for_shirt() {
		homePage.enterSearchText("shirt");
		homePage.clickSearchIcon();
		resultsPage = new SearchResultsPage();
	}
	
	@Given("Verify at least one product image available")
	public void verify_at_least_one_product_image_available() {
		resultsPage.verifyThereIsAtLeastOneImg();
	}

	@After
	public void after() {
		Base.closeBrowser();
	}

}
