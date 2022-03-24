package PracticeOrg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;
import com.crm.org.autodesk.pom.CreateNewOption;
import com.crm.org.autodesk.pom.CreatingContactPage;
import com.crm.org.autodesk.pom.HomePage;
import com.crm.org.autodesk.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDataProvider

{

@Test(dataProvider="getData")
public void multipleData(String lastname,String mobnum) throws Throwable
{
	PropertiesFile_Utility filelib=new PropertiesFile_Utility();
	
String Browser = filelib.getPropertyKeyValue("browser");
String Url = filelib.getPropertyKeyValue("url");
String un = filelib.getPropertyKeyValue("username");
String pwd = filelib.getPropertyKeyValue("password");
WebDriver driver=null;

if(Browser.equalsIgnoreCase("chrome"))
{
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
}
else if(Browser.equalsIgnoreCase("firefox"))
{
	WebDriverManager.chromedriver().setup();
	 driver=new FirefoxDriver();
}
else
{
	driver=new ChromeDriver();
}
driver.manage().window().maximize();
driver.get(Url);
LoginPage loginpage=new LoginPage(driver);
loginpage.login(un, pwd);

HomePage homepage=new HomePage(driver);
homepage.ContactLinkText();

CreateNewOption create=new CreateNewOption(driver);
create.ClickOnCreateContactImg();

driver.findElement(By.name("lastname")).sendKeys(lastname);
driver.findElement(By.id("mobile")).sendKeys(mobnum);


CreatingContactPage createContact = new CreatingContactPage(driver);
createContact.clickOnSaveButton();
	

homepage.logout(driver);
driver.quit();

	
	}
@DataProvider
public Object[][] getData()
{
	Object[][] objArray = new Object[5][2];
	objArray[0][0]="Akhil";
	objArray[0][1]="9206609040";
	
	
	objArray[1][0]="Agnello";
	objArray[1][1]="7975291459";
	
	objArray[2][0]="sobha";
	objArray[2][1]="9844700022";
	
	objArray[3][0]="rani";
	objArray[3][1]="9844700022";
	
	objArray[4][0]="fernandes";
	objArray[4][1]="7975291459";
	
	return objArray;
}}