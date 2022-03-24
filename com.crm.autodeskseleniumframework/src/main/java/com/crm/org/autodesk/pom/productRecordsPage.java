package com.crm.org.autodesk.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.generic_utility.WebDriver_Utility;

public class productRecordsPage extends WebDriver_Utility
{
	public productRecordsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
   @FindBy(css="input.txtBox")
   private WebElement createdProductInformation;

public WebElement getCreatedProductInformation() 
{
	return createdProductInformation;
}
   
 /**
  * This method is used to pass created product.
  *   
  */
  public void createdProduct(String productQty1)
  {
	  createdProductInformation.sendKeys(productQty1);
  }

//To click on product filtering textbox
  
  @FindBy(xpath="//td[@class='small']//select[@name='search_field']")
  private WebElement clickProductFilterTextbox;

public WebElement getClickProductFilterTextbox() 
{
	return clickProductFilterTextbox;
}


/**
 * This method is used to clcik on texbox to filter products from webdriver utility
 *   
 */
  public void selectQuantityDropdown(String visibletext)
  {
	  getSelectMethod(clickProductFilterTextbox,visibletext);
  }
//to click on submit button
  
  @FindBy(name="submit")
  private WebElement searchButton;

public WebElement getSearchButton() 
{
	return searchButton;
}
  
/**
 * this method is used to click on submit button
 * @throws Throwable 
 * 
 */
public void clickOnSearchButton() throws Throwable
{
	
	searchButton.click();	
	//driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
}








}


