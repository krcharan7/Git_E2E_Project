package Academy.E2EProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;

public class validateHome extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	LandingPage lp;
	@BeforeTest
	public void initiation() throws Exception {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("navigated to url");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		try {

			WebElement closeAd = driver
					.findElement(By.xpath("//div[@class='sumome-react-svg-image-container']//following-sibling::div"));
			if (closeAd.isDisplayed()) {
				closeAd.click();

			} else {
				System.out.println("no Ad");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void basePageNavigation() throws IOException {

		 lp = new LandingPage(driver);

		Assert.assertEquals(lp.titleValue().getText(), "FEATURED COURSES");
		Assert.assertTrue(lp.HomeValidation().isDisplayed());
		System.out.println("Home is displayed");
	}
	@Test
	public void validateHeader() {

	

		Assert.assertEquals(lp.HeaderValidation().getText(), "An Academy to learn Everything about Testing");
	   System.out.println("Header is validated and checked");	
	}
	@AfterTest
	public void tearDown() {

		driver.close();
		log.info("driver is closed");
	}

}
