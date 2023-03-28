package lession_03_package;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class lession_03_ff {
	public static void main(String[] args) {
		WebDriver ff_driver = new FirefoxDriver();
		//get link url from page home
		String urlHome = "https://www.demoblaze.com/";
		//call link url
		ff_driver.get(urlHome);
		
		String btnSignUp = "//a[@id='signin2']";
		WebElement buttonSignUp = ff_driver.findElement(By.xpath(btnSignUp));
		
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
		WebElement userName = ff_driver.findElement(By.xpath(inputName));
		System.out.println("userName" + userName);
		
		String inputPassWord = "//input[@id='sign-password']";
		WebElement passWord = ff_driver.findElement(By.xpath(inputPassWord));
		System.out.println("password" + passWord);
		
		String signUp = "//button[contains(text(),'Sign up')]";
		WebElement btnCreateAcount = ff_driver.findElement(By.xpath(signUp));
		
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
		
		ff_driver.switchTo().alert().accept();
		
		
		// ===== Login account ===== 
		String btnLoginIn = "//a[@id='login2']";
		WebElement clickLogIn = ff_driver.findElement(By.xpath(btnLoginIn));
		clickLogIn.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String loginUserName = "//input[@id='loginusername']";
		WebElement inputUserName = ff_driver.findElement(By.xpath(loginUserName));
		
		String loginPassWord = "//input[@id='loginpassword']";
		WebElement logPassWord = ff_driver.findElement(By.xpath(loginPassWord));
		
		String loginAccount = "//button[contains(text(),'Log in')]";
		WebElement loginAcc = ff_driver.findElement(By.xpath(loginAccount));
		
		
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
		WebElement getTextLogOut = ff_driver.findElement(By.xpath(lgOut));
		
		String userNameLogin = "//a[@id='nameofuser']";
		WebElement getAccLogin = ff_driver.findElement(By.xpath(userNameLogin));
				
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
		WebElement clickBtnLogOut = ff_driver.findElement(By.xpath(btnLogOut));
		clickBtnLogOut.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		ff_driver.quit();
	}
}
