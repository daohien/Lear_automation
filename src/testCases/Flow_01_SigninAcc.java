package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basedObject.Obj_Sign;
import common.general;


public class Flow_01_SigninAcc extends general{
	
	Obj_Sign lgoObj;

	@BeforeMethod
	public void initData() {
		lgoObj = new Obj_Sign(driver);
	}
	
	@Test
	public void TC01_userNameBlank() {
		test = extent.createTest("TC01_userNameBlank"); 
		
		lgoObj.clickBtnMenuSignin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		lgoObj.inputPassWord(test, "Aa123456");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnSignin(test);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = driver.switchTo().alert();
		lgoObj.matchingResult(test,  alert.getText(), "Please fill out Username and Password.");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		alert.accept();	
		
		
	}
	
	@Test
	public void TC02_passWordIsBlank() {
		test = extent.createTest("TC02_passWordIsBlank"); 
		
		lgoObj.clickBtnMenuSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		lgoObj.inputPassWord(test,"HienDT");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		lgoObj.clickBtnSignin(test);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		
		lgoObj.matchingResult(test,  alert.getText(), "Please fill out Username and Password.");
		
		alert.accept();	
		
		
	}

	
}

