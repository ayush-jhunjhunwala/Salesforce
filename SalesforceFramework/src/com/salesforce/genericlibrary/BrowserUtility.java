package com.salesforce.genericlibrary;


import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.salesforce.objectrepositorylibrary.LoginPage;
import com.salesforce.objectrepositorylibrary.LogoutPage;



public class BrowserUtility {
	
	public static WebDriver driver;
	FileDataUtility fileData = new FileDataUtility();
	
	
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		Properties pobj = fileData.getPropertyFileData();
		String browserName = pobj.getProperty("browser");
		if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./BrowserDriver");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./BrowserDriver/IEDriverserver.exe");
			driver = new InternetExplorerDriver();
		}	
	}
	
	@BeforeMethod
	public void enterCredentials() throws Throwable
	{
		//long startTime = System.nanoTime();
		Properties pobj = fileData.getPropertyFileData();
		String url = pobj.getProperty("url");
		driver.get(url);
		String username = fileData.getExcelSheetData("Sheet1", 2, 2);
		String password = fileData.getExcelSheetData("Sheet1", 2, 3);
		WebDriverUtility wb = new WebDriverUtility();
		wb.maximizeBowser();
		wb.waitTillPageLoad(30);
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.login(username, password);
	//	long endTime = System.nanoTime();
	//	long timeTaken = endTime - startTime;
		//System.out.println(timeTaken/1000000);
	}
	
	@AfterMethod
	public void logOff()
	{
		LogoutPage logout = PageFactory.initElements(driver, LogoutPage.class);
		logout.clickLogoutButton();
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}

}
