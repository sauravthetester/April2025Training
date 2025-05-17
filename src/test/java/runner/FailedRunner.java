package runner;

import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
		features = "@target/failed_scenarios.txt",
		glue = {"steps"},
		dryRun = false,
		monochrome = true,
		tags = "@smoke",
		plugin = {"pretty","html:target/cucumber-reports"}
	)
public class FailedRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
}
