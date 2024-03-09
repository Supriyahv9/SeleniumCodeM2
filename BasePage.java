package BasicPOM;

import java.io.IOException;


import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.ExcelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationInformationPage;
import POM.OrganizationsPage;

public class BasePage {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Object creation
		PropertyFileUtil util = new PropertyFileUtil();
		ExcelUtil eutil = new ExcelUtil();
		WebDriverUtil wutil = new WebDriverUtil();
		JavaUtil jutil = new JavaUtil();
		
		//To read data from property file
		String BROWSER = util.getDataFromPropertyFile("Browser");
		String URL = util.getDataFromPropertyFile("Url");
		String USERNAME = util.getDataFromPropertyFile("Username");
		String PASSWORD = util.getDataFromPropertyFile("Password");
		
		//To read data from Excel file
		String ORGNAME = eutil.getDataFromExcel("Organizations", 0, 1);
		String GROUP = eutil.getDataFromExcel("Organizations", 1, 1);
		
		
		//To launch the browser
		
		if(BROWSER.equals("Chrome")) {
		driver = new ChromeDriver();	
		}else if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		//To maximize the browser window
		driver.manage().window().maximize();
		//To Launch the application
		driver.get(URL);
		
		//Create Object of LoginPage
		LoginPage lp = new LoginPage();
		//To initialize webelements
		PageFactory.initElements(driver, lp);
		//Login to the application
		lp.getUsernametf().sendKeys(USERNAME);
		lp.getPasswordtf().sendKeys(PASSWORD);
		lp.getLoginbtn().click();
		
		//Create Object of HomePage
		HomePage hp = new HomePage();
		PageFactory.initElements(driver, hp);
		//Click on Organizations
		hp.getOrganizations().click();
	
	//Create Object of OrganizationsPage
		OrganizationsPage op =new OrganizationsPage();
		PageFactory.initElements(driver, op);
		//Click on Create organization..(+)
		op.getCreateorganization().click();
		
	//Create Object of OrganizationInformationPage
	OrganizationInformationPage oip = new OrganizationInformationPage();
	PageFactory.initElements(driver, oip);
	//Enter Organizationname
	oip.getOrganizationnametf().sendKeys(ORGNAME+jutil.getRandomNumber());
	//Click on group radio button
	oip.getGroupbtn().click();	
	//Select support group in the dropdown	
	wutil.handledropdown(oip.getDropdown(), GROUP);	
	//Click on Save button	
	oip.getSavebtn().click();
	
	Thread.sleep(2000);
	
	//Mouse hover on image
	wutil.mousehover(driver, hp.getImage());
	//Click on signout button
	hp.getSignoutbtn().click();
	
	}

}
