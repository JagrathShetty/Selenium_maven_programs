package mavenParameter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MavenParameterTest {

	@Test
	public void receiveData() {
		String url = System.getProperty("url");
		String email = System.getProperty("email");
		String password = System.getProperty("password");
		Reporter.log(url,true);
		Reporter.log(email,true);
		Reporter.log(password,true);
		
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
	}
	
}
