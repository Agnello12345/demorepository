package com.crm.autodesk.campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.crm.org.autodesk.pom.CreatingNewCampaign;
import com.crm.org.autodesk.pom.HomePage;
import com.crm.org.autodesk.pom.LoginPage;
import com.crm.org.autodesk.pom.ProductCreatePage;
import com.crm.org.autodesk.pom.ProductInformationAssertion;
import com.crm.org.autodesk.pom.ProductInformationPage;
import com.crm.org.autodesk.pom.productRecordsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Agnello Fernandes A
 *
 */
public class CreateCampChoseProductTest extends BaseClass{
@Test(groups="smoke")

	public void createCampChooseProduct()throws Throwable 
   {
		ExcelSheet_Utility excellib=new ExcelSheet_Utility();
		Java_Utility javalib=new Java_Utility();

		   HomePage homepage=new HomePage(driver);
			homepage.productLinkText();
			
			ProductCreatePage createProductImage=new ProductCreatePage(driver);
			createProductImage.clickOnCreateProductImg();
			
			String productName1 = excellib.getDataFromExcel("product", 4, 2);
			
			ProductInformationPage product = new ProductInformationPage(driver);
			product.productName(productName1);
			
			product.saveProductInformation();
			
			ProductInformationAssertion productAssertion = new ProductInformationAssertion(driver);
			String expectedProductName = productAssertion.expectedProductName();
			Assert.assertEquals(expectedProductName.contains(productName1), true);
//			if(expectedProductName.contains(productName1))
//			{
//				System.out.println("validation pass");
//			}
//			else
//			{
//		System.out.println("validation fail");
//			}
//			
			
			int ran = javalib.getRanDomNum();
			
			String campaignname=excellib.getDataFromExcel("campaign", 1, 0)+"_"+ran;
			homepage.createCampaign(driver);
			CreatingNewCampaign create=new CreatingNewCampaign(driver);
			create.clickOnCreate();
			create.campaignName(campaignname);
		    create.clickAndSelectProduct();
		    drivlib.switchToWindow(driver, "Products");
		    driver.manage().window().maximize();
            
		    productRecordsPage productname = new productRecordsPage(driver);
		    productname.createdProduct(productName1);
		    productname.clickOnSearchButton(driver,productName1);
		    drivlib.switchToWindow(driver, "Campaigns");
		    ProductInformationPage assertion = new ProductInformationPage(driver);
		    assertion.saveProductInformation();
		    String actualCampaignName = assertion.campaignValidation();
		    
		    
		    
		    Assert.assertEquals(actualCampaignName.contains(campaignname), true);
		    
		    
//			if(actualCampaignName.contains(campaignname))
//			{
//				System.out.println("validation pass");
//			}
//			else
//			{
//				System.out.println("validation fail");
//			}
//			
			String actualProdName=assertion.productValidation();
			Assert.assertEquals(actualProdName.contains(productName1), true);
//			if(actualProdName.contains(productName1))
//					{
//						System.out.println("validation pass");
//					}
//					else
//					{
//						System.out.println("validation fail");
//					}
			
			productRecordsPage searchbutton=new productRecordsPage(driver);
			searchbutton.clickOnSearchButton(driver, productName1);
	}

}
