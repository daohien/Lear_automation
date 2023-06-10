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
		
		String pass = "Aa123456";
		lgoObj.inputPassWord(test, pass);
		
		lgoObj.clickBtnSignin(test);
		Alert alert = driver.switchTo().alert();
		lgoObj.matchingResult(test,  alert.getText(), "Please fill out Username and Password.");
		alert.accept();
		
		
		
		
	}

	
}

