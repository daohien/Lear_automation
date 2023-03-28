package lession_03_package;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class lession_03_edge {
	public static void main(String[] args) {
		WebDriver edge_driver = new EdgeDriver();
		
		String url = "https://demo.guru99.com";
		edge_driver.get(url);
		
		//Mazimize current window
		edge_driver.manage().window().maximize();
		
		String xpathEmail = "//tbody/tr[5]/td[2]/input[1]";
		
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
		
		
		String xpathSubmit = "//tbody/tr[6]/td[2]/input[1]";
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
		
		String xpathUserName = "//tbody/tr[1]/td[2]/input[1]";
		WebElement inputUserName = edge_driver.findElement(By.xpath(xpathUserName));
		
		String xpathPassWord = "//tbody/tr[2]/td[2]/input[1]";
		WebElement inputPassWord = edge_driver.findElement(By.xpath(xpathPassWord));
		
		inputUserName.sendKeys(getTextValueUserName);
		inputPassWord.sendKeys(getTextValuePass);
		
		
		String xpathLogin = "//tbody/tr[3]/td[2]/input[1]";
		WebElement btnLogin = edge_driver.findElement(By.xpath(xpathLogin));
		btnLogin.click();
		
		
		String xpathConfirmId = "//tbody/tr[3]/td";
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
	
}
