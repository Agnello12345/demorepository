package com.crm.autodesk.generic_utility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * this utility contains webdriver specific common utility
 * @author Agnello Fernandes A
 *
 */

public class WebDriver_Utility 
{
	/**
	 * wait(poll) for element during DOM document load
	 * @param Agnello Fernandes A
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	/**
	 * wait for page to load before identifying any assychronized[java scripts actions] element in DOM [HTML-Document]
	 *@param driver 
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	
	/**
	 * used to wait for element to be clickable in GUI,& check for specific element for every 500 milliseconds 
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickAble(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(element));		
	
	}
	
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeVisible(WebDriver driver,List<WebElement> element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	
	
	
	/**
	 * used to wait for element to be clicKABLE IN GUI,& check for specific element for every 500 milli seconds
	 *@param driver
	 *@param element
	 *@param pollingTime in the form second
	 *@throws Throwable 
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingtime) throws Throwable
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingtime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String partialWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String WID = it.next();
			driver.switchTo().window(WID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle))
			{
				break;
				}}}
	
	
	
	/**
	 * used to switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void switchToAlertWindowAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	/**
	 * used to switch to Alert Window & click on Cancel BUTTON
	 * @param driver
	 */
     public void switchToAlertWindowAndCancel(WebDriver driver)
     {
    	 driver.switchTo().alert().dismiss();
    
     }
     
     
     public void getActionProperty(WebDriver driver,WebElement element)
     {
    	 Actions act=new Actions(driver);
    	 act.moveToElement(element).click().perform();
    	 
     }
     public void getSelectMethod(WebElement industrytype,String vistext)
	    {
			Select s=new Select(industrytype);
			s.selectByVisibleText(vistext);
			
			
	    }
     
     public void getSelectMethod(WebElement element,int indexnumber)
	    {
			Select s=new Select(element);
			s.selectByIndex(indexnumber);
			
			
	    }
 
     
     
     
     
     
     
     
     
     
     
     

     public void getScreenshotNormal(WebDriver driver,String screenshotname) throws Throwable
     {
    	EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
 		File scrimg=eDriver.getScreenshotAs(OutputType.FILE);
 		File dstimg=new File("./Screenshot/"+screenshotname+".png");
 		FileUtils.copyFile(scrimg, dstimg);
 	
     }
    
public void getActionMoveOffset(WebDriver driver,int x,int y)
{
	Actions act=new Actions(driver);
	act.moveByOffset(x, y).click().perform();
	}

public String takeScreenshot(WebDriver driver,String screenshotName) throws Throwable
{
	Java_Utility jlib=new Java_Utility();
	String timestamp=jlib.getSystemDateandTimeFormat();
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest = new File("./screenshot/"+screenshotName+timestamp+".png");
	FileUtils.copyFile(src, dest);
	return dest.getAbsolutePath();
}
}






