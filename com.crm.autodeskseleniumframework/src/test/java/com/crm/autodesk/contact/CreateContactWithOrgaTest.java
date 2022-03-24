package com.crm.autodesk.contact;

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

import com.crm.org.autodesk.pom.ContactWithOrganizationNewPage;
import com.crm.org.autodesk.pom.CreateNewOption;
import com.crm.org.autodesk.pom.CreatingContactPage;
import com.crm.org.autodesk.pom.CreationOfModuleInformation;
import com.crm.org.autodesk.pom.HomePage;
import com.crm.org.autodesk.pom.LoginPage;
import com.crm.org.autodesk.pom.OrganizationPage;
import com.crm.org.autodesk.pom.createInformationAssertion;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Agnello Fernandes A
 *
 */
public class CreateContactWithOrgaTest extends BaseClass
{
@Test(groups="smoke")
	public void createContactWithOrga() throws Throwable {
		// TODO Auto-generated method stub
		
		ExcelSheet_Utility excellib=new ExcelSheet_Utility();
		Java_Utility javalib=new Java_Utility();
		
		int ran = javalib.getRanDomNum();

		String orgName=excellib.getDataFromExcel("contacts", 1, 3)+"_"+ran;

				HomePage homepage=new HomePage(driver);
		homepage.OrganizationLinkText();
		
		CreateNewOption createOrganization=
				new CreateNewOption(driver);
		createOrganization.ClickOnCreateOrgImg();
		
	CreationOfModuleInformation organizationName=new CreationOfModuleInformation(driver);
	String expectedorgname=excellib.getDataFromExcel("organization", 1, 2)+ran;
	organizationName.OrganizationName(expectedorgname);
	
	organizationName.saveOrganizationName();
	
	OrganizationPage orgpg=new OrganizationPage(driver);
	String actualorgname = orgpg.actualOrganizationName();
	Assert.assertEquals(actualorgname.contains(expectedorgname), true);
//	if(actualorgname.contains(expectedorgname))
//	{
//		System.out.println("validation pass");
//	}
//	else
//	{
//		System.out.println("validation fail");
//	}
//	
	
    homepage.ContactLinkText();
    
    CreateNewOption create=new CreateNewOption(driver);
    create.ClickOnCreateContactImg();
    
    int ranNum = javalib.getRanDomNum();
    String contactname = excellib.getDataFromExcel("contacts", 1, 0)+ranNum;
   
    CreatingContactPage createContact = new CreatingContactPage(driver); 
    createContact.EnterContactName(contactname);

    
	createContact.clickOnCreateOrg();
	//step 7--how to switch to windows
	
	drivlib.switchToWindow(driver, "Accounts");
	
	driver.manage().window().maximize();
	
	//step 8--after switching window search in search box and select a organization created
	ContactWithOrganizationNewPage contactWithOrgPage=new ContactWithOrganizationNewPage(driver);
	contactWithOrgPage.passOrganizationName(driver,expectedorgname);
	
	
	
	
	//step 9--switching driver focus back
	drivlib.switchToWindow(driver, "Contacts");

	CreatingContactPage createAndSave=new CreatingContactPage(driver);
	createAndSave.clickOnSaveButton();
	
	//step 10--validation
	createInformationAssertion actualmessage=new createInformationAssertion(driver);
	
	String conthdrmsg = actualmessage.actualTextGenerated();
	Assert.assertEquals(conthdrmsg.contains(contactname), true);
//    if(conthdrmsg.contains(contactname))
//    		{
//		System.out.println(contactname+ "is verified---pass");
//	}
//	else
//	{
//		System.out.println(contactname+ "is verified---fail");
//	}
//			
	
	}

	
	
}