 package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public WebDriver driver;
	
 private By  signin=By.cssSelector("a[href*='sign_in']");
 private By Home= By.cssSelector("ul[class='nav navbar-nav navbar-right'] li a");
 private By title =By.cssSelector("div[class='text-center'] h2");
 private By header =By.cssSelector("div[class*='video-banner']  h3");
	public LoginPageQAacademy clickSignInButton()
	{
		driver.findElement(signin).click();
		return new LoginPageQAacademy(driver);
	}
	public WebElement titleValue()
	{
		
		return driver.findElement(title);
	}
	
	public WebElement HomeValidation()
	{
		
		return driver.findElement(Home);
	}
	
	public WebElement HeaderValidation()
	{
		return driver.findElement(header);
	}
	
}
