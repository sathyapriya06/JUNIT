package com.flipcart.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonMobiles { 
	static WebDriver driver;
	static long startTime;
	
	
	@BeforeClass
	public static void browserlaunch() {
		System.out.println("Launch browser");
		WebDriverManager.chromedriver().setup();
		
		driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/");
		
		
	}
@AfterClass
 
 public static void browserquit() {
	System.out.println("quit browser");
	driver.close();
	
}
	@Before
	public void beforeMethod() {
		System.out.println("before method");
		startTime = System.currentTimeMillis();
	}
	
	@After
	
	public void afterMethod() {
		System.out.println("After method");
		startTime = System.currentTimeMillis();
		
	}
	static String name;
	static String name2;
	@Test
	public void method1() {
		 System.out .println("login method -1");
		  WebElement userText= driver.findElement(By.id("twotabsearchtextbox"));
		 userText.sendKeys("iphone",Keys.ENTER);
		 WebElement iphonename= driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone')])[1]"));
		name=iphonename.getText();
		 System.out.println("expected Mobilepage1:"+name);
		 iphonename.click();
	}
	
	
	@Test
	public void method2() {
		 
		 System.out.println(" method - 3");
			String parent = driver.getWindowHandle();
			Set<String> child= driver.getWindowHandles();
			for (String x : child) {
				if(!x.equals(parent)){
					driver.switchTo().window(x);
	
	
				}
				
			}		
				 WebElement iphonename2= driver.findElement(By.id("productTitle"));
				    name2 =iphonename2.getText();
					 System.out.println("expected Mobilepage2:"+name2);
					 iphonename2.click();
					 
}	
	
	@Test
	

	public void method3() {
		boolean equals = name.equals(name2);
	System.out.println(equals);
	
	}
	@Test
	public void method4() throws Exception {
		System.out.println("screenshot method 4");
		TakesScreenshot tk =(TakesScreenshot)driver;
		File souc=tk.getScreenshotAs(OutputType.FILE);
		File dest= new File(".//target//report1.png1");
		FileUtils.copyFile(souc, dest);
	}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	

