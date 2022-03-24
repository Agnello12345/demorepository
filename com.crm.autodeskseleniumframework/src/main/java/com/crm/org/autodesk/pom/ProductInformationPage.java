package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage 
{
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this );
	}
	
	//to create a product
	@FindBy(css="[name='productname']")
	private WebElement productNameTextField;

	public WebElement getProductNameTextField() 
	{
		return productNameTextField;
	}
	
	/**
	 * This method will pass the product name to productNameTextField.
	 * 
	 */
	public void productName(String productName1)
	{
		productNameTextField.sendKeys(productName1);
	}
	
	
	//to add number of quantity of products
	@FindBy(css="[name='qty_per_unit']")
	private WebElement productQtyTextField;

	public WebElement getProductQtyTextField() 
	{
		return productQtyTextField;
	}
	
	/**
	 * This method is used to add number of quantity of products
	 * 
	 */
	public void ProductQty(String productQty1)
	{
		productQtyTextField.sendKeys(productQty1);
	}

	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveProductInformation;

	public WebElement getSaveProductInformation() 
	{
		return saveProductInformation;
	}
	
/**
 * This method is used to save all the product details
 * 
 */
  public void saveProductInformation()
  {
	  saveProductInformation.click();
  }
  
  //TO pass unit price value
  @FindBy(css="input[name='unit_price']")
  private WebElement unitPriceValue;

public WebElement getUnitPriceValue() 
{
	return unitPriceValue;
}
  
/**
 * THIS method is used to enter unit price value
 * 
 */
  public void enterUnitPrice(String unitprice)
  {
	  unitPriceValue.clear();
	  unitPriceValue.sendKeys(unitprice);
  }
  
  @FindBy(css="span#dtlview_Product")
  private WebElement actualProductName;

public WebElement getActualProductName()
{
	return actualProductName;
}

public String productValidation()
{
	return actualProductName.getText();
}


@FindBy(css="span.dvHeaderText")
private WebElement actualCampaignName;

public WebElement getActualCampaignName() 
{
	return actualCampaignName;
}

/**
 * this method is used to capture the generated campaign name to compare it.
 * @return
 */
public String campaignValidation()
{
	return actualCampaignName.getText();
}
  
  
}

