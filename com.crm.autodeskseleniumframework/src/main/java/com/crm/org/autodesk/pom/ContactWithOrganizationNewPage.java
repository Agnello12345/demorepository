package com.crm.org.autodesk.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactWithOrganizationNewPage 
{
	public ContactWithOrganizationNewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#search_txt")
	private WebElement searchTextBox;
	
	@FindBy(css="[name='search']")
	private WebElement searchButton;
	
	

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchTextBox() 
	{
		return searchTextBox;
	}
	
	/**
	 *this method is used to pass the values inside searchbox.
	 * 
	 */
	public void passOrganizationName(WebDriver driver,String expectedorgname)
	{
		
		searchTextBox.sendKeys(expectedorgname);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+expectedorgname+"']")).click();
	}

	
	
}
