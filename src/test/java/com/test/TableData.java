package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TableData {
  @Test
  public void f() {
	  WebDriver driver = TestNG_1.getDriver("chrome");
	  String url = "http://10.232.237.143:443/TestMeApp/fetchcat.htm";
	  driver.manage().window().maximize();
	  driver.get(url);
	  driver.findElement(By.linkText("SignIn")).click();
	  driver.findElement(By.id("userName")).sendKeys("Lalitha");
	  driver.findElement(By.id("password")).sendKeys("password123");
	  driver.findElement(By.name("Login")).click();
	  driver.findElement(By.xpath("//a[@href='fetchorder.htm']")).click();
	  WebElement objtable = driver.findElement(By.xpath("//table[@class='table']"));
	  List<WebElement> Allrows = objtable.findElements(By.tagName("tr"));
	  for (int n=1;n<Allrows.size();n++) {
		  List<WebElement> cells = Allrows.get(n).findElements(By.tagName("td"));
		  System.out.println("Order ID: "+cells.get(0).getText());
		  System.out.println("Date of Order: "+cells.get(2).getText());
	  }
	  driver.close();
  }
}
