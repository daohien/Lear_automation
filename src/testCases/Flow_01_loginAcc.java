package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basedObject.Obj_Login;
import common.general;


public class Flow_01_loginAcc extends general {
	Obj_Login lgoObj;

	@BeforeMethod
	public void initData() {
		lgoObj = new Obj_Login(driver);
	}
	
	@Test
	public void TC01_userNameBlank() {
		test = extent.createTest("TC01_userNameBlank"); 
		String url = "https://www.demoblaze.com";
		func.openUrl(driver, test, url);	
		func.maximinze(driver, test);
		
		
		
	}

	
}
