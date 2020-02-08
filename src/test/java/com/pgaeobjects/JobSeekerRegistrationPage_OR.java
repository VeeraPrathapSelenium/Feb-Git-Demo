package com.pgaeobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobSeekerRegistrationPage_OR {

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder2_txtfirstname']")

	public WebElement edi_FirstName;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder2_txtlastname']")

	public WebElement edi_LastName;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder2_txtemail']")

	public WebElement edi_Email;

	@FindBy(xpath = "//input[@id='ctl00_ContentPlaceHolder2_txtmobile']")

	public WebElement edi_ContectNumber;

	@FindBy(xpath = "//input[@id= 'ctl00_ContentPlaceHolder2_txtLandlineNo']")

	public WebElement edi_LandLine;

	@FindBy(xpath = "//input[@id= 'ctl00_ContentPlaceHolder2_txtpwd']")

	public WebElement edi_PassWord;

	@FindBy(xpath = "//input[@id= 'ctl00_ContentPlaceHolder2_txtconfirmpwd']")

	public WebElement edi_ConfirmPassWord;

	@FindBy(xpath = "//input[@id= 'ctl00_ContentPlaceHolder2_txtlanguagesKnown']")

	public WebElement edi_Language;

}
