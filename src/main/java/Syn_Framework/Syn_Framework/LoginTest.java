package Syn_Framework.Syn_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTest extends Reusablefun{
	
	WebDriver driver;
	public LoginTest(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(id="userEmail")
	WebElement userid;
	
	@FindBy(id="userPassword")
	WebElement pass;
    
	@FindBy(id="login")
	WebElement login;
	
	public void login(String userid, String pass)
	{
	 this.userid.sendKeys(userid);
	 this.pass.sendKeys(pass);
	 login.click();
	}
	
	public void go() {
		  driver.get("https://rahulshettyacademy.com/client/");

	}
	
	
	
}
