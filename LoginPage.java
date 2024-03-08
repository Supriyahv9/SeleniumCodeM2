package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	//Identify Username tf
	@FindBy(name="user_name")
	private WebElement usernametf;
	
	//Identify Passwordtf tf
	@FindBy(name="user_password")
	private WebElement passwordtf;
	
	//Identify Login button
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
}
