package com.crm.autodesk.generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.org.autodesk.pom.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public PropertiesFile_Utility filelib=new PropertiesFile_Utility();
	public WebDriver_Utility drivlib=new WebDriver_Utility();
	
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	@BeforeSuite(groups= {"smoke","sanity","regression"})
	public void bs()
	{
		System.out.println("database connection");
	}
	
	@BeforeTest(groups= {"smoke","sanity","regression"})
	public void bt()
	{
		System.out.println("execute script in parallel mode");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups= {"smoke","sanity","regression"})
	public void bc() throws Throwable
	{
		String Browser = filelib.getPropertyKeyValue("browser");
		if(Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		 else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else {
			driver = new ChromeDriver();
}

		driver.manage().window().maximize();
		drivlib.waitForPageToLoad(driver);
		String url = filelib.getPropertyKeyValue("url");
		driver.get(url);
		sDriver=driver;
		
	}

	@BeforeMethod(groups= {"smoke","sanity","regression"})
	public void bm() throws Throwable
	{
		
		String username = filelib.getPropertyKeyValue("username");
		String password = filelib.getPropertyKeyValue("password");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(username, password);
		
	}
	
	@AfterMethod(groups= {"smoke","sanity","regression"})
	public void am()
	{
		HomePage homepage=new HomePage(driver);
		homepage.logout(driver);
	}
	
	@AfterClass(groups= {"smoke","sanity","regression"})
	public void ac()
	{
		driver.quit();
	}
	
	@AfterTest(groups= {"smoke","sanity","regression"})
	public void at()
	{
	System.out.println("parallel execution is completed");
	}
	
	@AfterSuite(groups= {"smoke","sanity","regression"})
	public void as()
	{
		System.out.println("connection with database removed");
	}

}
