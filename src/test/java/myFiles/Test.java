package myFiles;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test{
	
	public static void main(String[] args) 
	{
		System.out.println("Hello");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//p[text()='Your content goes here.']"))));
		// 5 s
		
		Wait<WebDriver> waitFluent = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(10))
				.ignoring(NoSuchElementException.class);
		
		
		driver.findElement(By.xpath("//p[text()='Your content goes here.']")); // apply explicit wait
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//button[@class='tox-tbtn']")).click();
		
		
//		WebElement emailInput = driver.findElement(By.id("email"));	
//		emailInput.sendKeys("ruthwik@gmail.com");
		
//		WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
//		checkbox1.click();
		
//		WebElement dropdown = driver.findElement(By.id("dropdown"));
//		Select select = new Select(dropdown);
//		select.selectByVisibleText("Option 1");
		
//		WebElement jsAlertBtn = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
//		jsAlertBtn.click();
//		driver.switchTo().alert().accept();
//		System.out.println(driver.switchTo().alert().getText());
		
//		Actions a = new Actions(driver);
//		
//		a.dragAndDrop(driver.findElement(By.cssSelector("#column-a")), 
//				driver.findElement(By.cssSelector("#column-b"))).build().perform();
		
//		String firstWindow = driver.getWindowHandle();
//		
//		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
//		
//		Set<String> windows = driver.getWindowHandles();
//		
//		for(String window : windows) // 2
//		{
//			if(!window.equals(firstWindow))
//				driver.switchTo().window(window);
//		}
//		
//		String newwindowText = driver.findElement(By.xpath("//h3")).getText();
//		System.out.println(newwindowText);
		
	}
	
}
