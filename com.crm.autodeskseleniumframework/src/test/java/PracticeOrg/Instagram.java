package PracticeOrg;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;

public class Instagram {
	public static void main(String[] args) throws Throwable 
		
	
	{
		
		WebDriver driver=new ChromeDriver();
		WebDriver_Utility drivlib=new WebDriver_Utility();
		drivlib.waitForPageToLoad(driver);
		driver.get("http://localhost:8888/");
		Java_Utility javalib=new Java_Utility();
		int ran = javalib.getRanDomNum();
		drivlib.getScreenshotNormal(driver, "akhil"+ran);
		
		
		}
	
}
