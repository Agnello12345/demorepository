package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationAssertion 
{
	public ProductInformationAssertion(WebDriver driver)
	{
		PageFactory.initElements(driver,this );
	}
	
	@FindBy(css="span.lvtHeaderText")
	private WebElement productNameAssertion;

	public WebElement getProductNameAssertion() 
	{
		return productNameAssertion;
	}
	
	/**
	 * This method is used to return  the generated product name
	 * 
	 */
    public String expectedProductName()
    {
    	return productNameAssertion.getText();
    }
}
