package PracticeOrg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.generic_utility.ExcelSheet_Utility;
import com.crm.autodesk.generic_utility.Java_Utility;
import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoibiboTest 
{
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		PropertiesFile_Utility filelib = new PropertiesFile_Utility();
		ExcelSheet_Utility excellib = new ExcelSheet_Utility();
		Java_Utility javalib = new Java_Utility();
		WebDriver_Utility weblib = new WebDriver_Utility();
		weblib.waitForPageToLoad(driver);
		driver.get("https://www.goibibo.com/");
		String category1 = "Rooms";
		String category2 = "Adults";
		String category3 = "Children";
		int roomsDefaultValue=1;
		int adultsDefaultValue=2;
		int childrenDefaultValue=0;
		char add='+';
		char subtract='-';
		String checkInMonthAndYear = "March 2022";
		String checkInDate = "31";
		String checkOutMonthAndYear = "April 2022";
		String checkOutDate = "1";
		
		driver.findElement(By.xpath("//a[text()='Hotels']")).click();
        
		driver.findElement(By.xpath("//div[contains(@class,'RadioButtonWrap-sc-fity')]/..//input[@type='radio']")).click();
		driver.findElement(By.xpath("//div[@data-testid='openCheckinCalendar']")).click();
        driver.findElement(By.xpath("//span[text()='"+checkInMonthAndYear+"']/ancestor::div[contains(@class,'CalenderMonthContainer')]/descendant::li[contains(@data-testid,'date') ]"
        		+ "/span[text()='"+checkInDate+"']")).click(); 
        driver.findElement(By.xpath("//div[@data-testid='openCheckoutCalendar']")).click();
        driver.findElement(By.xpath("//span[text()='"+checkOutMonthAndYear+"']/ancestor::div[contains(@class,'CalenderMonthContainer')]/descendant::li[contains(@data-testid,'date') ]"
        		+ "/span[text()='"+checkOutDate+"']")).click();
	    driver.findElement(By.xpath("//span[text()='Guests & Rooms']")).click();
	    WebElement addChildren = driver.findElement(By.xpath("//span[text()='Children']/ancestor::div[contains(@class,'focqlc')]/descendant::h4[text()='0']"
	    		+ "/following-sibling::span[text()='+' and contains(@class,'dxKRvV')]"));
	    WebElement addAdults = driver.findElement(By.xpath("//span[text()='"+category2+"']/ancestor::div[contains(@class,'focqlc')]/descendant::h4[text()='"+adultsDefaultValue+"']"
	    		+ "/following-sibling::span[text()='"+add+"' and contains(@class,'dxKRvV')]"));
	    WebElement addRooms = driver.findElement(By.xpath("//span[text()='"+category1+"']/ancestor::div[contains(@class,'focqlc')]/descendant::h4[text()='"+roomsDefaultValue+"']"
	    		+ "/following-sibling::span[text()='"+add+"' and contains(@class,'dxKRvV')]"));
	    int age=1;
	    for(int i=childrenDefaultValue;i<3;i++)
	    {
	    	
	    	weblib.waitForElementToBeClickAble(driver, addChildren);
	    	addChildren.click();
	    	
	    	
	    	WebElement select= driver.findElement(By.xpath("//div[contains(@class,'dwebCommonstyles')]/ancestor::div[contains(@class,'WrapperDiv')]/descendant::span[text()='Child ' ]"
	    			+ "/../div[contains(@class,'dwebCommonstyles')]/h4[text()='Select']"));
	    	//weblib.getActionProperty(driver,select);
	    	select.click();
	    	WebElement selectChildAge = driver.findElement(By.xpath("//div[contains(@class,'dwebCommonstyles')]/ancestor::div[contains(@class,'WrapperDiv')]"
	    			+ "/descendant::span[text()='Child ' ]"
	    			+ "/../div[contains(@class,'dwebCommonstyles')]/h4[text()='Select']/../following-sibling::ul/li[text()='"+age+"']"));
	    	selectChildAge.click();
	    	age++;
	    }
	    
	    driver.findElement(By.xpath("//button[text()='Done']")).click();
	    ///../following-sibling::ul/li[text()='1']
	    String city="Udaipur";
	    driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")).click();
		driver.findElement(By.xpath("//ul[contains(@class,'TrendingDestinationsUI__ListTrendInnerWrap')]"
				+ "//p[text()='"+city+"']")).click();
        List<WebElement> hotelNames = driver.findElements(By.xpath("//h4[@itemprop='name']"));
        for(WebElement hotellist:hotelNames)
        {
        	System.out.println(hotellist.getText());
        }
	 
	}

	
	
	//span[text()='"+category3+"']/ancestor::div[contains(@class,'focqlc')]/descendant::h4[text()='"+childrenDefaultValue+"']/following-sibling::span[text()='"+add+"' and contains(@class,'dxKRvV')]
}

