package PracticeOrg;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithDependency 
{

@Test(dataProvider="getData")


public void multipleData(String lastname,String mobnum,String modifyname)
{
	
}
@DataProvider
public Object[][] getData()
{
	Object[][] objArray = new Object[5][3];
	objArray[0][0]="Akhil";
	objArray[0][1]="9206609040";
	objArray[0][2]="AKHI";
	
	objArray[1][0]="Agnello";
	objArray[1][1]="7975291459";
	objArray[1][2]="AGNELL";
	
	objArray[2][0]="sobha";
	objArray[2][1]="9844700022";
	objArray[2][2]="SOB";
	
	objArray[3][0]="rani";
	objArray[3][1]="9844700022";
	objArray[3][2]="RAN";
	
	objArray[4][0]="fernandes";
	objArray[4][1]="7975291459";
	objArray[4][2]="FERN";
	
	return objArray;
}}