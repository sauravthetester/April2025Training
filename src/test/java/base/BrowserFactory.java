package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	public static  WebDriver getBrowser(String browser) {
		
		WebDriver driver = null;
		Properties prop = null;
		
		
		switch(browser) {
		case "firefox": 
			driver = new FirefoxDriver();
			break;
			
		case "chrome": 
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--window-size=1440,850");
			
			//driver = new ChromeDriver(options);
			try {
				driver = new RemoteWebDriver(new URL("http://172.203.230.74:4444/wd/hub"),options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			break;
		
		case "edge":
			driver = new EdgeDriver();
			break;
		}
		
		return driver;
	}

}
