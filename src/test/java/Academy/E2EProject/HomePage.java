package Academy.E2EProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPageQAacademy;

public class HomePage extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;

	@BeforeMethod
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

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		LandingPage lp = new LandingPage(driver);
		LoginPageQAacademy ld = lp.clickSignInButton();
		ld.getEmail().sendKeys(username);
		ld.getPassword().sendKeys(password);
		System.out.println(text);
		ld.clickLoginButton().click();
		log.info("clicked on login button");
	ForgotPassword fp=ld.resetPassword();
	fp.resetEmail().sendKeys("ggg@gmail.com");
	fp.sendMeInstructions().click();
	 
	}

	@AfterMethod
	public void tearDown() {

		driver.close();
		System.out.println("browser closed");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] DataValues = new Object[2][3];
		DataValues[0][0] = "restricteduser@gmail.com";
		DataValues[0][1] = "23451";
		DataValues[0][2] = "Nonuser@gmail.com tried logging in";

		DataValues[1][0] = "Nonrestricteduser@gmail.com";
		DataValues[1][1] = "5678";
		DataValues[1][2] = "user@gmail.com tried logging in";

		return DataValues;
	}
}
