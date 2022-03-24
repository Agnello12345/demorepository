package PracticeOrg;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.generic_utility.PropertiesFile_Utility;
import com.crm.autodesk.generic_utility.WebDriver_Utility;
import com.crm.org.autodesk.pom.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class SelectSingleCheckBox 
{

	public static void main(String[] args) throws Throwable
{
	WebDriverManager.chromedriver().setup();
	
	
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.manage().window().maximize();
	
	PropertiesFile_Utility filelib=new PropertiesFile_Utility();
	
	String username = filelib.getPropertyKeyValue("username");
	String password = filelib.getPropertyKeyValue("password");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.login(username, password);
	
	HomePage homepage=new HomePage(driver);
	homepage.productLinkText();
	
	driver.findElement(By.xpath("//table[@class='lvt small']"
			+ "/tbody/tr[last()]/td[1]")).click();
	
//collections approach
//	List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='selected_id']"));
//	int lastIndex = checkboxes.size()-1;
//	WebElement Is = checkboxes.get(lastIndex);
//	Is.click();

}
}


