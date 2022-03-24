package PracticeOrg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarMake_Test 
{
	public static void main(String[] args) throws Throwable 
	{
		PropertiesFile_Utility filelib=new PropertiesFile_Utility();
		WebDriver_Utility drivlib=new WebDriver_Utility();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		drivlib.waitForPageToLoad(driver);
		String url = filelib.getPropertyKeyValue("url1");
		String monthAndYear = "May 2022";
		String date="8";
	    driver.get(url);
	    drivlib.getActionMoveOffset(driver, 10, 10);
	    driver.findElement(By.cssSelector("span.langCardClose")).click();
	    driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	    String path = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	    for(;;)
	    {
	    	try
	    	{
	    		driver.findElement(By.xpath(path)).click();
	    		break;
	    	}
	    catch (Exception e) {
		driver.findElement(By.cssSelector("span.DayPicker-NavButton.DayPicker-NavButton--next")).click();
		}
	    
	    }
	    
	    
	    
	    
		
	}

}
