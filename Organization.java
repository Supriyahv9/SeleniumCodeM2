package Vtigercrm;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class Organization {

	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	
	@Test
	public void OrganizationTest() throws IOException {
		
	WebDriver driver = new ChromeDriver();	
	wutil.maximize();
	wutil.implicitwait();
	//To read data from Property File
	String URL = putil.getDataFromPropertyFile("Url");
	String USERNAME =putil.getDataFromPropertyFile("Username");
	String PASSWORD = putil.getDataFromPropertyFile("Password");
	
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	
	
	
	
	}
}
