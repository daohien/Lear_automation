package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class flow_03_aboutUs {
	
	WebDriver driver = null;

	@BeforeTest
	@Parameters({"browser"})
	public WebDriver initDriver(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);

		} else if (browser.equalsIgnoreCase("firefox")) {
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
		// full max-width 100
		driver.manage().window().maximize();
		// get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		// call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		String xpathAboutUs = "//a[contains(text(),'About us')]";
		WebElement clickAboutUs = driver.findElement(By.xpath(xpathAboutUs));
		clickAboutUs.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathVideo = "//div[@id='example-video']";
		WebElement btnVideo = driver.findElement(By.xpath(xpathVideo));
		
		btnVideo.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.cssSelector(".video-js .vjs-play-control .vjs-icon-placeholder:before")).click();
		
		
	}

}
