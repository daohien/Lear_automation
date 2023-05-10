package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class general {
	
	public WebDriver driver = null;
	
	@BeforeTest
	@Parameters({"browser"})
	public WebDriver initDriver(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")){
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(options);
			
		}
		
		return driver;
		
	}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
	
}
