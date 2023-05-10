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

public class Flow_05_cart {
	
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
	public void TC01_noProduct() {
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
		
		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));
		
		clickItemCart.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String totalActualResult = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();	
		
		String totalExpectResult = "";

		Assert.assertEquals(totalActualResult, totalExpectResult);
		
	}
	
	//	Have Product
	public void haveProduct() {
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
		alert.accept();
				
	}
	
	
	@Test
	public void TC02_productImage() {
		haveProduct();
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
		
		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));
		
		clickItemCart.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String imgActualResult = driver.findElement(By.xpath("//tbody[@id = 'tbodyid']/tr[@class='success']/td/img")).getAttribute("src");
		
		String imgExpectResult = "https://www.demoblaze.com/imgs/galaxy_s6.jpg";

		Assert.assertEquals(imgActualResult, imgExpectResult);
		
	}
	
	
	
	@Test
	public void TC03_productTitle() {
		haveProduct();
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
		
		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));
		
		clickItemCart.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String imgActualResult = driver.findElement(By.xpath("//tbody[@id = 'tbodyid']/tr[@class='success']/td/img")).getAttribute("src");
		
		String imgExpectResult = "https://www.demoblaze.com/imgs/galaxy_s6.jpg";

		Assert.assertEquals(imgActualResult, imgExpectResult);
		
	}
	
	
	@Test
	public void TC04_productPrice() {
		haveProduct();
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
		
		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));
		
		clickItemCart.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String priceActualResult = driver.findElement(By.xpath("//td[contains(text(),'360')]")).getText();
		
		String priceExpectResult = "360";

		Assert.assertEquals(priceActualResult, priceExpectResult);
		
	}
	
	
	@Test
	public void TC05_btnDelete() {
		haveProduct();
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
		
		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));
		
		clickItemCart.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String btnAddCartActualResult = driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).getText();
		
		String btnAddCartExpectResult = "Delete";

		Assert.assertEquals(btnAddCartActualResult, btnAddCartExpectResult);
		
	}
	 
	@Test
	public void TC06_clickBtnDelete() {
		haveProduct();
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
		
		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));
		
		clickItemCart.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathBtnDelete = "//a[contains(text(),'Delete')]";
		WebElement clickBtnDeletActualResult =  driver.findElement(By.xpath(xpathBtnDelete));
		clickBtnDeletActualResult.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String totalActualResult = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();	
		
		String totalExpectResult = "";

		Assert.assertEquals(totalActualResult, totalExpectResult);
		
	}
	
	@Test
	public void TC07_totalProduct() {
		haveProduct();
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
		
		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));
		
		clickItemCart.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String totalActualResult = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String totalExpectResult = "360";

		Assert.assertEquals(totalActualResult, totalExpectResult);	
		
	}
	
	@Test
	public void TC08_totalMoreProducts() {
		haveProduct();
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
		
		String xpathTitle = "//a[contains(text(),'Nokia lumia 1520')]";
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
		alert.accept();
		
		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));
		
		clickItemCart.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String totalActualResult = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String totalExpectResult = "1180";

		Assert.assertEquals(totalActualResult, totalExpectResult);	
		
	}
	
}
