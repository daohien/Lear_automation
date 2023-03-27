package lession_03_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Random;

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
		
		System.out.println(buttonSignUp);
		
		// time show buttonSignUp
		
		buttonSignUp.click();
		
		// time show buttonSignUp
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//  ===== Sign up account ===== 
		String inputName = "//input[@id='sign-username']";
		WebElement userName = driver.findElement(By.xpath(inputName));
		System.out.println("userName" + userName);
		
		String inputPassWord = "//input[@id='sign-password']";
		WebElement passWord = driver.findElement(By.xpath(inputPassWord));
		System.out.println("password" + passWord);
		
		String signUp = "//button[contains(text(),'Sign up')]";
		WebElement btnCreateAcount = driver.findElement(By.xpath(signUp));
		
		// Random userName + PassWord
		Random ranDomTextUser = new Random();
		Random ranPassWordText = new Random();
		String ranDomUserName = "Hien" + ranDomTextUser.nextInt(1000);
		String ranDomPassWord = "Aa" + ranPassWordText.nextInt(1000);
		userName.sendKeys(ranDomUserName);	
		passWord.sendKeys(ranDomPassWord);
		
		btnCreateAcount.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// accept alert
		
		driver.switchTo().alert().accept();
		
		
		// ===== Login account ===== 
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
		
		
		inputUserName.sendKeys(ranDomUserName);
		logPassWord.sendKeys(ranDomPassWord);
		
		loginAcc.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ===== Check design =====
		String lgOut = "//a[@id='logout2']";
		WebElement getTextLogOut = driver.findElement(By.xpath(lgOut));
		
		String userNameLogin = "//a[@id='nameofuser']";
		WebElement getAccLogin = driver.findElement(By.xpath(userNameLogin));
				
		String textLogOutActual = getTextLogOut.getText();
		String textUserNameLogin = getAccLogin.getText();
		
		System.out.println(textLogOutActual);
		System.out.println(textUserNameLogin);
		
		String textLogOutExpect = "Log out";		
		String accountUserLoginExpect = "Welcome"+" "+ranDomUserName;
		System.out.println(accountUserLoginExpect);
		
		if(textLogOutActual.equals(textLogOutExpect)&&textUserNameLogin.equals(accountUserLoginExpect)) {
			//TC True
			System.out.println("TC true: UI matching width design");
		} else {
			//TC True
			System.out.println("TC False");
		}
		
		// ===== Logout account success =====
		
		String btnLogOut = "//a[@id='logout2']";
		WebElement clickBtnLogOut = driver.findElement(By.xpath(btnLogOut));
		clickBtnLogOut.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		driver.quit();
		
	}
}
