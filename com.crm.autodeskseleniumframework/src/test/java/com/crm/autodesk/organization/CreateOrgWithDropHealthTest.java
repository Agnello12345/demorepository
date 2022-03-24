package com.crm.autodesk.organization;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;
import com.crm.org.autodesk.pom.CreateNewOption;

import com.crm.org.autodesk.pom.HomePage;
import com.crm.org.autodesk.pom.LoginPage;
import com.crm.org.autodesk.pom.CreationOfModuleInformation;
import com.crm.org.autodesk.pom.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Agnello Fernandes A
 *
 */
public class CreateOrgWithDropHealthTest extends BaseClass
{
	@Test(groups="sanity")
	public void createOrgWithIndustry() throws Throwable {
		// TODO Auto-generated method stub
		ExcelSheet_Utility excellib=new ExcelSheet_Utility();
		Java_Utility javalib=new Java_Utility();
		
		int ran = javalib.getRanDomNum();
	 
		
		
		HomePage homepage=new HomePage(driver);
		homepage.OrganizationLinkText();
		
		CreateNewOption createOrganization=new CreateNewOption(driver);
		createOrganization.ClickOnCreateOrgImg();
		
	CreationOfModuleInformation organizationName=new CreationOfModuleInformation(driver);
	String expectedorgname=excellib.getDataFromExcel("organization", 1, 2)+ran;
	organizationName.OrganizationName(expectedorgname);
	String vistext = excellib.getDataFromExcel("Organization", 2, 3);
	organizationName.clickDropDown();
	
	organizationName.selectIndustryDropdown(vistext);
	
	
	organizationName.saveOrganizationName();
	OrganizationPage orgpg=new OrganizationPage(driver);
	String actualorgname = orgpg.actualOrganizationName();
	Assert.assertEquals(actualorgname.contains(vistext), true);
//	if(actualorgname.contains(expectedorgname))
//	{
//		System.out.println("validation pass");
//	}
//	else
//	{
//		System.out.println("validation fail");
//	}
	}	
	}




