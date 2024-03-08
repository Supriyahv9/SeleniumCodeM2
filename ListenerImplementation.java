package CommonUtils;

import java.io.IOException;


import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;


import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	//System.out.println("Testscript excution is started");
		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript excution is started",true);
		test=report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Testscript excution is Passed");
		String methodName = result.getMethod().getMethodName();
		Object status;
	//Reporter.log(methodName+"Testscript excution is Passed",true);
	test.log(Status.PASS, "Testscript execution is Pass");
	
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Testscript excution is failed");	
		String message = result.getThrowable().toString();
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript excution is failed"+message,true);
		test.log(Status.FAIL, "Testscript execution is Failed");
		
		WebDriverUtil  wutil = new WebDriverUtil ();
		try {
			String path = wutil.screenshot(BaseClass.sdriver, "Contact");
			test.addScreenCaptureFromPath(path);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	
	
	
	
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Testscript excution is skippe");
		String methodName = result.getMethod().getMethodName();
		//Reporter.log(methodName+"Testscript excution is skipped",true);
		test.log(Status.SKIP, "Testscript execution is Skipped");
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("To start the execution");
		//Reporter.log("To start the execution",true);
		
		//use ExtentSparkReporter class just to configure extent report
		JavaUtil jUtil = new JavaUtil();
		
		ExtentSparkReporter reporter =new ExtentSparkReporter("./extentreport/report"+jUtil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Pune");
		
		//use ExtentReports to generate exetentreport
		 report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("chromeversion", "121");
		report.setSystemInfo("Author", "pune");
		
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//System.out.println("To finish the execution");
	//	Reporter.log("To finish the execution",true);
		report.flush();
	}

	

	}


