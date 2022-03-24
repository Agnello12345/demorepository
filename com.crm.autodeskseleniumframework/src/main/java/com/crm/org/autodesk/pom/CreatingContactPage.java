package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingContactPage 
{
	public CreatingContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//to enter the lastname of contact
	@FindBy(css="input[name='lastname']")
	private WebElement ContactName;
    
	
	public WebElement getContactName() 
	{
		return ContactName;
	}

  
	/**
	 * this method is used to enter the contact name
	 * 
	 */
	public void EnterContactName(String contactname)
	{
		ContactName.sendKeys(contactname);
	}
//to save the contact name
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This method is used to save the contact name
	 * 
	 */
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	@FindBy(xpath="//td[@class='dvtCellInfo']/input[@name='account_name']/following-sibling::img[@src='themes/softed/images/select.gif']")
	private WebElement clickOnCreate;


	public WebElement getClickOnCreate() 
	{
		return clickOnCreate;
	}
	
	/**
	 * 
	 * this method is used to click on create organization.
	 */
	
	public void clickOnCreateOrg()
	{
		clickOnCreate.click();
	}
	
	@FindBy(id="mobile")
	private WebElement mobilenum;


	public WebElement getMobilenum() {
		return mobilenum;
	}
	
	public void enterMobileNum(String mobnum)
	{
		mobilenum.sendKeys(mobnum);
	}
	


}



