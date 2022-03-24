
package com.crm.autodesk.contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;
import com.crm.org.autodesk.pom.CreateNewOption;
import com.crm.org.autodesk.pom.CreatingContactPage;
import com.crm.org.autodesk.pom.HomePage;
import com.crm.org.autodesk.pom.LoginPage;
import com.crm.org.autodesk.pom.createInformationAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Agnello Fernandes A
 *
 */
public class CreateContactTest extends BaseClass
{
	@Test(groups="regression")
	public void createContact() throws Throwable 
	{
		ExcelSheet_Utility excellib=new ExcelSheet_Utility();
		Java_Utility javalib=new Java_Utility();
		
    HomePage homepage=new HomePage(driver);
    homepage.ContactLinkText();
    
    CreateNewOption create=new CreateNewOption(driver);
    create.ClickOnCreateContactImg();
    
    int ranNum = javalib.getRanDomNum();
    String contactname = excellib.getDataFromExcel("contacts", 1, 0)+"_"+ranNum;
   
    CreatingContactPage createContact = new CreatingContactPage(driver); 
    createContact.EnterContactName(contactname);
    createContact.clickOnSaveButton();
    createInformationAssertion assertion=new createInformationAssertion(driver);
    
	String actualtext = assertion.actualTextGenerated();
	Assert.assertEquals(actualtext.contains(contactname), true);
//	if(actualtext.contains(contactname))
//    {
//    	System.out.println("validation pass");
//    }
//    else
//    {
//    	System.out.println("validation fail");
//    }
//    	
	  }
}
