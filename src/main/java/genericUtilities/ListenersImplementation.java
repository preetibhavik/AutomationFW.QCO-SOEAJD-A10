package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITlistener interface of
 * @author DELL
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report  =  new ExtentReports();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" - @Test is excecution started");
	
		//Intimate the start of @Test to Extent Reports
		test=report.createTest(methodname);
	}
	
	public void onTestSuccess(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" - @Test is excecution pass");
		
		//Intimate extent reports @Test is pass-log the status
		test.log(Status.PASS, methodname+"-@Test is Execution PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" - @Test is excecution FAIL");
		
		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the status as Fail in Extent Reports
		test.log(Status.FAIL, methodname+" - @Test is excecution FAIL");
		
		//Log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());
		
		
		//Capture Screenshot 
		SeleniumUtility s= new SeleniumUtility();
		JavaUtility j= new JavaUtility();
		
		//Configure screenshot name
		String screenShotName = methodname+"-"+j.getSystemDateInFormat();
		
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenShotName);
			
			 
			//Attach the screenshot to Extent Report
			test.addScreenCaptureFromPath(path);
			
			}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+" - @Test is excecution skip");
		
		//Capture the exception
	    System.out.println(result.getThrowable());
	    
	    //Log the status as SKIP in Extent Reports
	    test.log(Status.SKIP, methodname+" - @Test is excecution SKIP");
	    
	    //Log the exception in extent reports
	    test.log(Status.WARNING,result.getThrowable());
	}
   
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	
	public void onStart(ITestContext context) {
		System.out.println("Suite is excecution started");
		
		//Configuration of extent Reports
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+new JavaUtility().getSystemDateInFormat());
		esr.config().setDocumentTitle("SauceLabs Execution Report");
		esr.config().setReportName("Exexution Report");
		esr.config().setTheme(Theme.DARK);
		
		//Load the basic configuration to extent reports class
		ExtentReports report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Window");
		report.setSystemInfo("Base URL", "Testing Environment Edge");
		report.setSystemInfo("Reporter Name", "Preeti");

	}

	
	public void onFinish(ITestContext context) {
		System.out.println("Suite is excecution finished");
		
		//Flush the Report
	    report.flush();
	
	}
	

}
