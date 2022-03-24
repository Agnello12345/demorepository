package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaign
{
	public CreatingNewCampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css="[alt='Create Campaign...']")
private WebElement clickOnCreate;

public WebElement getClickOnCreate() 
{
	return clickOnCreate;
}

@FindBy(name="campaignname")
private WebElement createCampaignName;

public WebElement getCreateCampaignName() 
{
	return createCampaignName;
}

/**
 * this method is used to pass the campaign name inside textbox.
 * @param campName
 */
public void campaignName(String campName )
{
	createCampaignName.sendKeys(campName);
}

/**
 * 
 * this method is used to click on create campaign image.
 */

public void clickOnCreate()
{
	clickOnCreate.click();
}

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveCampaign;

public WebElement getSaveCampaign() {
	return saveCampaign;
}

/**
 * 
 * this method is used to save the campaign name.
 */
public void saveCampaignName()
{
	saveCampaign.click();	
}

@FindBy(css="img[src='themes/softed/images/select.gif']")
private WebElement createProduct;

public WebElement getCreateProduct() 
{
	return createProduct;
}


/**
 * 
 * this method is used to click on create product link.
 */
public void clickAndSelectProduct()
{
	createProduct.click();	
}
 





}
