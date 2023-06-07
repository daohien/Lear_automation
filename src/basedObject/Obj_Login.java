package basedObject;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import common.general;


public class Obj_Login  extends general {
	
	// Xpath
	String xpathIconClose = "//h5[@id='logInModalLabel']/following-sibling::button";
	String xpathUserName = "//input[@id='sign-username']";
	String xpathPassWord = "//input[@id='sign-password']";
	String xpathBtnClose = "//body/div[@id='logInModal']/div[1]/div[1]/div[3]/button[1]";
	String xpathBtnLogin = "//button[contains(text(),'Log in')]";
	WebDriver local_driver; 
	
	// Constructor
	public Obj_Login(WebDriver driver) {
		local_driver = driver;//gan gia tri cho local driver
	}
	
	// Action
	
	public void clickIconClose(ExtentTest test) {
		func.elementClick(local_driver, test,  xpathIconClose);
	}
	
	public void inputUsername(ExtentTest test, String inputData) {
		func.elementSendkey(local_driver, test, xpathUserName, inputData);
	}
	
	public void inputPassWord(ExtentTest test, String inputData) {
		func.elementSendkey(local_driver, test, xpathPassWord, inputData);
	}
	
	public void clickBtnClose(ExtentTest test) {
		func.elementClick(local_driver, test, xpathBtnClose);
	}
	
	public void clickBtnLogin(ExtentTest test) {
		func.elementClick(local_driver, test, xpathBtnLogin);
	}
	

}
