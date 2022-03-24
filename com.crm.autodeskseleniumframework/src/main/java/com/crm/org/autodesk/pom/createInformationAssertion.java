package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createInformationAssertion 
{
	public createInformationAssertion(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="span.dvHeaderText")
	private WebElement actualText;

	public WebElement getActualText() 
	{
		return actualText;
	}
	
    /**
     * to get the actual text generated
     * 
     */
	public String actualTextGenerated()
	{
		return actualText.getText();
	}
}
