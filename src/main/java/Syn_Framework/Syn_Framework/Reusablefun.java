package Syn_Framework.Syn_Framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusablefun {

	WebDriver driver;
	public Reusablefun(WebDriver driver) {
		this.driver=driver;
		}

	public void elementvisible(By find)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		  wait.until(ExpectedConditions.visibilityOfElementLocated(find));
	
	}
	public void elementinvisible() throws InterruptedException
	{
		Thread.sleep(1000);
		/*
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		 wait.until(ExpectedConditions.invisibilityOf(find));*/
	}
	
}
