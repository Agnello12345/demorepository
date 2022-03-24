package PracticeOrg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarClrtrip_Test {

	public static void main(String[] args) throws Throwable 
	{
		// TODO Auto-generated method stub
		PropertiesFile_Utility filelib=new PropertiesFile_Utility();
		WebDriver_Utility drivlib=new WebDriver_Utility();
		ExcelSheet_Utility excellib=new ExcelSheet_Utility();
		Java_Utility javalib=new Java_Utility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		drivlib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
	    String url = filelib.getPropertyKeyValue("url2");
	    driver.get(url);
	    String date = "Mar 30 2022";
	    driver.findElement(By.xpath("//*[name()='svg' and contains(@class,'t-all')]")).click();
	    // String MonthAndYear = driver.findElement(By.cssSelector("div.flex-1.ta-left")).getText();
	    //System.out.println(MonthAndYear);
	    String path = "//div[contains(@class,'ta-left')]"
	    		+ "/ancestor::div[@class='DayPicker-wrapper']"
	    		+ "/descendant::div[contains(@aria-label,'"+date+"')]";
	    for(;;) {
		   try {
	    driver.findElement(By.xpath(path)).click();	 
	    break;
		   }
		   catch (Exception e) {
			// TODO: handle exception
			   driver.findElement(By.xpath("//*[name()='svg' and contains(@class,'t-all')]")).click();
		}
}
}}