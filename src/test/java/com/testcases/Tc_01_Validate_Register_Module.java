package com.testcases;

import org.testng.annotations.Test;
import org.testng.xml.LaunchSuite;

import com.annotations.Annotations;
import com.pagebehaviours.HomePage;
import com.pagebehaviours.JobSeekerRegistration;

public class Tc_01_Validate_Register_Module extends Annotations{
	
	@Test
	public void Tc_01_Validate_Register_Module()
	{
	HomePage homepage=HomePage.getInstance();	
	launchBrowser();
	homepage.verify_RegisterLink_Display();
	homepage. click_RegisterLink();
	
	
	JobSeekerRegistration jobseeker=JobSeekerRegistration.getInstance();
	jobseeker.fillPersonalInformation();
		
	}
	

	

}
