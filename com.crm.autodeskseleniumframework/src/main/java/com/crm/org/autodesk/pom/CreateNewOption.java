package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOption 
{
	public CreateNewOption(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationImg;
	
	@FindBy(name="industry")
	private WebElement industryType;
	
	public WebElement getCreateOrganizationImg() {
		return createOrganizationImg;
	}

	
	public WebElement getIndustryType() {
		return industryType;
	}
/**
 * this method is used to click on create organization image.
 * 
 */
	public void ClickOnCreateOrgImg()
	{
		createOrganizationImg.click();
	}
	
	@FindBy(css="img[alt='Create Contact...']")
	private WebElement createContactImg;

	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	
	
	/**
	 * 
	 * this method is used to click on create contact img.
	 */
    public void ClickOnCreateContactImg()
    {
    	createContactImg.click();
    }
	
    
	
	
	
	

}

