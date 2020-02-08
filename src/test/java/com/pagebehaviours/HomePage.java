package com.pagebehaviours;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.commonutils.CommonUtils;
import com.pgaeobjects.HomePage_OR;

public class HomePage extends CommonUtils {
	
	public static HomePage_OR homepage_or;
	public static HomePage homepage;
	
	private HomePage() {
		
		System.out.println("Object is created for HomePage");		
		
	}
	public static HomePage  getInstance() {
		if(homepage==null) {
			homepage=new HomePage();
			
		}
		return homepage;
	}
	
	
	//******************* Web Page Behaviours ************************
	
	public void verify_RegisterLink_Display() {
		homepage_or= PageFactory.initElements(driver, HomePage_OR.class);
		boolean status=ElementDisplayed("Regiter Link","Home",homepage_or.lnl_Register);
		Assert.assertEquals("Verify Register Link is displayed","true", String.valueOf(status));
		
	}

	public void click_RegisterLink() {
		homepage_or= PageFactory.initElements(driver, HomePage_OR.class);
		hoverAndClick("Register", "Home", homepage_or.lnl_Register);
		boolean status=hoverAndClick("Register", "Home", homepage_or.lnk_JobSeeker);
		Assert.assertEquals("Verify Register Link is displayed","true", String.valueOf(status));
		
	}
	
	
	
	

}
