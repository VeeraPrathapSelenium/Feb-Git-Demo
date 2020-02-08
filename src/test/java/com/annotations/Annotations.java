package com.annotations;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.commonutils.CommonUtils;
import com.excelplugin.ExcelParser;
import com.readproperties.ReadProperties;
import com.reporting.Reporting;

public class Annotations extends CommonUtils{
	
	public static ExcelParser exlparser;
	public static  Reporting report;
	
	
	
	@BeforeSuite
	
	public void beforeSuite()
	{
		System.out.println("Before Suite..!!!");
		
		//Loading excel File
		 exlparser=new ExcelParser();
		exlparser.loadExcel();
		
		//Loading properties file
		ReadProperties properties=new ReadProperties();
		properties.getConfigFile();
		
		//intiliaze extent reports
		 report=new Reporting();
		report.intializeReport();
		
		
	}
	
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite...!!!");
        report.flushReport();
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test...!!!");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("After Test...!!!");
	}
	
	
	@BeforeMethod
	public void beforeMethod(Method m) {
		System.out.println("Before Method...!!!");
		System.out.println("The current Test Case :"+m.getName());
		ExcelParser.testcasename=m.getName();
		report.startReport(m.getName());
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method...!!!");
        report.endTest();
	}
	

}
