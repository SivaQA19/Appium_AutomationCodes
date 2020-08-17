package com.Project.Proj_1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstScript {
	
	
	    @Test
		public void testRun() throws InterruptedException
		 {
			
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ("//Drivers//chromedriver.exe"));
		 
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://www.amazon.in/");
		 
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung");
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
	     driver.findElement(By.xpath("//span[text()='Dual SIM']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//span[text()='GSM']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//span[text()='Android']")).click();
		 Thread.sleep(5000);
		//select the product
		
	  driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		
	  //method1
	 /* 
	  String parentWindow=driver.getWindowHandle();
	  Set<String> allWindows=driver.getWindowHandles();
	  
	  for(String childWindow: allWindows)
	  {
		  
		  if(!parentWindow.equalsIgnoreCase(childWindow)) {
		  driver.switchTo().window(childWindow);
		  driver.findElement(By.xpath("//input[@id='mbb-offeringID-1']")).click();
		  Thread.sleep(4000);
		  driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		  Thread.sleep(4000);
		  } 
	  }  
		  
		  driver.switchTo().window(parentWindow);
	      driver.quit();
	      */
	  
	     //method2
	      
	      String parentWindow=driver.getWindowHandle();
	      Set<String> allWindows=driver.getWindowHandles();
	      Iterator<String> ite=allWindows.iterator();
	      {
	    	  while(ite.hasNext())
	    	  {
	    	  String child1=ite.next();
	    	  if(!parentWindow.equalsIgnoreCase(child1)) {
	    	  driver.switchTo().window(child1);
	    	  System.out.println(driver.switchTo().window(child1).getTitle());
	    	  driver.findElement(By.xpath("//input[@id='mbb-offeringID-1']")).click();
	    	  Thread.sleep(4000);
	    	  driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"));
	    	  Thread.sleep(4000);
	    	  } 
	       }  
	     }  
	    	  driver.switchTo().window(parentWindow);
	          driver.quit();    
		  
  }

}
