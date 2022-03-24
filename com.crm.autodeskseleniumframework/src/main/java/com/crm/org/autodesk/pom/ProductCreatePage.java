package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreatePage 
{
	public ProductCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this );
	}
	
	@FindBy(css="img[src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductImage;

	public WebElement getCreateProductImage() 
	{
		return createProductImage;
	}
	
	/**
	 * This method will click on create product image.
	 */
	public void clickOnCreateProductImg()
	{
		createProductImage.click();
	}
	

}
