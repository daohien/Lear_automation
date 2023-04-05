package lession_06;

//import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class lession_06_homework {
	
	public void register_account(WebDriver mulDriver) {
		
		// full max-width 100
		mulDriver.manage().window().maximize();	
		//get link url from page home
		String urlRegister = "https://demo.guru99.com/insurance/v1/register.php";
		//call link url
		mulDriver.get(urlRegister);
		
		// Dropdown list Title
		WebElement selTitle =  mulDriver.findElement(By.xpath("//select[@id='user_title']"));
		Select selectTitle = new Select(selTitle);
		selectTitle.selectByVisibleText("Ms");
		
		// Input firstname
		String xpathFirstName = "//input[@id='user_firstname']";
		WebElement inputFirstName =  mulDriver.findElement(By.xpath(xpathFirstName));
		inputFirstName.sendKeys("Hien");

		// Input surname
		String xpathSurname = "//input[@id='user_surname']";
		WebElement inputSurname = mulDriver.findElement(By.xpath(xpathSurname));
		inputSurname.sendKeys("Dao");
		
		// Input Phone Number
		String xpathPhone = "//input[@id='user_phone']";
		WebElement inputPhone = mulDriver.findElement(By.xpath(xpathPhone));
		inputPhone.sendKeys("0332626905");
		
		//Date of birth
		String xpathYear = "//select[@name='year']";
		WebElement selYear = mulDriver.findElement(By.xpath(xpathYear));
		Select selectYear = new Select(selYear);
		selectYear.selectByVisibleText("1995");
		
		String xpathMonth = "//select[@name='month']";
		WebElement selMonth = mulDriver.findElement(By.xpath(xpathMonth));
		Select selectMonth = new Select(selMonth);
		selectMonth.selectByVisibleText("June");
		
		String xpathDate = "//select[@name='date']";
		WebElement selDate = mulDriver.findElement(By.xpath(xpathDate));
		Select selectDate = new Select(selDate);
		selectDate.selectByVisibleText("7");
		
		// string for licencetype
		
		int lengthRadioBtn = mulDriver.findElements(By.xpath("//input[@name='licencetype']")).size();
		for(int i=0;i<lengthRadioBtn;i++)  
        {  
			mulDriver.findElements(By.xpath("//input[@name='licencetype']")).get(1).click();  
        }  
		
		//Licence Period
		WebElement xpathLicene =  mulDriver.findElement(By.xpath("//select[@id='user_licenceperiod']"));
		Select selectLicene = new Select(xpathLicene);
		selectLicene.selectByVisibleText("2");
		
		//Occupation
		WebElement xpathOccupation =  mulDriver.findElement(By.xpath("//select[@id='user_occupation_id']"));
		Select selectOccupation = new Select(xpathOccupation);
		selectOccupation.selectByVisibleText("Teacher");
		
		//Addres Street
		String xpathAdress = "//input[@id='user_address_attributes_street']";
		WebElement inputAdress = mulDriver.findElement(By.xpath(xpathAdress));
		inputAdress.sendKeys("Bac Tu Liem");
		
		//City
		String xpathCity = "//input[@id='user_address_attributes_city']";
		WebElement inputCity = mulDriver.findElement(By.xpath(xpathCity));
		inputCity.sendKeys("Ha Noi");
		
		//Country
		String xpathCounTry = "//input[@id='user_address_attributes_county']";
		WebElement inputCounTry = mulDriver.findElement(By.xpath(xpathCounTry));
		inputCounTry.sendKeys("Ha Noi");
		
		//Post code
		String xpathPostCode = "//input[@id='user_address_attributes_postcode']";
		WebElement inputPostCode = mulDriver.findElement(By.xpath(xpathPostCode));
		inputPostCode.sendKeys("Ha Noi");
		
		//Email
		Random ranDom = new Random();
		String ranDomEmail = "hiendao" + ranDom.nextInt(1000) + "@gmail.com";
		String xpathEmail = "//input[@id='user_user_detail_attributes_email']";
		WebElement inputEmail = mulDriver.findElement(By.xpath(xpathEmail));
		inputEmail.sendKeys(ranDomEmail);
		
		//PassWord
		String generalPass = "Aa123456@";
		String xpathPassWord = "//input[@id='user_user_detail_attributes_password']";
		WebElement inputPassWord = mulDriver.findElement(By.xpath(xpathPassWord));
		inputPassWord.sendKeys(generalPass);
		
		//ConfirmPassWord
		String xpathConfirmPassWord = "//input[@id='user_user_detail_attributes_password_confirmation']";
		WebElement inputConfirmPassWord = mulDriver.findElement(By.xpath(xpathConfirmPassWord));
		inputConfirmPassWord.sendKeys(generalPass);
		
		//btn create account
		String xpathBtn = "//input[@name='submit']";
		WebElement buttonCreate = mulDriver.findElement(By.xpath(xpathBtn));
		buttonCreate.click();
		
		// inputEmail
		String xpathInputEmail = "//input[@id='email']";
		WebElement inpuEmailLogin = mulDriver.findElement(By.xpath(xpathInputEmail));
		inpuEmailLogin.sendKeys(ranDomEmail);
		
		//input password
		String xpathInputPass = "//input[@id='password']";
		WebElement inpuPassLogin = mulDriver.findElement(By.xpath(xpathInputPass));
		inpuPassLogin.sendKeys(generalPass);
		
		//clickbtn Login
		
		String xpathBtnLogin = "//input[@name='submit']";
		WebElement clickBtnLogin = mulDriver.findElement(By.xpath(xpathBtnLogin));
		clickBtnLogin.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mulDriver.quit();
		
	}
	
//	public void multi_select(WebDriver mulDriver) {
		// full max-width 100
		//mulDriver.manage().window().maximize();	
		//get link url from page home
		//String url = "https://furqanzafar.github.io/react-selectize/#/?category=multi&example=multi-select";
		//call link url
		//mulDriver.get(url);
		
		//Multi select
		//WebElement xpathMultiSel =  mulDriver.findElement(By.xpath("//div[@data-reactid='.d.1.3']"));
//		Select selectProductList = new Select(xpathMultiSel);
		//xpathMultiSel.click();
		//mulDriver.getPageSource();
		//String pageSource = mulDriver.getPageSource();
        //System.out.println(pageSource); 
//		
		//mulDriver.quit();
		
	//}
	
	public static void main(String[] args) {
		
		lession_06_homework register = new lession_06_homework();
		
//		lession_06_homework multiSelect = new lession_06_homework();
		
		
		//Run chrome
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver chrome_driver = new ChromeDriver(option);
		register.register_account(chrome_driver);
		
		//multiSelect.multi_select(chrome_driver);
		//Run firefox
		WebDriver ff_driver = new FirefoxDriver();
		register.register_account(ff_driver);
		
		//Run MS edge
		WebDriver edge_driver = new EdgeDriver();
		register.register_account(edge_driver);
	}
}
