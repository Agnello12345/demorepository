package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignAssertionPage 
{
	
	public CampaignAssertionPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(css="span.dvHeaderText")
	private WebElement actualname;

   /**
    * this method is used to capture the actual text of campaign.
    * @return
    */
    public String actualCampaignValue()
    		{
    	return  actualname.getText();
    		}
}
