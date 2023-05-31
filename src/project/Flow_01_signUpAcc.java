package project;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import common.commonFunc;
import common.general;

import org.testng.Assert;


public class Flow_01_signUpAcc extends general {
	
	
	public void TC01_userNameIsBlank() {
		ExtentReports extent = new ExtentReports(); // declare using extend report
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/automation.html"); //point the report to the folder
		extent.attachReporter(spark); // Trinh quan ly report
		
		ExtentTest test = extent.createTest("TC01_userNameIsBlank"); // create moi mot case test
		
		//ExtentTest: chiu trach nhiem ghi log, pass, fail, step
			
		// full max-width 100
		test.info("maximinze browsers");
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		test.info("go to URL" + urlRegister);
		//call link url
		driver.get("get URL" + urlRegister);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathBtnSignUp = "//a[@id='signin2']";
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		btnSignUp.click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathSignPassWord = "//input[@id='sign-password']";
		WebElement inputSignPassWord = driver.findElement(By.xpath(xpathSignPassWord));
		
		inputSignPassWord.sendKeys("Aa123456");
		test.info("input Sign PassWord" + inputSignPassWord);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathSignUp = "//button[@onclick='register()']";
		WebElement btnClickSignUp = driver.findElement(By.xpath(xpathSignUp));
		btnClickSignUp.click();
		
		
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		
		System.out.println(actualResult);
		
		String expectResult = "Please fill out Username and Password.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
		
		extent.flush();
		
	}
	
	
	public void TC02_passWordIsBlank() {
		
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
		
		String xpathBtnSignUp = "//a[@id='signin2']";
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		btnSignUp.click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathUserName = "//input[@id='sign-username']";
		WebElement inputUserName = driver.findElement(By.xpath(xpathUserName));
		inputUserName.sendKeys("HienDT");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathSignUp = "//button[@onclick='register()']";
		WebElement btnClickSignUp = driver.findElement(By.xpath(xpathSignUp));
		btnClickSignUp.click();
		
		
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		
		System.out.println(actualResult);
		
		String expectResult = "Please fill out Username and Password.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
		
	}

	@Test
	public void TC03_successAccRegister() {
		
		test = extent.createTest("TC03_successAccRegister"); // create moi mot case test
		
		// full max-width 100
		test.info("maximize browser");
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		
		test.info("go to URL" + urlRegister);
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathBtnSignUp = "//a[@id='signin2']";
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		btnSignUp.click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random ran = new Random();
		String ranDomUserName = "Hien" + ran.nextInt(1000);
		String ranDomPassWord = "Aa" + ran.nextInt(1000);
		
		String xpathUserName = "//input[@id='sign-username']";
		WebElement inputUserName = driver.findElement(By.xpath(xpathUserName));
		inputUserName.sendKeys(ranDomUserName);
		
		String xpathSignPassWord = "//input[@id='sign-password']";
		WebElement inputSignPassWord = driver.findElement(By.xpath(xpathSignPassWord));
		inputSignPassWord.sendKeys(ranDomPassWord);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathSignUp = "//button[@onclick='register()']";
		WebElement btnClickSignUp = driver.findElement(By.xpath(xpathSignUp));
		btnClickSignUp.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(actualResult);
		
		String expectResult = "Sign up successful.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
		
	}
	

	public void TC04_accAlreadyExists() {
		
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
		
		String xpathBtnSignUp = "//a[@id='signin2']";
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		btnSignUp.click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathUserName = "//input[@id='sign-username']";
		WebElement inputUserName = driver.findElement(By.xpath(xpathUserName));
		inputUserName.sendKeys("HienDT");
		
		String xpathSignPassWord = "//input[@id='sign-password']";
		WebElement inputSignPassWord = driver.findElement(By.xpath(xpathSignPassWord));
		inputSignPassWord.sendKeys("Aa123456");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathSignUp = "//button[@onclick='register()']";
		WebElement btnClickSignUp = driver.findElement(By.xpath(xpathSignUp));
		btnClickSignUp.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(actualResult);
		
		String expectResult = "This user already exist.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
		
	}
	
	
	public void TC05_clickIconClose() {
		
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
		
		String xpathBtnSignUp = "//a[@id='signin2']";
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		btnSignUp.click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathIconClose = "//h5[@id='signInModalLabel']/following-sibling::button";
		WebElement btnIconClose = driver.findElement(By.xpath(xpathIconClose));
		btnIconClose.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathSignInModal = "//div[@id='signInModal']";
		WebElement signInModal = driver.findElement(By.xpath(xpathSignInModal));
		String getValActualResult =  signInModal.getAttribute("class");
		
		String valExpectResult = "modal fade";
		
		Assert.assertEquals(getValActualResult, valExpectResult);
		
	}
	
	
	public void TC06_clickBtnClose() {
		
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
		
		String xpathBtnSignUp = "//a[@id='signin2']";
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		btnSignUp.click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathBtnClose = "//body/div[@id='signInModal']/div[1]/div[1]/div[3]/button[1]";
		WebElement btnClose = driver.findElement(By.xpath(xpathBtnClose));
		btnClose.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathSignInModal = "//div[@id='signInModal']";
		WebElement signInModal = driver.findElement(By.xpath(xpathSignInModal));
		String getValActualResult =  signInModal.getAttribute("class");
		
		String valExpectResult = "modal fade";
		
		Assert.assertEquals(getValActualResult, valExpectResult);
		
	}
	
	
	public void TC07_checkGui() {
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
		
		String xpathBtnSignUp = "//a[@id='signin2']";
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		btnSignUp.click();
	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathTitle = "//h5[@id='signInModalLabel']";
		WebElement titleSignUp = driver.findElement(By.xpath(xpathTitle));
		// color title
		String colTitleActualResult = titleSignUp.getCssValue("color");
		
		String colTitleExpectResult = "#868688";
		
		String xpathIconClose = "//h5[@id='signInModalLabel']/following-sibling::button";
		WebElement btnIconClose = driver.findElement(By.xpath(xpathIconClose));
		String colorIconClose = btnIconClose.getCssValue("color");
		
		String xpathUserName = "//input[@id='sign-username']";
		WebElement inputUserName = driver.findElement(By.xpath(xpathUserName));
		
		String xpathSignPassWord = "//input[@id='sign-password']";
		WebElement inputSignPassWord = driver.findElement(By.xpath(xpathSignPassWord));
		
		String xpathBtnClose = "//body/div[@id='signInModal']/div[1]/div[1]/div[3]/button[1]";
		WebElement btnClose = driver.findElement(By.xpath(xpathBtnClose));
		
		String xpathSignUp = "//button[@onclick='register()']";
		WebElement btnClickSignUp = driver.findElement(By.xpath(xpathSignUp));
		
		Assert.assertEquals(colTitleActualResult, colTitleExpectResult);
		
		btnIconClose.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}




















}
