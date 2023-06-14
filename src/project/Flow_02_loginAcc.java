package project;

import java.util.Random;

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

public class Flow_02_loginAcc extends general {

	@Test
	public void TC01_userNameBlank() {
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
		
		String xpathLogin = "//a[@id='login2']";
		WebElement clickBtnLogin = driver.findElement(By.xpath(xpathLogin));
		clickBtnLogin.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathPassWord = "//input[@id='loginpassword']";
		WebElement inputPassWord = driver.findElement(By.xpath(xpathPassWord));
		inputPassWord.sendKeys("Aa123456");

		String xpathBtnLogin = "//button[contains(@onclick,'logIn()')]";
		WebElement btnLogin = driver.findElement(By.xpath(xpathBtnLogin));
		btnLogin.click();

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

		String expectResult = "Please fill out Username and Password.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
	}

	@Test
	public void TC02_userNameNoExits() {
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
		
		String xpathLogin = "//a[@id='login2']";
		WebElement clickBtnLogin = driver.findElement(By.xpath(xpathLogin));
		clickBtnLogin.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathUserName = "//input[@id='loginusername']";
		WebElement inputUserName = driver.findElement(By.xpath(xpathUserName));
		inputUserName.sendKeys("HienDT Test");

		String xpathPassWord = "//input[@id='loginpassword']";
		WebElement inputPassWord = driver.findElement(By.xpath(xpathPassWord));
		inputPassWord.sendKeys("Aa123456");

		String xpathBtnLogin = "//button[contains(@onclick,'logIn()')]";
		WebElement btnLogin = driver.findElement(By.xpath(xpathBtnLogin));
		btnLogin.click();

		try {
			Thread.sleep(10000);
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

		String expectResult = "User does not exist.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
	}
	
	@Test
	public void TC03_loginSuccessful() {
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
		alert.accept();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathLogin = "//body/nav[@id='narvbarx']/div[@id='navbarExample']/ul[1]/li[5]";
		WebElement clickBtnLogin = driver.findElement(By.xpath(xpathLogin));
		clickBtnLogin.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathLoginUserName = "//input[@id='loginusername']";
		WebElement inputLoginUserName = driver.findElement(By.xpath(xpathLoginUserName));

		inputLoginUserName.sendKeys(ranDomUserName);

		String xpathPassWord = "//input[@id='loginpassword']";
		WebElement inputPassWord = driver.findElement(By.xpath(xpathPassWord));
		inputPassWord.sendKeys(ranDomPassWord);

		String xpathBtnLogin = "//button[contains(@onclick,'logIn()')]";
		WebElement btnLogin = driver.findElement(By.xpath(xpathBtnLogin));
		btnLogin.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String userNameLogin = "//a[@id='nameofuser']";
		WebElement textUserNameActualResult = driver.findElement(By.xpath(userNameLogin));
		String actualResult = textUserNameActualResult.getText();

		String expectResult = "Welcome"+" "+ranDomUserName;
		Assert.assertEquals(actualResult, expectResult);

	}

	@Test
	public void TC04_passWordBlank() {
		// full max-width 100
		driver.manage().window().maximize();
		// get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		// call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathLogin = "//a[@id='login2']";
		WebElement clickBtnLogin = driver.findElement(By.xpath(xpathLogin));
		clickBtnLogin.click();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathUserName = "//input[@id='loginusername']";
		WebElement inputUserName = driver.findElement(By.xpath(xpathUserName));

		inputUserName.sendKeys("HienDT");

		String xpathBtnLogin = "//button[contains(@onclick,'logIn()')]";
		WebElement btnLogin = driver.findElement(By.xpath(xpathBtnLogin));
		btnLogin.click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expectResult = "Please fill out Username and Password.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
	}

	@Test
	public void TC05_passWordIncorrect() {
		// full max-width 100
		driver.manage().window().maximize();
		// get link url from page home
		String urlRegister = "https://www.demoblaze.com/index.html";
		// call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			
			e.printStackTrace();
		}
		
		String xpathLogin = "//a[@id='login2']";
		WebElement clickBtnLogin = driver.findElement(By.xpath(xpathLogin));
		clickBtnLogin.click();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathUserName = "//input[@id='loginusername']";
		WebElement inputUserName = driver.findElement(By.xpath(xpathUserName));

		inputUserName.sendKeys("HienDT");

		String xpathPassWord = "//input[@id='loginpassword']";
		WebElement inputPassWord = driver.findElement(By.xpath(xpathPassWord));
		inputPassWord.sendKeys("Aa123456123");

		String xpathBtnLogin = "//button[contains(@onclick,'logIn()')]";
		WebElement btnLogin = driver.findElement(By.xpath(xpathBtnLogin));
		btnLogin.click();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();

		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String expectResult = "Wrong password.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();

	}

}
