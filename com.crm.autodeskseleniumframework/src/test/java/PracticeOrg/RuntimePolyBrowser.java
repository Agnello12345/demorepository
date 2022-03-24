
package PracticeOrg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RuntimePolyBrowser 
{
	public static void main(String[] args) throws Throwable 
	{
	     FileInputStream fis = new FileInputStream("./src/main/resources/commondata.properties");
	     Properties prop = new Properties();
	     prop.load(fis);
	     String browser = prop.getProperty("browser");
	     String Url = prop.getProperty("url");
	     String un = prop.getProperty("username");
	     String pwd = prop.getProperty("password");
	     System.out.println(browser);
	     System.out.println(Url);
	     System.out.println(un);
	     System.out.println(pwd);
	     WebDriver driver=null;
	     if(browser.equalsIgnoreCase("chrome"))
	     {
	    	 WebDriverManager.chromedriver().setup();    	 
	    	 driver=new ChromeDriver();
	    	 System.out.println("launched browser:"+browser);
	     }
	     else if(browser.equalsIgnoreCase("firefox"))
	     {
	    	 WebDriverManager.firefoxdriver().setup();
	    	 driver=new FirefoxDriver();
	    	 System.out.println("launched browser:"+browser);
	     }
	     else
	     {
	    	 System.out.println("specify a valid browser");
	     }
	     driver.manage().window().maximize();
	     driver.get(Url);
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     driver.findElement(By.name("user_name")).sendKeys(un);
	     driver.findElement(By.name("user_password")).sendKeys(pwd);
	     driver.findElement(By.id("submitButton")).click();
	   }
	}
