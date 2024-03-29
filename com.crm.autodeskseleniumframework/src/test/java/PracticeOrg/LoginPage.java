package PracticeOrg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//initialization of webelements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration of webelements
   @FindBy(name="user_name")
  private WebElement userNameTextField;
   
   @FindBy(name="user_password")
   private WebElement passwordTextField;
   
   @FindBy(id="submitButton")
   private WebElement loginButton;

public WebElement getUserNameTextField() {
	return userNameTextField;
}

public WebElement getPasswordTextField() {
	return passwordTextField;
}

public WebElement getLoginBuuton() {
	return loginButton;
}
   
   //business logic
public void login(String username,String password)
{
	userNameTextField.sendKeys(username);
	passwordTextField.sendKeys(password);
	loginButton.click();
}
	

}
