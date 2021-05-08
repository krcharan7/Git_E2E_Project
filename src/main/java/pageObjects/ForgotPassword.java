package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	public ForgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public WebDriver driver;
	
	private By resetEmail=By.cssSelector("input[type='email']");
	private By sendMeInstructions=By.cssSelector("input[type='submit']");

	

	public WebElement resetEmail()
	{
		
		return driver.findElement(resetEmail);
	}
	public WebElement sendMeInstructions()
	{
		
		return driver.findElement(sendMeInstructions);
	}
	
}
