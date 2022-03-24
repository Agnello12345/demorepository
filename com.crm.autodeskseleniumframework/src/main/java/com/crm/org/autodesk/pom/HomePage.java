package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.generic_utility.WebDriver_Utility;

public class HomePage extends WebDriver_Utility
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organizationLink;
	
	@FindBy(css="img[src='themes/softed/images/user.PNG']")
	private WebElement signOutIconImage;

	@FindBy(linkText="Products")
	private WebElement productLinkText;
	
	public WebElement getProductLinkText() {
		return productLinkText;
	}
	

	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebElement getorganizationLink()
	{
		return organizationLink;
	}
	
	public WebElement getSignOutIconImage() {
		return signOutIconImage;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}

/**
 * 
 * to click on organization linktext.
 */
public void OrganizationLinkText()
	{
		organizationLink.click();
	}

/**
 * 
 * to click on productlinktext.
 */

public void productLinkText()
{
	productLinkText.click();
}
 
public WebElement productLinkTxt()
{
	return productLinkText;
}
	
@FindBy(linkText="More")
private WebElement mouseoverToMore;

@FindBy(linkText="Campaigns")
private WebElement campaignLinkText;

public WebElement getCampaignLinkText() 
{
	return campaignLinkText;
}



public WebElement getOrganizationLink() 
{
	return organizationLink;
}

public WebElement getMouseoverToMore() {
	return mouseoverToMore;
}
/**
 * 
 * to perform logout action.
 * @param driver
 */
public void logout(WebDriver driver)
{
	getActionProperty(driver,signOutIconImage);
signOutLink.click();
}

//products homepage
@FindBy(linkText="Contacts")
private WebElement contactLink;

public WebElement getContactLink() {
	return contactLink;
}
/**
 * 
 * to click on contactLinkText.
 */
public void ContactLinkText()
{
	contactLink.click();
}

/**
 * to click on campaignlink text after mouseover action.
 * @param driver
 */
public void createCampaign(WebDriver driver)
{
	getActionProperty(driver,mouseoverToMore);
	campaignLinkText.click();
}

public void createInvoice(WebDriver driver)
{
	getActionProperty(driver,mouseoverToMore);
}

public void waitForElementToClickablePom(WebDriver driver)
{
	waitForElementToBeClickAble(driver,organizationLink);
}


}
