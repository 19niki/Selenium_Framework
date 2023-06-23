package Syn_Framework.Syn_Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutpage extends Reusablefun {

	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);

		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath = "//span[@class='ng-star-inserted']")
	List<WebElement> countrylist;
	
	@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
	WebElement checkbtn;
	
	By button = By.xpath("//a[@class='btnn action__submit ng-star-inserted']");
	By cunlist = By.xpath("//span[@class='ng-star-inserted']");
	public List<WebElement> checkout(String country) throws InterruptedException
	{
		elementvisible(button);
	    this.country.sendKeys(country);
	    elementvisible(cunlist);
	    Thread.sleep(5000);		    	
	    
	    return countrylist;
	}
    
	public void clickcheckbtn() throws InterruptedException {
		
		elementvisible(button);
		
		try {
		checkbtn.click();
		}
		 catch (Exception e) {
				
			}
	}

}
