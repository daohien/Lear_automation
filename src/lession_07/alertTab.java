package lession_07;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class alertTab {
	public void testScriptWindownTab(WebDriver mulDriver, String browser, String title) {
		// full max-width 100
		mulDriver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "http://live.guru99.com/index.php/";
		//call link url
		mulDriver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathMenuMobile = "//li[contains(@class,'nav-1')]/a";
		WebElement itemMenuMoble =  mulDriver.findElement(By.xpath(xpathMenuMobile));
		itemMenuMoble.click();
		
		
		// get Add to cart loop for
		String xpathSony = "//ul[contains(@class,'first last odd')]/li[2]/div[contains(@class, 'product-info')]/div[3]/ul[contains(@class,'add-to-links')]/li[2]";
		WebElement itemSony = mulDriver.findElement(By.xpath(xpathSony));
		itemSony.click();
		
		String xpathSamsung = "//ul[contains(@class,'first last odd')]/li[1]/div[contains(@class, 'product-info')]/div[3]/ul[contains(@class,'add-to-links')]/li[2]";
		WebElement itemSamsung = mulDriver.findElement(By.xpath(xpathSamsung));
		itemSamsung.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// button compare
		
		String xpathCompare = "//button[contains(@title, 'Compare')]";
		WebElement btnCompare = mulDriver.findElement(By.xpath(xpathCompare));
		btnCompare.click();
		
		// setting tab current
		String currentWindown = mulDriver.getWindowHandle();
		
		//list setting 
		
		Set<String> windows = mulDriver.getWindowHandles();
		
		for (String str : windows) {
			mulDriver.switchTo().window(str); //ma windown
			System.out.println(str);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (mulDriver.getTitle().equalsIgnoreCase(title)) {
				break;
			}
		}
		
		
		
		mulDriver.switchTo().window(currentWindown);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mulDriver.quit();
		
	}
	
	public static void main(String[] args) {
		alertTab testWindownTab = new alertTab();
		//Run chrome
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver chrome_driver = new ChromeDriver(option);
		testWindownTab.testScriptWindownTab(chrome_driver, "chrome", "Products Comparison List - Magento Commerce");
		
		//multiSelect.multi_select(chrome_driver);
		//Run firefox
		WebDriver ff_driver = new FirefoxDriver();
		testWindownTab.testScriptWindownTab(ff_driver, "firefox", "Products Comparison List - Magento Commerce");
		
		//Run MS edge
		WebDriver edge_driver = new EdgeDriver();
		testWindownTab.testScriptWindownTab(edge_driver, "edge", "Products Comparison List - Magento Commerce");
 	}

}
