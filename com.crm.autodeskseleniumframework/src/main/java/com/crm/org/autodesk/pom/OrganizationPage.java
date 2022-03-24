
package com.crm.org.autodesk.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage 
{
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ActualOrganizationName;

	public WebElement getActualOrganizationName() {
		return ActualOrganizationName;
	}
	/**
	 * this method is used to capture the text of organization name created.
	 * @return
	 */
	public String actualOrganizationName()
	{
		return ActualOrganizationName.getText();
	}
	
}

