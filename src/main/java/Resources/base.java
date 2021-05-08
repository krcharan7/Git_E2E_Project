package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		//String browserName = System.getProperty("browser");
		//the above line is used to get browser from maven cmd prompt or can be used for running the script through Jenkins
		
		 String browserName = prop.getProperty("browser");
		// the above line is used to get browser from properties file

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {

				options.addArguments("--headless");
			}
			driver = new ChromeDriver(options);
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public void captureScreenshot(String testMethodName, WebDriver driver) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "\\ScreenShotReports\\" + testMethodName + ".png";
		try {
			FileUtils.copyFile(source, new File(Destination));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
