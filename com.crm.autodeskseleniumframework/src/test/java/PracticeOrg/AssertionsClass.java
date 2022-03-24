package PracticeOrg;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsClass 
{
		@Test
		public static void assertionClass()
		{
			
			String expName="akhil";
		    String actualName="akhil";
		    Assert.assertEquals(actualName, expName);
		   // Assert.assertTrue(actualName.contains(expName),"name is not matching");
		    int a=20;
		    int b=20;
		    Assert.assertEquals(a, b);
		    
		    Set<String> str1=new HashSet<String>();
		    str1.add("testyantra");
		    str1.add("banshankari");
		    
		    Set<String> str2=new HashSet<String>();
		    str2.add("testyantra");
		    str2.add("banshankari");
		    Assert.assertEquals(str1, str2);
		    
		    ArrayList<Integer> arr1=new ArrayList<Integer>();
		    arr1.add(10);
		    arr1.add(20);
		    
		    ArrayList<Integer> arr2=new ArrayList<Integer>();
		    arr2.add(10);
		    arr2.add(20);
		    Assert.assertEquals(arr1, arr2);
		    
		    int a1[]= {10,20,30,40};
		    int b1[]= {10,20,30,40};
		    Assert.assertEquals(a1, b1);
		    
		    char ch1='a';
		    char ch2='a';
		    Assert.assertEquals(ch1, ch2);
		    
		    double d1=122.35;
		    double d2=122.35;
		    Assert.assertEquals(d1, d2);
		    
		    boolean value1=true;
		    boolean value2=false;
		    Assert.assertEquals(value1, value2);
		    
		    float c1=122.35f;
		    float c2=122.35f;
		    Assert.assertEquals(c1, c2);
		    
		    long l1=9206609040l;
		    long l2=9206609040l;
		    Assert.assertEquals(l1, l2);
		    
		    
		    Assert.
		    
	
		}
}
