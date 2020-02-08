package com.pgaeobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_OR {
	//****************  Home Page Menu Links **********************
	
	@FindBy(xpath="//span[@id='lnkRegistration']")
	public WebElement lnl_Register;
	
	@FindBy(xpath="//span[@id='lblJsRegister']")
	public WebElement lnk_JobSeeker;
	

}
