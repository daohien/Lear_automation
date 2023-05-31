package common;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


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
}
