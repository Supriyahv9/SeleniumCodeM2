package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationsPage {

	//Identify Create organization..(+)
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorganization;

	public WebElement getCreateorganization() {
		return createorganization;
	}
	
}
