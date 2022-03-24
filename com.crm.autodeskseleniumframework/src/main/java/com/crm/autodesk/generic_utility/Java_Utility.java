package com.crm.autodesk.generic_utility;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * this class contains java specific methods
 * @author AGNELLO FERNANDES A
 *
 */
public class Java_Utility 
{

	 public int getRanDomNum()
	 {
		 Random random = new Random();
		 int ranNum=random.nextInt(1000);
		 return ranNum;
	 }
	 
	 public String getSystemDate()
	 {
		 Date date=new Date();
		 return date.toString();
		 
	 }
	 

		
	
	 public String getSystemDateandTimeFormat()
	 {
		    Date date=new Date();
		    System.out.println(date);
		    String dateAndTime = date.toString();
		    System.out.println(dateAndTime);
		    String YYYY = dateAndTime.split(" ")[5];
		    System.out.println(YYYY);
			String DD = dateAndTime.split(" ")[2];
			System.out.println(DD);
			
			int MM = date.getMonth()+1;
			String finalformat = YYYY+"-"+MM+"-"+DD;
			return finalformat;
	 }
	
	
}

