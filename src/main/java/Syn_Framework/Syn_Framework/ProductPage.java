package Syn_Framework.Syn_Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends Reusablefun {
	
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}

	@FindBy(xpath="//div[contains(@class, 'mb-3')]/div/div/h5/b")
	List<WebElement> product;
	
	@FindBy(xpath = "//div[contains(@class, 'mb-3')]/div/div/button[@class='btn w-10 rounded']")
	WebElement cart;
	
	@FindBy(css = ".ng-animating")
	WebElement loader;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement addtocart;
	
	By pro = By.xpath("//div[contains(@class, 'mb-3')]/div/div/h5/b");
	By cartv = By.xpath("//div/div/button[@class='btn w-10 rounded']");
	By note = By.cssSelector("#toast-container");
	public List<WebElement> prolist()
	{
	   elementvisible(pro);	
	   return product;
	}
	
   public void getproname(String productname) throws InterruptedException
   {
	   for(int i=0; i<prolist().size(); i++)
		 {
		       
			 
			  System.out.println(prolist().get(i).getText());		  
			  if(prolist().get(i).getText().equalsIgnoreCase(productname))
			  {
				 
				  elementvisible(cartv);
				  cart.click();
			  }		
			  	  
		 }
	   elementvisible(note);
	   elementinvisible();
	   addtocart.click();
	   
   }
	
	
	
}
