package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	//Identify Organization
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organizations;
	
	//Identify Contact
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts;
	
	//Identify image
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;
	
	//Identify Signout
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;

	public WebElement getOrganizations() {
		return organizations;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
}
