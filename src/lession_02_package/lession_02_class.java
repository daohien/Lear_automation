package lession_02_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class lession_02_class {
	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
		
        driver.get("https://demo.guru99.com/v4/");
        
        WebElement userId = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
        WebElement passWord = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]"));
        WebElement login = driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]"));
        userId.sendKeys("HienDT");
        passWord.sendKeys("Aa23456@");
//		WebDriver driver = new FirefoxDriver();
        
        login.click(); 
        System.out.println("Signed in with Click");
		
		driver.quit();
		driver.close();
	
	}
	
	
}
