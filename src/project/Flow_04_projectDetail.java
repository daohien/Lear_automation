package project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Flow_04_projectDetail {
	WebDriver driver = null;
	
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
	
	
	@Test
	public void TC01_productImage() {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathTitle = "//a[contains(text(),'Samsung galaxy s6')]";
		WebElement clickItemTitle = driver.findElement(By.xpath(xpathTitle));
		
		clickItemTitle.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String imgActualResult = driver.findElement(By.xpath("//div[@class='carousel-inner']/div[contains(@class,'item')]/img")).getAttribute("src");
		
		String imgExpectResult = "https://www.demoblaze.com/imgs/galaxy_s6.jpg";

		Assert.assertEquals(imgActualResult, imgExpectResult);
		
	}
	
	@Test
	public void TC02_productTitle() {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathTitle = "//a[contains(text(),'Samsung galaxy s6')]";
		WebElement clickItemTitle = driver.findElement(By.xpath(xpathTitle));
		
		clickItemTitle.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String titleActualResult = driver.findElement(By.xpath("//div[@id='tbodyid']/h2")).getText();
		
		String titleExpectResult = "Samsung galaxy s6";

		Assert.assertEquals(titleActualResult, titleExpectResult);
	}
	
	@Test
	public void TC03_productPrice() {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathTitle = "//a[contains(text(),'Samsung galaxy s6')]";
		WebElement clickItemTitle = driver.findElement(By.xpath(xpathTitle));
		
		clickItemTitle.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String priceActualResult = driver.findElement(By.xpath("//div[@id='tbodyid']/h3[@class='price-container']")).getText();
		
		String priceExpectResult = "$360 *includes tax";

		Assert.assertEquals(priceActualResult, priceExpectResult);
	}
	
	@Test
	public void TC04_productSubTitle() {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathTitle = "//a[contains(text(),'Samsung galaxy s6')]";
		WebElement clickItemTitle = driver.findElement(By.xpath(xpathTitle));
		
		clickItemTitle.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String subTitleActualResult = driver.findElement(By.xpath("//div[@id='more-information']/strong")).getText();
		
		String subTitleExpectResult = "Product description";

		Assert.assertEquals(subTitleActualResult, subTitleExpectResult);
	}

	@Test
	public void TC05_productDesc() {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathTitle = "//a[contains(text(),'Samsung galaxy s6')]";
		WebElement clickItemTitle = driver.findElement(By.xpath(xpathTitle));
		
		clickItemTitle.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String subTitleActualResult = driver.findElement(By.xpath("//div[@id='more-information']/p")).getText();
		
		String subTitleExpectResult = "The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.";

		Assert.assertEquals(subTitleActualResult, subTitleExpectResult);
	}
	
	@Test
	public void TC06_btnAddToCart() {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathTitle = "//a[contains(text(),'Samsung galaxy s6')]";
		WebElement clickItemTitle = driver.findElement(By.xpath(xpathTitle));
		
		clickItemTitle.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String btnAddCartActualResult = driver.findElement(By.xpath("//a[contains(text(),'Add to car')]")).getText();
		
		String btnAddCartExpectResult = "Add to cart";

		Assert.assertEquals(btnAddCartActualResult, btnAddCartExpectResult);
	}
	
	@Test
	public void TC07_clickBtnAddToCart() {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathTitle = "//a[contains(text(),'Samsung galaxy s6')]";
		WebElement clickItemTitle = driver.findElement(By.xpath(xpathTitle));
		
		clickItemTitle.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String xpathAddCart = "//a[contains(text(),'Add to car')]";
		WebElement btnAddCartActualResult =  driver.findElement(By.xpath(xpathAddCart));
		btnAddCartActualResult.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		
		String expectResult = "Product added";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();

		Assert.assertEquals(actualResult, expectResult);
	}




}
