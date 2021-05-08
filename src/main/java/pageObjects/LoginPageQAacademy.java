package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageQAacademy {
	public LoginPageQAacademy(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public WebDriver driver;
	
	private By Email=By.cssSelector("input[type='email']");
	private By password=By.cssSelector("input[type='password']");
	private By LoginBtn=By.cssSelector("input[type='submit']");
	private  By resetPassword=By.cssSelector("a[href*='password/new']");
	
	public ForgotPassword resetPassword()
	{
		driver.findElement(resetPassword).click();
		return new ForgotPassword(driver);
		
	}
	public WebElement getPassword()
	{
		
		return driver.findElement(password);
	}
	
	public WebElement getEmail()
	{
		
		return driver.findElement(Email);
	}
	public WebElement clickLoginButton()
	{
		
		return driver.findElement(LoginBtn);
	}
	
}
