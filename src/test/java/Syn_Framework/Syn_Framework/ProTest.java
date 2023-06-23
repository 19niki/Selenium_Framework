package Syn_Framework.Syn_Framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProTest {
	 
  @Test
  public void login() throws InterruptedException {
	 
      ChromeOptions op = new ChromeOptions();
	  op.addArguments("start-maximized");
	  System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver(op);
	  LoginTest lt = new LoginTest(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  String item = "ZARA COAT 3";
	  lt.go();
	  lt.login("nikhilravi9847@gmail.com","1DA@17mca");
	  
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
	   //<h1 _ngcontent-pte-c39="" class="hero-primary" style="text-transform: uppercase; font-size: 28px; color: #283375; margin-top: 9px;"> Thankyou for the order. </h1>
	 driver.quit();
	 
	  
  }
}
