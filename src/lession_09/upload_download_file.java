package lession_09;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class upload_download_file {
	
	public void uploadFileRobot(WebDriver driver) {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://blueimp.github.io/jQuery-File-Upload/";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpathButonUpload = "//span[contains(@class, 'fileinput-button')]";
		WebElement btnUpload = driver.findElement(By.xpath(xpathButonUpload));
		btnUpload.click();
		//click open file browser
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		//copy image path to clipboard (1)
		String imagePath =  System.getProperty("user.dir") + File.separator + "resource" +  File.separator + "tulips.jpg" ;
		
		// Encode image path (2)
		StringSelection encodeImagePath = new StringSelection(imagePath);
		
		//past image path file name (3) ->  1,2,3 include Ctrl + C
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(encodeImagePath, null);
		
		// Ctrl + V use robot
		
		try {
			Robot robo = new Robot();
			
			//Ctrl + V
			// keypress Ctrl
			// keypress V
			// keypress release Ctrl
			// keypress release V
			
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyRelease(KeyEvent.VK_V);
			
			 //sendkey enter
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String xpathUploadFile = "//button[@type='submit']";
		WebElement btnUploadFile = driver.findElement(By.xpath(xpathUploadFile));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		btnUploadFile.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathProductName = "//a[contains(@title,'tulips.jpg')]";
		
		WebElement actualProductName = driver.findElement(By.xpath(xpathProductName));
		String actualGetText = actualProductName.getText();

		String expectGetText = "tulips.jpg";
		
		if(actualGetText.equals(expectGetText) ) {
			System.out.println("Upload Trues");
		}
		
	}
	
	public void uploadMuiltipleFile(WebDriver driver) {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://blueimp.github.io/jQuery-File-Upload/";
		//call link url
		driver.get(urlRegister);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpathButonUpload = "//input[@name = 'files[]']";
		WebElement btnUpload = driver.findElement(By.xpath(xpathButonUpload));
		
		String currentDrictory = System.getProperty("user.dir");
		
		btnUpload.sendKeys(currentDrictory + "/resource/hoa.jpg" + "\n" + currentDrictory + "/resource/tulips.jpg"  );
		
		String xpathUploadFile = "//button[@type = 'submit']";
		WebElement btnUploadFile = driver.findElement(By.xpath(xpathUploadFile));
		btnUploadFile.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String xpathProductName = "//tbody[@class = 'files']/tr/td/p/a[text()='%s']";
		WebElement actualProductNameFrist = driver.findElement(By.xpath(String.format(xpathProductName,"hoa.jpg")));
		String actualGetTextFrist = actualProductNameFrist.getText();
		
		WebElement actualProductNameSecond = driver.findElement(By.xpath(String.format(xpathProductName,"tulips.jpg")));
		String actualGetTextSecond = actualProductNameSecond.getText();
		
		String expectGetTextFirst = "hoa.jpg";
		String expectGetTextSecond = "tulips.jpg";
		
		
		if(actualGetTextFrist.equals(expectGetTextFirst) && actualGetTextSecond.equals(expectGetTextSecond) ) {
			System.out.println("Upload Trues");
		}
			
		driver.quit();	
				
	}
	
	public void downLoadFile(WebDriver driver, String browser, ChromeOptions option) {
		// full max-width 100
		driver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://the-internet.herokuapp.com/download";
		//call link url
		driver.get(urlRegister);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement fileDownLoad = driver.findElement(By.xpath("//a[text()='evening.png']"));
		String getTextFileDownLoad = fileDownLoad.getText();
		fileDownLoad.click();
		
		if (browser.equalsIgnoreCase("chrome")) {
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();						
			chromePrefs.put("profile.default_content_settings.popups", 0);	// close popup show address					
			chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "resource");	// set folder download
			File folder = new File(System.getProperty("user.dir")  + File.separator + "resource"); //load folder resources
			
			option.setExperimentalOption("prefs", chromePrefs);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// List the files on that folder
			File[] listOfFiles = folder.listFiles();
			// Look for the file in the files
			// You should write smart REGEX according to the filename
			for (File listOfFile : listOfFiles) {
				if (listOfFile.isFile()) { //to check if the object is a file or not
					String fileName = listOfFile.getName();
					System.out.println("File " + fileName);
					if (fileName.equalsIgnoreCase(getTextFileDownLoad)) {
						System.out.println("found...");
						listOfFile.deleteOnExit();
						break;
					}
				}
			}
			
		} else if(browser.equalsIgnoreCase("firefox")) {
			
		} else {
			
		}
		driver.quit();
		
	}
	
	public static void main(String[] args) {
		upload_download_file downLoad_UploadFile = new upload_download_file();
		//Run chrome
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver chrome_driver = new ChromeDriver(option);
		downLoad_UploadFile.uploadFileRobot(chrome_driver);
		downLoad_UploadFile.uploadMuiltipleFile(chrome_driver);
		downLoad_UploadFile.downLoadFile(chrome_driver, "chrome", option);
		
	}

}
