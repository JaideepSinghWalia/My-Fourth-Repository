package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class TestNG_1 {
  @Test
  public static WebDriver getDriver(String browser) {
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6b.01.16\\Desktop\\Browser Drivers\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
			}
		else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\training_b6b.01.16\\Desktop\\Browser Drivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else {
		return null;
	  }
}
}
