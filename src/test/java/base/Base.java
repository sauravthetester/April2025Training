package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.aventstack.chaintest.plugins.ChainTestListener;

@Listeners(ChainTestListener.class)
public class Base {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void closeBrowser() {
		driver.get().close();
		driver.remove();
	}
	
	@BeforeMethod
	public static void setDriver() // Execute this before a test method / function
	{
		WebDriver newDriver = BrowserFactory.getBrowser("chrome"); // Launching the browser
		driver.set(newDriver); // Making it thread safe using ThreadLocal
		driver.get().get("https://www.myntra.com/login?referer=https://www.myntra.com/wishlist"); // Opening webpage
		
	}
	
	@AfterMethod
	public static void tearDown(ITestResult result) // Execute this before a test method / function
	{
		if(!result.isSuccess())
	       {
	    	   TakesScreenshot ts = (TakesScreenshot) Base.getDriver();
	    	   byte[] src = ts.getScreenshotAs(OutputType.BYTES);
	    	   ChainTestListener.embed(src, "image/png");
	       }
		closeBrowser();
	}
	
	
}
