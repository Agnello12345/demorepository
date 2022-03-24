package com.crm.autodesk.campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.generic_utility.BaseClass;
import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.LoginPage;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;
import com.crm.org.autodesk.pom.CampaignAssertionPage;
import com.crm.org.autodesk.pom.CreatingNewCampaign;
import com.crm.org.autodesk.pom.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Agnello Fernandes A
 *
 */
@Listeners(com.crm.autodesk.generic_utility.ListenerImplementationClass.class)

public class CreateCampaignTest extends BaseClass {
@Test(groups= {"smoke","sanity"})

public void orgName()throws Throwable, Throwable 
	{
		ExcelSheet_Utility excellib=new ExcelSheet_Utility();
		Java_Utility javalib=new Java_Utility();
	    
		HomePage homepage=new HomePage(driver);
		homepage.createCampaign(driver);
		int ran = javalib.getRanDomNum();
		
		String expectedcampaignname=excellib.getDataFromExcel("campaign", 1, 0)+"_"+ran;
		homepage.createCampaign(driver);
		CreatingNewCampaign create=new CreatingNewCampaign(driver);
		create.clickOnCreate();
		
		create.campaignName(expectedcampaignname);
		create.saveCampaignName();
		CampaignAssertionPage actualtext = new CampaignAssertionPage(driver);
		String actualcampaignName=actualtext.actualCampaignValue();
		Assert.assertEquals(actualcampaignName.contains(expectedcampaignname), true);
		
		/*Hard Assert*/
		//Assert.assertEquals(actualcampaignName.contains(expectedcampaignname), true);
		//Assert.assertTrue(actualcampaignName.contains(expectedcampaignname),"name is not matching");
		
//		SoftAssert softassert=new SoftAssert();
//		softassert.assertEquals(actualcampaignName.contains(expectedcampaignname),true);
//		softassert.assertAll();
//	  if(actualcampaignName.contains(expectedcampaignname))
//     {
//    	System.out.println("validation pass");
//     }
//     else
//     {
//    	System.out.println("validation fail");
//     }
    }
	}
