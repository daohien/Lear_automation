package project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import common.ExcelUtil;

import common.general;

public class Flow_05_cartExcelUtil extends general {
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
	public void allInfoProduct() {
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
		
		ExcelUtil excel = new ExcelUtil();
		
		String imgActualResult = driver.findElement(By.xpath("//tbody[@id = 'tbodyid']/tr[@class='success']/td/img")).getAttribute("src");
		String titleActualResult = driver.findElement(By.xpath("//td[contains(text(),'Samsung galaxy s6')]")).getText();
		String priceActualResult = driver.findElement(By.xpath("//td[contains(text(),'360')]")).getText();
		String btnAddCartActualResult = driver.findElement(By.xpath("//a[contains(text(),'Delete')]")).getText();

		String imgExpectResult = excel.ReadDataAtCell("./resource/data.xlsx", "cart", ExcelUtil.cart_row_start, ExcelUtil.cart_col_image);
		String titleExpectResult = excel.ReadDataAtCell("./resource/data.xlsx", "cart", ExcelUtil.cart_row_start, ExcelUtil.cart_col_title);
		String priceExpectResult = excel.ReadDataAtCell("./resource/data.xlsx", "cart", ExcelUtil.cart_row_start, ExcelUtil.cart_col_price);
		String deleteExpectResult = excel.ReadDataAtCell("./resource/data.xlsx", "cart", ExcelUtil.cart_row_start, ExcelUtil.cart_col_delete);

		
		
		

		Assert.assertEquals(imgActualResult, imgExpectResult);
		
	}
	
	
}
