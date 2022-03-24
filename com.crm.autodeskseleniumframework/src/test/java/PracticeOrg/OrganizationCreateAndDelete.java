package PracticeOrg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;
import com.crm.org.autodesk.pom.CreateNewOption;
import com.crm.org.autodesk.pom.CreationOfModuleInformation;
import com.crm.org.autodesk.pom.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrganizationCreateAndDelete 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		
		PropertiesFile_Utility filelib = new PropertiesFile_Utility();
		ExcelSheet_Utility excellib = new ExcelSheet_Utility();
		Java_Utility javalib = new Java_Utility();
		WebDriver_Utility weblib = new WebDriver_Utility();
		weblib.waitForPageToLoad(driver);
		String url1 = filelib.getPropertyKeyValue("url");
		String un = filelib.getPropertyKeyValue("username");
		String pwd = filelib.getPropertyKeyValue("password");
		
		driver.get(url1);
		driver.manage().window().maximize();
		LoginPage login = new LoginPage(driver);
		login.login(un, pwd);
		
		HomePage homepage = new HomePage(driver);
		homepage.OrganizationLinkText();
		
		
		CreateNewOption create = new CreateNewOption(driver);
		create.ClickOnCreateOrgImg();
		
		int ran=javalib.getRanDomNum();
		
		CreationOfModuleInformation createOrg = new CreationOfModuleInformation(driver);
		String expectedorgname=excellib.getDataFromExcel("organization", 1, 2)+ran;
		createOrg.OrganizationName(expectedorgname);
		createOrg.saveOrganizationName();
		driver.navigate().back();
		driver.findElement(By.linkText("Organizations")).click();
		
		List<WebElement> orgList = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]"));
		for(;;) {
		
			
				for(WebElement genOrgName:orgList)
				{
				
				if(expectedorgname.equals(genOrgName.getText()))
				{
					System.out.println("genOrgName.getText()");
				weblib.waitForElementToBeVisible(driver, genOrgName);
				driver.findElement(By.xpath("//a[text()='"+genOrgName.getText()+"']")).click();
				break;
				}
				
				else
		
				
				{
				driver.findElement(By.xpath("//table[@class='layerPopupTransport']/tbody/tr/td[3]/table[@class='small']/tbody/tr/td/a[@alt='Next']")).click();
				System.out.println("next page open");
				driver.navigate().refresh();
				
				}}
		}
		
}}



