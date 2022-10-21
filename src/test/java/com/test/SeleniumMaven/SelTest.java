package com.test.SeleniumMaven;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.annotation.DisableHealing;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;



public class SelTest {
	static SelfHealingDriver driver;
	
	@BeforeSuite
	
	static public void setUp() throws MalformedURLException{
		 //Launch firefox browser 
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\josue\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver delegate = new FirefoxDriver(); 
		driver =   SelfHealingDriver.create(delegate);
	    
	    //maximize the browser
	    driver.manage().window().maximize();
	   
	}

	 @Test
	    @Description("xpath")
	    public void xpath(){
	      driver.get("https://elenastepuro.github.io/test_env/index.html");  
	      driver.findElement(By.xpath("//input[@id='change:name']")).click();
	      driver.findElement(By.id("Submit")).click();
	      driver.findElement(By.xpath("//input[@id='change:name']")).click();
	       
	    }
	 
	 @Test
	    @Description("xpath contains")
	    public void xpathContains(){
	      driver.get("https://elenastepuro.github.io/test_env/index.html");  
	      driver.findElement(By.xpath("//input[contains(@class, 'test')]")).click();
	      driver.findElement(By.id("Submit")).click();
	      driver.findElement(By.xpath("//input[contains(@class, 'test')]")).click();
	       
	    }
	 
	 @Test
	    @Description("using css")
	    public void css(){
	      driver.get("https://elenastepuro.github.io/test_env/index.html");  
	      driver.findElement(By.cssSelector("#change_id")).click();
	      driver.findElement(By.id("Submit")).click();
	      driver.findElement(By.cssSelector("#change_id")).click();
	       
	    }
	 
	 @Test
	 
	    @Description("xpath nop healing")
	    public void xpathDisabled(){
	      driver.get("https://elenastepuro.github.io/test_env/index.html");  
	      driver.findElement(By.xpath("//input[@id='change:name']")).click();
	      driver.findElement(By.id("Submit")).click();
	      driver.findElement(By.xpath("//input[@id='change:name']")).click();
	       
	    }
	 
	 @Test
	 
	    @Description("xpath nop healing")
	    public void xpathContainsDisabled(){
	      driver.get("https://elenastepuro.github.io/test_env/index.html");  
	      driver.findElement(By.xpath("//input[contains(@class, 'test')]")).click();
	      driver.findElement(By.id("Submit")).click();
	      driver.findElement(By.xpath("//input[contains(@class, 'test')]")).click();
	       
	    }
	   
	 
	 @Test
	    @Description("using css with no healing")
	 
	    public void cssDisabled(){
	      driver.get("https://elenastepuro.github.io/test_env/index.html");  
	      driver.findElement(By.cssSelector("#change_id")).click();
	      driver.findElement(By.id("Submit")).click();
	      driver.findElement(By.cssSelector("#change_id")).click();
	       
	    }

	
	 
	
	
	@AfterSuite
	public void close() {
		driver.quit();
	}
}