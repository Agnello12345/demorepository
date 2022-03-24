package PracticeOrg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.LoginPage;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;
import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest 
{
	public static void main(String[] args) throws Throwable {
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	PropertiesFile_Utility filelib=new PropertiesFile_Utility();
	LoginPage loginpage=new LoginPage(driver);
	WebDriver_Utility drivlib=new WebDriver_Utility();
	ExcelSheet_Utility excellib=new ExcelSheet_Utility();
	Java_Utility javalib=new Java_Utility();
	
	drivlib.waitForPageToLoad(driver);
	String url = filelib.getPropertyKeyValue("url");
	String un = filelib.getPropertyKeyValue("username");
	String pwd = filelib.getPropertyKeyValue("password");
	driver.get(url);
	loginpage.login(un, pwd);
	
	}

}
