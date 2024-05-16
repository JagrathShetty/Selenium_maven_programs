package extentReport;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TestScript extends BaseClass {
	@Test
	public void clickOnBooks() {
		driver.findElement(By.linkText("BOOKS")).click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books");
		test.log(Status.PASS, "Books page is displayed");
	}

}
