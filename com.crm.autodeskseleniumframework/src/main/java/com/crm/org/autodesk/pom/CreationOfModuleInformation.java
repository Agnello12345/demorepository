package com.crm.org.autodesk.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.generic_utility.WebDriver_Utility;

public class CreationOfModuleInformation extends WebDriver_Utility
{
	public CreationOfModuleInformation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement OrganizationName;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveOrganizationName; 
	
	@FindBy(xpath="//td[@class='dvtCellLabel']/following-sibling::td//select[@name='industry']")
	private WebElement clickDropdown;
	
	@FindBy(css="select[name='industry']")
	private WebElement industryType;

	public WebElement getIndustryType() {
		return industryType;
	}



	public WebElement getClickDropdown() {
		return clickDropdown;
	}

	

	public WebElement getOrganizationName() {
		return OrganizationName;
	}

	public WebElement getSaveOrganizationName()
	{
		return saveOrganizationName;
	}
/**
 * this method is used to pass the orgtanization name inside textbox.
 * @param orgname
 */

	public void OrganizationName(String orgname)
	{
		OrganizationName.sendKeys(orgname);	
	}
	
	
	/**
	 * 
	 * this method is used to click on industry dropdown.
	 */
	public void clickDropDown()
	{
		clickDropdown.click();
	}
	
	/**
	 * this method is used to select the required text from dropdown.
	 * @param vistxt
	 */
	public void selectIndustryDropdown(String vistxt)
	
	{
		getSelectMethod(industryType,vistxt);
	}
	/**
	 * 
	 * this method is used to save the organization name.
	 */
	public void saveOrganizationName()
	{
		saveOrganizationName.click();
	}
	
    @FindBy(name="lastname")
    private WebElement createContact;

	public WebElement getCreateContact() {
		return createContact;
	}
	
	@FindBy(css="img[src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProduct;

	public WebElement getCreateProduct() {
		return createProduct;
	}
    /**
     * 
     * this method is used to click on create product image.
     */
	public void createProduct()
	{
		createProduct.click();
	}
	
	@FindBy(name="productname")
	private WebElement productName;

	public WebElement getProductName() {
		return productName;
	}
	
	/**
	 * 
	 * this method is used to pass the product name from excel into text box.
	 * @param productName1
	 */
	
	public void createProductName(String productName1)
	{
		productName.sendKeys(productName1);
	}
	
	@FindBy(css="input[name='qty_per_unit']")
	private WebElement quantity;

	public WebElement getQuantity() {
		return quantity;
	}
	/**
	 * 
	 * this method is used to pass the productquantity inside tdropdown.
	 * @param productQty
	 */
	
	public void qtyOfProduct(String productQty)
	{
		quantity.sendKeys(productQty);
	}
	
	
	
	
   
	
}

