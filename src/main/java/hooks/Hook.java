package hooks;

import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import factory.BrowserFactory;
import helper.Utility;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	public  WebDriver driver;
	@Before
	public void setup() {
		BrowserFactory.startBrowser(ConfigReader.getProperty("browser"),ConfigReader.getProperty("appURL"));
	}
	
	@After
	public void stop() {
		BrowserFactory.closeBrowser();
	}
	
	@AfterStep
	public void tearDown(Scenario scenario) {
		String name=scenario.getName();
		if(scenario.isFailed()) {
			scenario.attach(Utility.captureScreenshotAsByte(BrowserFactory.getDriver()),"image/png", name);
		}
	}

}
