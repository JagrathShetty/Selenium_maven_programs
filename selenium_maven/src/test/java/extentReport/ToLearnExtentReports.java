package extentReport;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReports {

	@Test
	
	public void report() {
		 
		LocalDateTime.now().toString().replace(":", "-");
		
		//step 1: create ExtentSparkReporter object
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/Extent.html");
		
		//step 2: create ExtentReports object
		ExtentReports extReports=new ExtentReports();
		
		//step 3: attach ExtentSparkReporter to ExtentReporters
		extReports.attachReporter(spark);
		
		//step 4: create ExtentTest object
		ExtentTest test=extReports.createTest("report");
		
		//step5: call log method to add message inside report
		test.log(Status.PASS, "Home page is displayed");
		
		//step 6: call flush method
		extReports.flush();
		
	}
}
