package PracticeOrg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EaseMyTripCldr_Test {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		PropertiesFile_Utility filelib=new PropertiesFile_Utility();
		WebDriver_Utility drivlib=new WebDriver_Utility();
		ExcelSheet_Utility excellib=new ExcelSheet_Utility();
		Java_Utility javalib=new Java_Utility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		drivlib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
	    String url = filelib.getPropertyKeyValue("url3");
	    String YearAndMonth = "May 2022";
	    String date = "17";
	    driver.get(url);
	    driver.findElement(By.linkText("×")).click();
	    driver.findElement(By.cssSelector("input[placeholder='Departure']")).click();
	    String path = "//div[text()='"+YearAndMonth+"']/"
	    		+ "ancestor::div[@class='box']/"
	    		+ "descendant::li[text()='"+date+"']";
	for(;;)
	{
		try {
			driver.findElement(By.xpath(path)).click();;
			break;
		}
		catch (Exception e) {
			// TODO: handle exception
			driver.findElement(By.cssSelector("img[src='img/right.png']")).click();
		}
	}
	}

}
