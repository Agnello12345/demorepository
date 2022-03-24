package PracticeOrg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertClass 
{
	
	@Test
	public void softassert()
	{
		SoftAssert sf=new SoftAssert();
		String expName="akhil";
	    String actualName="akhil";
	    sf.assertEquals(actualName, actualName);
	    
	    int a=20;
	    int b=20;
	    sf.assertEquals(a, b);
	    
	    Set<String> str1=new HashSet<String>();
	    str1.add("testyantra");
	    str1.add("banshankari");
	    
	    Set<String> str2=new HashSet<String>();
	    str2.add("testyantra");
	    str2.add("banshankari");
	    sf.assertEquals(str1, str2);
	    
	    ArrayList<Integer> arr1=new ArrayList<Integer>();
	    arr1.add(10);
	    arr1.add(20);
	    
	    ArrayList<Integer> arr2=new ArrayList<Integer>();
	    arr2.add(10);
	    arr2.add(20);
	    sf.assertEquals(arr1, arr2);
	    
	    char ch1='a';
	    char ch2='a';
	    sf.assertEquals(ch1, ch2);
	    
	    double d1=122.35;
	    double d2=122.35;
	    sf.assertEquals(d1, d2);
	    
	    
	    
	    
	    
	   
	    
	  
	    
	    
	 }
}
