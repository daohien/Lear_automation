package lession_03_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Alert;

public class lession_03_java {
	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		
		// full max-width 100
		driver.manage().window().maximize();
		
		//get link url from page home
		String urlHome = "https://www.demoblaze.com/";
		//call link url
		driver.get(urlHome);
		
		String btnSignUp = "//a[@id='signin2']";
		WebElement buttonSignUp = driver.findElement(By.xpath(btnSignUp));
		
		System.out.print(buttonSignUp);
		
		// time show buttonSignUp
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		buttonSignUp.click();
		
		// time show buttonSignUp
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Sign up account 
		String inputName = "//input[@id='sign-username']";
		WebElement userName = driver.findElement(By.xpath(inputName));
		System.out.print("userName" + userName);
		
		String inputPassWord = "//input[@id='sign-password']";
		WebElement passWord = driver.findElement(By.xpath(inputPassWord));
		System.out.print("password" + passWord);
		
		String signUp = "//button[contains(text(),'Sign up')]";
		WebElement btnCreateAcount = driver.findElement(By.xpath(signUp));
		
		userName.sendKeys("haizz123456789@");
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		passWord.sendKeys("Aa123456@");
		
		// Thieu dieu kien check account da ton tai
		
		// time show buttonSignUp
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnCreateAcount.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// accept alert
		
		driver.switchTo().alert().accept();
		
		
		//close button when account da ton tai
		 
//		String btnClose = "//body/div[@id='signInModal']/div[1]/div[1]/div[3]/button[1]";
//		WebElement clickCloseAlert = driver.findElement(By.xpath(btnClose));
//		clickCloseAlert.click();
		
		//Login account
		String btnLoginIn = "//a[@id='login2']";
		WebElement clickLogIn = driver.findElement(By.xpath(btnLoginIn));
		clickLogIn.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String loginUserName = "//input[@id='loginusername']";
		WebElement inputUserName = driver.findElement(By.xpath(loginUserName));
		
		String loginPassWord = "//input[@id='loginpassword']";
		WebElement logPassWord = driver.findElement(By.xpath(loginPassWord));
		
		String loginAccount = "//button[contains(text(),'Log in')]";
		WebElement loginAcc = driver.findElement(By.xpath(loginAccount));
		
		
		//get text
//		String valueUserName = userName.getText(); 
//		String valuePassWord = passWord.getText();
//		System.out.print("getUserName" + valueUserName);
//		System.out.print("getPassWord" + valuePassWord);
		
		
		//
		inputUserName.sendKeys("haizz123456789@");
		logPassWord.sendKeys("Aa123456@");
//		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		loginAcc.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		driver.quit();
		
	}
}
