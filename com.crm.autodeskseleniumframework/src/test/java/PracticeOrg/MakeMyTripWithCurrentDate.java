package PracticeOrg;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripWithCurrentDate 
{
	public static void main(String[] args) throws Throwable 
	{
		PropertiesFile_Utility filelib=new PropertiesFile_Utility();
		WebDriver_Utility drivlib=new WebDriver_Utility();
	
		WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	drivlib.waitForPageToLoad(driver);
		
		String url = filelib.getPropertyKeyValue("url1");
		driver.get(url);
		String src = "Bangalore, India";
		String dest = "Bangkok, Thailand";
		driver.manage().window().maximize();
		
		drivlib.getActionMoveOffset(driver, 10, 10);
		//driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
	    driver.findElement(By.xpath("//p[contains(@class,'blackText') and "
	    		+ "(text()='"+src+"')]")).click();
	    driver.findElement(By.xpath("//span[text()='To']")).click();
	    driver.findElement(By.xpath("//p[contains(@class,'blackText') and (text()='"+dest+"')]")).click();
	    driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	    
	    //to get current date 
	    LocalDateTime dateAndTime = LocalDateTime.now();
	    //LocalDateTime dateAndTime = LocalDateTime.now().plusDays(1); for nextDate
	    System.out.println(dateAndTime);
	    String month = dateAndTime.getMonth().toString();
	    System.out.println(month);
	    int date = dateAndTime.getDayOfMonth();
	    System.out.println(date);
	    int year = dateAndTime.getYear();
	    System.out.println(year);
	    String actualMonth = month.substring(0, 1)+month.substring(1).toLowerCase();
	    System.out.println(actualMonth);
	    String monthAndYear = actualMonth+" "+year;
		System.out.println(monthAndYear);

    	driver.findElement(By.xpath("//div[text()='"+monthAndYear+"']"
    			+ "/ancestor::div[@class='DayPicker-Month']"
    			+ "/descendant::p[text()='"+date+"']")).click();	
	    driver.findElement(By.xpath("//a[contains(@class,'SearchBtn')]")).click();
	    
	    WebElement flightElement = driver.findElement(By.xpath(""
	    		+ "//p[text()='Flights from ']"));
    	drivlib.waitForElementToBeVisible(driver, flightElement);
    	List<WebElement> flightNames = driver.findElements
    			(By.xpath("//span[@class='boldFont blackText airlineName']"));
    	for (WebElement textofAirlines : flightNames)
    	{
    		System.out.println(textofAirlines.getText());
		}
	}
}
