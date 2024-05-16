package itCompanies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AccentureTest {

	@Test(groups="smoke")
	
	public void launch()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.accenture.com/in-en");
		Reporter.log("Accenture launched Successfully",true);
	}
}
