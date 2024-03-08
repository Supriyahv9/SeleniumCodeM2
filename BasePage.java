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

import CommonUtils.PropertyFileUtil;
import POM.HomePage;
import POM.LoginPage;

public class BasePage {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		//Object creation
		PropertyFileUtil util = new PropertyFileUtil();
		
		//To read data from property file
		String BROWSER = util.getDataFromPropertyFile("Browser");
		String URL = util.getDataFromPropertyFile("Url");
		String USERNAME = util.getDataFromPropertyFile("Username");
		String PASSWORD = util.getDataFromPropertyFile("Password");
		
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
		hp.getOrganizations().click();
	
	
	
	
	
	
	
	
	
	
	}

}
