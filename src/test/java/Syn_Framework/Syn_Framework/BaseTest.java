package Syn_Framework.Syn_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;

public class BaseTest {

	 WebDriver driver;

	public WebDriver startdriver() throws IOException
	{
		
				Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Syn_Framework\\Global.Properties");
		pro.load(fis);
		String browsername = pro.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
		ChromeOptions op = new ChromeOptions();
		  op.addArguments("start-maximized");
		  System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");
		  driver = new ChromeDriver(op);
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			EdgeOptions op = new EdgeOptions();
			  op.addArguments("start-maximized");
			 // System.setProperty("webdriver.chrome.driver", "E:\\Software\\Selenium\\chromedriver.exe");
			   driver = new EdgeDriver(op);
		}
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;
		
	}
	
   @AfterTest
   public void teardown() {
   driver.quit();
}
}