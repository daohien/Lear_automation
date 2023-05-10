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

import common.general;

public class Flow_06_placeOrder extends general {

	// Add Product
	@Test
	public void addProduct() {
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
		WebElement btnAddCartActualResult = driver.findElement(By.xpath(xpathAddCart));
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
	
	@Test(dependsOnMethods = { "addProduct" })
	public void TC01_clickIconClose() {

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

		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));

		clickItemCart.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathPlaceOrder = "//button[contains(text(),'Place Order')]";
		WebElement clickBtnOrder = driver.findElement(By.xpath(xpathPlaceOrder));
		clickBtnOrder.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathIconClose = "//h5[@id='orderModalLabel']/following-sibling::button";
		WebElement clickIconClose = driver.findElement(By.xpath(xpathIconClose));
		clickIconClose.click();
			
	}
	
	@Test(dependsOnMethods = { "addProduct" })
	public void TC02_totalMoney() {

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

		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));

		clickItemCart.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathPlaceOrder = "//button[contains(text(),'Place Order')]";
		WebElement clickBtnOrder = driver.findElement(By.xpath(xpathPlaceOrder));
		clickBtnOrder.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String totalPurchaseActualResult =  driver.findElement(By.xpath("//label[@id='totalm']")).getText();
		
		String totalPlaceOrder = driver.findElement(By.xpath("//h3[@id='totalp']")).getText();
		
		String expectResult = "Total: " + totalPlaceOrder;
		Assert.assertEquals(totalPurchaseActualResult, expectResult);
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathIconClose = "//h5[@id='orderModalLabel']/following-sibling::button";
		WebElement clickIconClose = driver.findElement(By.xpath(xpathIconClose));
		clickIconClose.click();
		
	}

	@Test(dependsOnMethods = { "addProduct" })
	public void TC03_fieldsEmpty() {

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

		String xpathCart = "//a[@id='cartur']";
		WebElement clickItemCart = driver.findElement(By.xpath(xpathCart));

		clickItemCart.click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathPlaceOrder = "//button[contains(text(),'Place Order')]";
		WebElement clickBtnOrder = driver.findElement(By.xpath(xpathPlaceOrder));
		clickBtnOrder.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathPurchase = "//button[contains(text(),'Purchase')]";
		WebElement clickBtnPurchase = driver.findElement(By.xpath(xpathPurchase));
		clickBtnPurchase.click();
		
		
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expectResult = "Please fill out Name and Creditcard.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
			
		
	}
	
	
	
	
	
	
	
}
