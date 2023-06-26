package Syn_Framework.Syn_Framework;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProTest extends BaseTest {
	 
  @Test(dataProvider = "data")
  public void login(HashMap<String, String> input) throws InterruptedException, IOException {
	 
	  
	  WebDriver driver  = startdriver();
	  String item = "ZARA COAT 3";
	  LoginTest lt = new LoginTest(driver);
	  lt.go();
	  lt.login(input.get("email"),input.get("pass"));
	  
	  ProductPage p = new ProductPage(driver);
	  List<WebElement> products = p.prolist();
	  p.getproname(item);  
	  CartPage cp = new CartPage(driver);
	  String itemsel = cp.verifypronaame();
	  System.out.println(itemsel);
	  System.out.println(item);
	  Assert.assertTrue(itemsel.matches(item));
	  cp.movecheck();

	  Checkoutpage c = new Checkoutpage(driver);
	 
	  List<WebElement> drop = c.checkout("India");
	  for(WebElement w:drop)
	   {
		   if(w.getText().equalsIgnoreCase("India"))
		   {
			   w.click();
			   driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
		   }
	   }
	  
	 	         
       String confirm = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
       System.out.println(confirm);
       Assert.assertTrue(confirm.equalsIgnoreCase("Thankyou for the order."));
	  
	 
	  
  }
  
  @DataProvider
  public Object[][] data()
  {
	 
	  HashMap<String, String> map = new HashMap<>();
	  map.put("email","nikhilravi9847@gmail.com");
	  map.put("pass", "1DA@17mca");
	  
	  return new Object[][] {{map}};
  }
  
}
