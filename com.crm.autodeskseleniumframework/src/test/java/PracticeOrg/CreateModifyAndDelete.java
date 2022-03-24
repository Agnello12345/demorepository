package PracticeOrg;

import org.testng.annotations.Test;

public class CreateModifyAndDelete {

	@Test
	public void createAccount()
{
	System.out.println("LOGIN");
	System.out.println("Create ACCOUNT");
	System.out.println("LOGOUT");
}

	
	@Test(dependsOnMethods="createAccount")
public void modifyAccount()
{
	System.out.println("LOGIN");
	System.out.println("Modify ACCOUNT");
	System.out.println("LOGOUT");

}
	@Test(dependsOnMethods="modifyAccount")
public void deleteAcount()
{
	System.out.println("LOGIN");
	System.out.println("Delete ACCOUNT");
	System.out.println("LOGOUT");

}



}
