package Syn_Framework.Syn_Framework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class ProductTest {
	
	 WebDriver driver;
  @Test(dataProvider = "data")
  public void login(HashMap<String, String> input) {
	  ChromeOptions op;
		
	  op = new ChromeOptions();
	  op.addArguments("start-maximized");
	// op.addArguments("-headless");
	  driver = new ChromeDriver(op);
	  LoginTest lt = new LoginTest(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  String item = "ZARA COAT 3";
	  driver.get("https://rahulshettyacademy.com/client/");
	  driver.findElement(By.id("userEmail")).sendKeys(input.get("email"));
	  driver.findElement(By.id("userPassword")).sendKeys(input.get("pass"));
	  driver.findElement(By.id("login")).click();
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'mb-3')]/div/div/h5/b")));
	  List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]/div/div/h5/b"));
	  
	 for(int i=0; i<products.size(); i++)
	 {
	       
		 
		  System.out.println(products.get(i).getText());		  
		  if(products.get(i).getText().equalsIgnoreCase("ZARA COAT 3"))
		  {
			 
			  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/button[@class='btn w-10 rounded']")));
			  driver.findElement(By.xpath("//div[contains(@class, 'mb-3')]/div/div/button[@class='btn w-10 rounded']")).click();
			  	  }		
		  	  
	 }
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	  driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
	  
	  String itemsel = driver.findElement(By.xpath("//div[@class='cartSection']/h3")).getText();
	  
	  Assert.assertTrue(itemsel.matches(item));
	  
	  driver.findElement(By.xpath("//div/ul/li/button")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")));
	   driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
	   
	   try
	   {
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-star-inserted']")));
	   List<WebElement> drop = driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
	   
	   
	   for(WebElement w:drop)
	   {
		   if(w.getText().equalsIgnoreCase("India"))
		   {
			   w.click();
		   }
	   }
	   }
	   catch (Exception e) {
			// TODO: handle exception
		}
	   
	   driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
       String confirm = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
       System.out.println(confirm);
       Assert.assertTrue(confirm.equalsIgnoreCase("Thankyou for the order."));
	   //<h1 _ngcontent-pte-c39="" class="hero-primary" style="text-transform: uppercase; font-size: 28px; color: #283375; margin-top: 9px;"> Thankyou for the order. </h1>
	 driver.quit();
	  
  }
  @DataProvider
  public Object[][] data()
  {
	 
	  HashMap<String, String> map = new HashMap<>();
	  map.put("email","nikhilravi9847@gmail.com");
	  map.put("pass", "1DA@17mca");
	  
	  return new Object[][] {{map}};
  }
  
  public File getscreenshot(String test) throws IOException
  {
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File des = new File (System.getProperty("user.dir")+ "//reports//" + test +".png");
	  Files.copy(src, des);
	  return des;
	  
	  
  }
}
