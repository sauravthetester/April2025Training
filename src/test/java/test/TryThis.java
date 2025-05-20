package test;


import org.testng.annotations.Test;

import base.Base;
import listener.RetryAnalyzer;
import pages.HomePage;
import pages.LoginPage;


public class TryThis extends Base{

	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void loginToMyntra1()
	{
		HomePage homePage = new HomePage();
		homePage.clickWishlist();
		LoginPage loginPage = new LoginPage();
		loginPage.enterMobileNumberInput();
		
	}
	
//	@Test(retryAnalyzer = RetryAnalyzer.class)
//	public void loginToMyntra2()
//	{
//		
//		LoginPage loginPage = new LoginPage();
//		loginPage.enterMobileNumberInput();
//		
//	}
//	
//	@Test(retryAnalyzer = RetryAnalyzer.class)
//	public void loginToMyntra3()
//	{
//		
//		LoginPage loginPage = new LoginPage();
//		loginPage.enterMobileNumberInput();
//		
//	}
	
	

}
