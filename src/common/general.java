package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class general {
	
	public WebDriver driver = null;
	public static ExtentTest test;
	public static ExtentReports extent; 
	public static commonFunc func = new commonFunc();
	
	@BeforeTest
	@Parameters({"browser"})
	public WebDriver initDriver(String browser) {
		extent = new ExtentReports(); // khai bao xu dung extent report
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/Automation_"+browser+".html"); // tro report den folder
		extent.attachReporter(spark); // attached spart report vao trinh quan ly report cua extent report
		
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
	
	@AfterMethod
	public void saveImage() {
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(func.screenShot(driver)).build());		

		extent.flush();
	}
	
	@AfterTest
	public void cleanUp() {
		driver.quit();
	}
	
}
