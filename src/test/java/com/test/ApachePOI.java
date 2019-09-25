package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mongodb.diagnostics.logging.Logger;

public class ApachePOI {
  @Test
  public void f() throws IOException {
	  File src = new File("C:\\Users\\training_b6b.01.16\\Desktop\\TestData.xlsx");
	  FileInputStream fis = new FileInputStream(src);
	  XSSFWorkbook WB = new XSSFWorkbook(fis);
	  XSSFSheet SH = WB.getSheetAt(0);
	  System.out.println("First Row Number "+SH.getFirstRowNum());
	  System.out.println("Last Row Number "+SH.getLastRowNum());
	  int rowcount = SH.getLastRowNum()-SH.getFirstRowNum();
	  System.out.println("The rowcount is "+rowcount);
	  for(int i=1;i<=rowcount;i++) {
		  System.out.println(SH.getRow(i).getCell(0).getStringCellValue()+"\t \t \t"+SH.getRow(i).getCell(1).getStringCellValue());
		  WebDriver driver = TestNG_1.getDriver("chrome");
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  driver.manage().window().maximize();
		  driver.findElement(By.linkText("SignIn")).click();
		  driver.findElement(By.name("userName")).sendKeys(SH.getRow(i).getCell(0).getStringCellValue());
		  driver.findElement(By.name("password")).sendKeys(SH.getRow(i).getCell(1).getStringCellValue());
		  driver.findElement(By.name("Login")).click();
		  driver.close();
	  }
	  XSSFRow header = SH.getRow(0);
	  XSSFCell header2 = header.createCell(2);
	  header2.setCellValue("Status");
	  SH.getRow(1).createCell(2).setCellValue("Pass");
	  SH.getRow(2).createCell(2).setCellValue("Fail");
	  FileOutputStream fos = new FileOutputStream(src);
	  WB.write(fos);
  }
}
