package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationInformationPage {

	//Identify Organization name
	@FindBy(name="accountname")
	private WebElement organizationnametf;
	
	
	//Identify group radio button
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement groupbtn;
	
	//Identify the dropdown
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
	
	//Identify Save button
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebtn;
	
	
	
	
	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getGroupbtn() {
		return groupbtn;
	}

	public WebElement getOrganizationnametf() {
		return organizationnametf;
	}

}
