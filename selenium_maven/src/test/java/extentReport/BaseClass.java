package extentReport;

import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public ExtentReports extReports;
	public static WebDriver driver;
	public ExtentTest test;
	@BeforeSuite 
	public void configureReports() {
		String time=LocalDateTime.now().toString().replace(":", "-");
		ExtentSparkReporter spark=new ExtentSparkReporter("./reports/Extent_"+time+".html");
		extReports=new ExtentReports();
		extReports.attachReporter(spark);
		
	}
	@BeforeClass
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	@BeforeMethod
	public void login(Method method) {
		test=extReports.createTest(method.getName());
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("Jagrathshetty123@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("jaggu@123");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		test.log(Status.INFO, "User clicked on login button");
		
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.linkText("log out")).click();
		test.log(Status.INFO, "user logged out");
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		extReports.flush();
	}
}
