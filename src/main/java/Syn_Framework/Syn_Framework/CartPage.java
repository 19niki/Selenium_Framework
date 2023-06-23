package Syn_Framework.Syn_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage extends Reusablefun {
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy (xpath = "//div[@class='cartSection']/h3")
	 WebElement itemsel;
	
     @FindBy (xpath = "//div/ul/li/button")
      WebElement checkout;		
	 

public String verifypronaame() {
	
	String itemname = itemsel.getText();	
	return itemname;
	
}
 
public void movecheck()
{
    checkout.click();	
}

}