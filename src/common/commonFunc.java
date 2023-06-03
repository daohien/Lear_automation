package common;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;


public class commonFunc {
	public String screenShot(WebDriver driver) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// capture screenshot
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String newName = "./report/screenshot" + getTimeStem() + ".png";

		// copy to report folder
		try {
			FileUtils.copyFile(screenshotFile, new File("./report" + newName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return newName;
	}

	public String getTimeStem() {
		LocalDateTime myDateObj = LocalDateTime.now();
		// System.out.println("Before formatting: " + myDateObj);
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");

		String formattedDate = myDateObj.format(myFormatObj);
		// System.out.println("After formatting: " + formattedDate);
		return formattedDate;
	}
	
	public boolean verifyContais(String expect, String actual) {
		boolean flag = true;
		if (actual.contains(expect) == false) {
			flag = false;
		}
		return flag;
	}
	
	public static void maximinze(WebDriver driver, ExtentTest test) {
		test.info("Maximinze browsers");
		System.out.println("Maximinze browsers");
		driver.manage().window().maximize();	
	}
	
	public static void openUrl(WebDriver driver, ExtentTest test, String url) {
		url = "https://www.demoblaze.com";
		test.info("Go to url" + url);
		System.out.println("Go to url" + url);
		//call link url
		driver.get("get URL" + url);
	}
	

	public static void clickBtnSignUp(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated method stub
		String xpathBtnSignUp = "//a[@id='signin2']";
		WebElement btnSignUp = driver.findElement(By.xpath(xpathBtnSignUp));
		test.info("Xpath btn signup");
		System.out.println("Xpath btn signup");
		btnSignUp.click();
	}

	public static void xpathInputPassWord(WebDriver driver, ExtentTest test, WebElement inputSignPassWord) {
		// TODO Auto-generated method stub
		String xpathSignPassWord = "//input[@id='sign-password']";
		inputSignPassWord = driver.findElement(By.xpath(xpathSignPassWord));
	}
	
	public static void xpathUserName(WebDriver driver, ExtentTest test, WebElement inputUserName) {
		// TODO Auto-generated method stub
		String xpathUserName = "//input[@id='sign-username']";
		inputUserName = driver.findElement(By.xpath(xpathUserName));
	}
	
	
	
	public static void xpathBtnRegister(WebDriver driver, ExtentTest test, WebElement btnRegister) {
		String xpathSignUp = "//button[@onclick='register()']";
		btnRegister = driver.findElement(By.xpath(xpathSignUp));
		test.info("Xpath btn SignUp");
		System.out.println("Xpath btn Signup");
	}

	
}
