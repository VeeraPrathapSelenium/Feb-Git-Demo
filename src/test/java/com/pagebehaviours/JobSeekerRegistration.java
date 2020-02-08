package com.pagebehaviours;

import org.openqa.selenium.support.PageFactory;

import com.commonutils.CommonUtils;
import com.pgaeobjects.HomePage_OR;
import com.pgaeobjects.JobSeekerRegistrationPage_OR;

public class JobSeekerRegistration extends CommonUtils{
public static JobSeekerRegistration jobseeker;	
public static JobSeekerRegistrationPage_OR jobseekerOr;
	
private JobSeekerRegistration() {
		
		System.out.println("Object is created for JobSeekerRegistration");		
		
	}
	public static JobSeekerRegistration  getInstance() {
		if(jobseeker==null) {
			jobseeker=new JobSeekerRegistration();
			
		}
		return jobseeker;
	}
	
	
	
	public void fillPersonalInformation() {
		
		jobseekerOr= PageFactory.initElements(driver, JobSeekerRegistrationPage_OR.class);
		//FirstName
		String firstname=getData("TestData",1,"FirstName");
		clickAndSendData("First Name", "Job seeker - Personal Info", jobseekerOr.edi_FirstName, firstname);
		
		//Last Name
				String lastName=getData("TestData",1,"LastName");
				clickAndSendData("Last Name", "Job seeker - Personal Info", jobseekerOr.edi_LastName, lastName);
				
		
				//Email
				String email=getData("TestData",1,"Email");
				clickAndSendData("Email", "Job seeker - Personal Info", jobseekerOr.edi_Email, email);
				
				//Contact
				String contact=getData("TestData",1,"Contact");
				clickAndSendData("Contact", "Job seeker - Personal Info", jobseekerOr.edi_ContectNumber, contact);
				
				//password
		
	}
	
	
	
	

}
