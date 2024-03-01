package CommonUtils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;




public class WebDriverUtil {
	
	
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void handledropdown(WebElement element,String targetedelement) {
		
		Select s = new Select(element);
		s.selectByVisibleText(targetedelement);
	}
	
	public void mousehover(WebDriver driver,WebElement element) {
		
		Actions a = new Actions(driver);
		a.moveToElement(element);
		a.perform();
	}
	
	
	
	
	
	
	
	
	
	
	

}
