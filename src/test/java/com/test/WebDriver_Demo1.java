package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class WebDriver_Demo1 {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver = TestNG_1.getDriver("chrome");
	  String url = "https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx";
	  driver.manage().window().maximize();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  WebElement a = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_RadTreeView1\"]/ul/li/ul/li[3]/ul/li[2]/div/div/span"));
	  WebElement b = driver.findElement(By.xpath("//*[@id=\"ctl00_ContentPlaceholder1_priceChecker\"]/div[1]"));
	  Actions act1 = new Actions(driver);
	  act1.dragAndDrop(a, b).perform();;
	  Thread.sleep(5000);
	  String price = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
	  System.out.println("The price of the trip is "+price);
  }
}
