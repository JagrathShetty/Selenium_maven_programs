package extentReport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AttachScreenshot {
	
	@Test
	public void screenshot() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		TakesScreenshot ts=(TakesScreenshot) driver;
		
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/screenshotReport.html");
		ExtentReports extReports=new ExtentReports();
		extReports.attachReporter(spark);
		ExtentTest test=extReports.createTest("screenshot");
		test.log(Status.PASS, "Screenshot added");
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		extReports.flush();
		
	}

}
