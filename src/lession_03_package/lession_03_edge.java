package lession_03_package;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class lession_03_edge {
	public void demo_edge(){
		WebDriver edge_driver = new EdgeDriver();
		
		String url = "https://demo.guru99.com/v4/";
		edge_driver.get(url);
		
		//Mazimize current window
		edge_driver.manage().window().maximize();
		
		// Click button here
		String xpathHere = "//a[@href='http://demo.guru99.com/']";
		WebElement clickBtnHere = edge_driver.findElement(By.xpath(xpathHere));
		clickBtnHere.click();
		
		String url_ads = "https://demo.guru99.com/v4/#google_vignette";
		String url_current = edge_driver.getCurrentUrl();
		if(url_current.equals(url_ads)) {
			String iframeLink = "//iframe[contains(@id,'google_ads_iframe')]";
			WebElement iframeAdd = edge_driver.findElement(By.xpath(iframeLink));
			
			edge_driver.switchTo().frame(iframeAdd);
			String clickBtnAdd = "//div[contains(@role, 'button')]";
			WebElement clickBtnClose = edge_driver.findElement(By.xpath(clickBtnAdd));
			clickBtnClose.click();
			edge_driver.switchTo().defaultContent();
		}
	
		String xpathEmail = "//input[@name='emailid']";
		
		WebElement inputEmail = edge_driver.findElement(By.xpath(xpathEmail));
		
		Random randomEmail = new Random();
		String ramdomInputTextEmail = "hien" + randomEmail.nextInt(1000) + "@gmail.com";
		
		inputEmail.sendKeys(ramdomInputTextEmail);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String xpathSubmit = "//input[@value='Submit']";
		WebElement btnSubmit =  edge_driver.findElement(By.xpath(xpathSubmit));
		
		btnSubmit.click();
		
		String xpathValueUserName = "//td[contains(text(),'User ID :')]/following-sibling::td";
		String xpathValuePassWord = "//td[contains(text(),'Password :')]/following-sibling::td";
		
		WebElement getUserName = edge_driver.findElement(By.xpath(xpathValueUserName));
		WebElement getPassWord = edge_driver.findElement(By.xpath(xpathValuePassWord));
		
		String getTextValueUserName = getUserName.getText();	
		String getTextValuePass = getPassWord.getText();
		
		String url_login = "https://demo.guru99.com/v4";
		edge_driver.get(url_login);
		
		String xpathUserName = "//input[contains(@name,'uid')]";
		WebElement inputUserName = edge_driver.findElement(By.xpath(xpathUserName));
		
		String xpathPassWord = "//input[contains(@name,'password')]";
		WebElement inputPassWord = edge_driver.findElement(By.xpath(xpathPassWord));
		
		inputUserName.sendKeys(getTextValueUserName);
		inputPassWord.sendKeys(getTextValuePass);
		
		
		String xpathLogin = "//input[contains(@name,'btnLogin')]";
		WebElement btnLogin = edge_driver.findElement(By.xpath(xpathLogin));
		btnLogin.click();
		
		
		String xpathConfirmId = "//td[contains(text(),'Manger Id')]";
		WebElement confirmUserName = edge_driver.findElement(By.xpath(xpathConfirmId));
		
		String userNameExpect = confirmUserName.getText();
		System.out.println(userNameExpect);
		
		String userNameActual = "Manger Id :"+" "+getTextValueUserName;
		System.out.println(userNameActual);
		
		if (userNameActual.equals(userNameExpect)) {
			System.out.println("TC passed");
		} else {
			System.out.println("TC failed");
		}
		
		
		edge_driver.quit();
	}
		
	public static void main(String[] args) {
		lession_03_edge test_edge = new lession_03_edge();
		test_edge.demo_edge();
	}
}