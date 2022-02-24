package com.flipcart.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartMobiles { 
	static long startTime;
	static WebDriver driver;
	
	@BeforeClass
	public static void browserlaunch() {
		System.out.println("Launch browser");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
}
   @AfterClass
   public static void browserquit() {
	   System.out .println("browser quit");
	   driver.close();
	   
   }
   @Before
   public void beforeMethod() {
	   System.out .println("before method");
	  startTime = System.currentTimeMillis();
   }

	@After
	public void afterMethod() {
		  System.out .println("before method");
		  long  endTime = System.currentTimeMillis();
		  System.out.println("Time Taken is:"+(endTime - startTime));
		
	}
	
	
	
	@Test
	public void method1() {
		 System.out .println("login method -1");
		 
			 
			 WebElement userClk= driver.findElement(By.xpath("//button[text()='✕']"));
			 userClk.click();
		 
		 }
		static String name;
		static String name2;
	
		@Test
		public void method2() throws Exception{
			 System.out .println("login method -2");
			  WebElement userText= driver.findElement(By.name("q"));
			 userText.sendKeys("realme",Keys.ENTER);
			 WebElement mobilename= driver.findElement(By.xpath("(//div[contains(text(),'realme')])[2]"));
			 name=mobilename.getText();
			 System.out.println("expected Mobilepage1:"+name);
			 mobilename.click();
			 
		
			
			
	}
		@Test
		
		public void method3() {
			 
				 System.out.println(" method - 3");
					String parent = driver.getWindowHandle();
					Set<String> child= driver.getWindowHandles();
					for (String x : child) {
						if(!x.equals(parent)){
							driver.switchTo().window(x);
		}
		
}
					
				 WebElement mobileName2 = driver.findElement(By.xpath("(//span[contains(text(),'realme')])[1]"));
					 name2 = mobileName2.getText();
					System.out.println("expected Mobilepage2:"+name2);
					mobileName2.click();
		}
		

		@Test
          public void method4() {                      
				            
		boolean equals = name.equals(name2);
		System.out.println(equals);
		}

     @Test
     public void method5() throws Exception {
    	 System.out.println("screenshot method - 5");
    	 TakesScreenshot tk = (TakesScreenshot)driver;
    	 File sourc = tk.getScreenshotAs(OutputType.FILE);
    	 File dest = new File(".//target//report.png");
    	 FileUtils.copyFile(sourc, dest);
     }
     }
     

  
























		
		
