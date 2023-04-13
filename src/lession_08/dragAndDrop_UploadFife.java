package lession_08;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop_UploadFife {
	public void dragAndDrop(WebDriver driver) {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://demos.telerik.com/kendo-ui/dragdrop/index";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathDropTarget = "//div[@id = 'droptarget']";
		WebElement endDropTarget = driver.findElement(By.xpath(xpathDropTarget));
		
		String xpathDragGable = "//div[@id = 'draggable']";
		WebElement startDragGable = driver.findElement(By.xpath(xpathDragGable));
		
		Actions act = new Actions(driver);
		
		act.clickAndHold(startDragGable).moveToElement(endDropTarget).release(endDropTarget).build().perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String textExpectAfterDrop = "You did great!";
		String textActualAfterDrop = endDropTarget.getText();
		
		if(textActualAfterDrop.equals(textExpectAfterDrop)) {
			System.out.println("Testcase true");
		}
		
	}
	
	public void uploadFile(WebDriver driver) {
		
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://the-internet.herokuapp.com/upload";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpathButonUpload = "//input[@id = 'file-upload']";
		WebElement btnUpload = driver.findElement(By.xpath(xpathButonUpload));
		
		String currentDrictory = System.getProperty("user.dir");
		
		btnUpload.sendKeys(currentDrictory + "/resource/hoa.jpg");
		
		String xpathUploadFile = "//input[@id = 'file-submit']";
		WebElement btnUploadFile = driver.findElement(By.xpath(xpathUploadFile));
		btnUploadFile.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void selectTable(WebDriver driver) {
		
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://jqueryui.com/resources/demos/selectable/display-grid.html";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Random ran = new Random();
		
		String items = "//ol[@id = 'selectable']/li[%d]";
		
		WebElement startItem = driver.findElement(By.xpath(String.format(items, ran.nextInt(12))));
		WebElement endItem = driver.findElement(By.xpath(String.format(items, ran.nextInt(12))));
		
		Actions act = new Actions(driver);
		
		act.clickAndHold(startItem).moveToElement(endItem).release(endItem).build().perform();
		
		
		driver.quit();
	}
	
	public static void main(String[] args) {
		dragAndDrop_UploadFife dragDropUploadFile = new dragAndDrop_UploadFife();
		//Run chrome
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver chrome_driver = new ChromeDriver(option);
		dragDropUploadFile.dragAndDrop(chrome_driver);
		dragDropUploadFile.uploadFile(chrome_driver);
		dragDropUploadFile.selectTable(chrome_driver);
		
	}
}
