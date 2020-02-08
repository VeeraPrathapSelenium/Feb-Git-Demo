package com.commonutils;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.excelplugin.ExcelParser;
import com.readproperties.ReadProperties;

public class CommonUtils extends ExcelParser {
	
	
	
	public static WebDriver driver;
	public ReadProperties properties;
	public Properties property;
	
	/**
	 * method name:launchBrowser
	 * Description: This method is used to launch teh browser specified by the user
	 * input parameter: String browsertype, String url
	 * output parameter:boolean status
	 */
	
	
	public boolean launchBrowser()
	{
		boolean status=true;
		
		String browserType="";
		String url="";
		
		
		try {
			
			if(properties==null) {
				properties =new ReadProperties();
				property=properties.getConfigFile();
			}
			
			//get environment
			String environment=property.getProperty("ENVIRONMENT");
			
			switch(environment.toLowerCase()) {
			
			case "qa":
				url=property.getProperty("QA_URL");
				break;
			case "uat":
				url=property.getProperty("UAT_URL");
				break;
			case "int":
				url=property.getProperty("INT_URL");
				break;
				
			}			
			//create a switch case which can take any browserTyep
			browserType=property.getProperty("BROWSER");
			System.out.println("Launching the browser :"+browserType );
			
			switch(browserType.toLowerCase()) {
			
			
			case "chrome":
				//set teh chrome driver path
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				
				driver=new ChromeDriver();
				break;
			case "ff":
				//set the ff driver path
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				
				driver=new FirefoxDriver();
				break;	
				
			
			
			}
		// regardless of browser type, user must pass an url and maximize it accordingly	
			
			driver.get(url);
			driver.manage().window().maximize();	
			System.out.println("Browser :"+browserType +" is launched sucessfully");
			logEvent("Pass", "Browser :"+browserType +" is launched sucessfully");
		}catch(Exception e)
		{
			status=false;
			System.out.println("Error occure while launching the browser :"+browserType );
			System.out.println(e.getMessage());
			logEvent("Fail", "Error occure while launching the browser :"+browserType );
		}
		
		return status;
		
		
	}
	
	/**
	 * method name:closeBrowser
	 * Description: This method is used to close browser
	 * input parameter: NA
	 * output parameter:boolean status
	 */
	
	public boolean closeBrowser() {
		System.out.println("Tryingto close the browser..!!");
		boolean status=true;
		try {
			driver.close();
			System.out.println("Browser closed  sucessfully");
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to close the Browser");
		}		
		
		return status;
		
	}
	
	
	/**
	 * method name:quitDriverSession
	 * Description: This method is used to close browser
	 * input parameter: NA
	 * output parameter:boolean status
	 */
	
	public boolean quitDriverSession() {
		System.out.println("Trying to quit driver object..!!!");
		boolean status=true;
		try {
			driver.quit();
			System.out.println("Driver object killed successfully");
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to kill driver object");
		}		
		
		return status;
		
	}
	
	
	/**
	 * method name:clickAndSendData
	 * Description: This method is used to click,clear and send the data
	 * input parameter: String elementName,String pageName,WebElement element,String data
	 * output parameter:boolean status
	 */
	
	public boolean clickAndSendData(String elementName,String pageName,WebElement element,String data) {
		System.out.println("Trying to send the data to the element "+elementName+" on the page "+pageName);
		boolean status=true;
		try {
			element.click();
			element.clear();
			element.sendKeys(data);
			System.out.println("Data is sent successfully for the element "+elementName+" on the page "+pageName);
			logEvent("Pass", "Data is sent successfully for the element "+elementName+" on the page "+pageName);
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to send the data to the element "+elementName+" on the page "+pageName);
			System.out.println(e.getMessage());
			logEvent("Fail", "Unable to send the data to the element "+elementName+" on the page "+pageName);
		}		
		
		return status;
		
	}
	
	/**
	 * method name:hoverAndClick
	 * Description: This method is used to hover and then click
	 * input parameter: String elementName,String pageName,WebElement element
	 * output parameter:boolean status
	 */
	
	public boolean hoverAndClick(String elementName,String pageName,WebElement element) {
		Actions action=new Actions(driver);
		
		
		System.out.println("Trying to hovern and click on the  element "+elementName+" on the page "+pageName);
		boolean status=true;
		try {
					
			action.moveToElement(element).click(element).build().perform();
			System.out.println("Element "+elementName+" is clicked on the page "+pageName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to click the element "+elementName+" on the page "+pageName);
			System.out.println(e.getMessage());
		}		
		
		return status;
		
	}
	
	
	
	
	/**
	 * method name:waitForVisible
	 * Description: This method is used to hover and then click
	 * input parameter: String elementName,String pageName,WebElement element
	 * output parameter:boolean status
	 */
	
	public boolean waitForVisible(String elementName,String pageName,WebElement element,int seconds) {
		
		System.out.println("Trying to identify the  element "+elementName+" on the page "+pageName);
		boolean status=true;
		try {
				System.out.println(element==null);	
			WebDriverWait wait=new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("Element "+elementName+" is identified on the page "+pageName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to indentify the element "+elementName+" on the page "+pageName+" With in the seconds :"+seconds);
			System.out.println(e.getMessage());
		}		
		
		return status;
		
	}
	

	/**
	 * method name:waitForInVisible
	 * Description: This method is used to hover and then click
	 * input parameter: String elementName,String pageName,WebElement element
	 * output parameter:boolean status
	 */
	
	public boolean waitForInVisible(String elementName,String pageName,WebElement element,int seconds) {
		
		System.out.println("Trying to identify the  disaaperead of element "+elementName+" on the page "+pageName);
		boolean status=true;
		try {
					
			WebDriverWait wait=new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.invisibilityOf(element));
			System.out.println("Element "+elementName+" is disaapered on the page "+pageName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to indentify the element "+elementName+" on the page "+pageName+" With in the seconds :"+seconds);
			System.out.println(e.getMessage());
		}		
		
		return status;
		
	}
	

	/**
	 * method name:waitForClicklable
	 * Description: This method is used to hover and then click
	 * input parameter: String elementName,String pageName,WebElement element
	 * output parameter:boolean status
	 */
	
	public boolean waitForClicklable(String elementName,String pageName,WebElement element,int seconds) {
		
		System.out.println("Trying to identify the  of element to be clickable "+elementName+" on the page "+pageName);
		boolean status=true;
		try {
					
			WebDriverWait wait=new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("Element "+elementName+" is Clickable on the page "+pageName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to indentify the element "+elementName+" on the page "+pageName+" With in the seconds :"+seconds);
			System.out.println(e.getMessage());
		}		
		
		return status;
		
	}
	
	
	/**
	 * method name:selectByVisisbleText
	 * Description: This method is used to hover and then click
	 * input parameter: String elementName,String pageName,WebElement element
	 * output parameter:boolean status
	 */
	
	public boolean selectByVisisbleText(String elementName,String pageName,WebElement element,String value) {
		
		System.out.println("Trying to select the  of element by visisble text "+elementName+" on the page "+pageName);
		boolean status=true;
		try {
			Select select=new Select(element);
			
			select.selectByVisibleText(value);		
			
			System.out.println("Element "+elementName+" is Selected With the value :"+value+" on the page "+pageName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to select the element "+elementName+" on the page "+pageName+" With in the value :"+value);
			System.out.println(e.getMessage());
		}		
		
		return status;
		
	}
	
	/**
	 * method name:selectByValue
	 * Description: This method is used to hover and then click
	 * input parameter: String elementName,String pageName,WebElement element
	 * output parameter:boolean status
	 */
	
	public boolean selectByValue(String elementName,String pageName,WebElement element,String value) {
		
		System.out.println("Trying to select the  of element by value "+elementName+" on the page "+pageName);
		boolean status=true;
		try {
			Select select=new Select(element);
			
			select.selectByValue(value);		
			
			System.out.println("Element "+elementName+" is Selected With the value :"+value+" on the page "+pageName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to select the element "+elementName+" on the page "+pageName+" With in the value :"+value);
			System.out.println(e.getMessage());
		}		
		
		return status;
		
	}
	
	/**
	 * method name:selectByIndex
	 * Description: This method is used to hover and then click
	 * input parameter: String elementName,String pageName,WebElement element
	 * output parameter:boolean status
	 */
	
	public boolean selectByIndex(String elementName,String pageName,WebElement element,int value) {
		
		System.out.println("Trying to select the  of element by index "+elementName+" on the page "+pageName);
		boolean status=true;
		try {
			Select select=new Select(element);
			
			select.selectByIndex(value);		
			
			System.out.println("Element "+elementName+" is Selected With the value :"+value+" on the page "+pageName);
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to select the element "+elementName+" on the page "+pageName+" With in the value :"+value);
			System.out.println(e.getMessage());
		}		
		
		return status;
		
	}
	
	/**
	 * method name:ElementDisplayed
	 * Description: This method is used to hover and then click
	 * input parameter: String elementName,String pageName,WebElement element
	 * output parameter:boolean status
	 */
	
	public boolean ElementDisplayed(String elementName,String pageName,WebElement element) {
		
		System.out.println("Trying to verify if the element"+elementName+" is displayed on the page "+pageName);
		boolean status=true;
		try {
			status=waitForVisible(elementName, pageName, element, 85);
			if(status)
			{
				if(element.isDisplayed())
				{
					logEvent("Pass", "Element :"+elementName+" is displayed on the page "+pageName);
				}else
				{
					logEvent("Fail", "Element :"+elementName+" is not displayed on the page "+pageName);
				}
			}else {
				logEvent("Fail", "Element :"+elementName+" is not displayed on the page "+pageName);
			}
			
		}catch(Exception e)
		{
			status=false;
			System.out.println("Unable to identify the element "+elementName+" on the page "+pageName);
			System.out.println(e.getMessage());
			logEvent("Fail", "Unable to identify the element "+elementName+" on the page "+pageName);
			logEvent("info", e.getMessage());
		}		
		
		return status;
		
	}
	
	
	
}
