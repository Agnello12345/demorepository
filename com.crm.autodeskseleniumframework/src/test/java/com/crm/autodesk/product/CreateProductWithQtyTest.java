package com.crm.autodesk.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.generic_utility.BaseClass;
import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;
import com.crm.org.autodesk.pom.CreationOfModuleInformation;
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
public class CreateProductWithQtyTest extends BaseClass
{
	@Test
	public void createProductWithQty()
			throws Throwable
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
		
		String productQty1 = excellib.getDataFromExcel("product", 4, 3);
		product.ProductQty(productQty1);
		product.saveProductInformation();
		
		ProductInformationAssertion productAssertion = new ProductInformationAssertion(driver);
		String expectedProductName = productAssertion.expectedProductName();
		Assert.assertEquals(expectedProductName.contains(productName1), true);
//		if(expectedProductName.contains(productName1))
//			
//		{
//			System.out.println("validation pass");
//		}
//		else
//		{
//	System.out.println("validation fail");
//		}
		homepage.productLinkText();
		productRecordsPage createdProductPage = new productRecordsPage(driver);
		createdProductPage.createdProduct(productQty1);
		String visibletext = excellib.getDataFromExcel("product", 3, 3);
		//WebElement clickProductFilterTextbox=createdProductPage.getClickProductFilterTextbox();
		createdProductPage.selectQuantityDropdown(visibletext);
		createdProductPage.clickOnSearchButton();
			
		}
}