package lession_10;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;
import org.testng.Assert;


public class signUpAcc {
	
	public WebDriver initDriver(String browser) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")){
			
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(option);
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else {
			driver = new EdgeDriver();
			
		}
		
		return driver;
		
	}
	
	@Test
	public void userNameIsBlank() {
		WebDriver driver = initDriver("chrome");
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
		
		
		// case01: blank userName
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
		
		
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		
		System.out.println(actualResult);
		
		String expectResult = "Please fill out Username and Password.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
		
		driver.quit();
	}
	
	@Test
	public void passWordIsBlank() {
		WebDriver driver = initDriver("chrome");
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
		
		driver.quit();
		
	}

	@Test
	public void successAccRegister() {
		WebDriver driver = initDriver("chrome");
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
		
		
		Alert alert = driver.switchTo().alert();
		String actualResult = alert.getText();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(actualResult);
		
		String expectResult = "Sign up successful.";
		Assert.assertEquals(actualResult, expectResult);
		alert.accept();
		
		driver.quit();
		
	}
	
	@Test
	public void accAlreadyExists() {
		WebDriver driver = initDriver("chrome");
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
		driver.quit();
		
	}
	
	@Test
	public void clickIconClose() {
		WebDriver driver = initDriver("chrome");
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
		
		driver.quit();
		
	}
	
	@Test
	public void clickBtnClose() {
		WebDriver driver = initDriver("chrome");
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
		
		driver.quit();
		
	}
	
}
