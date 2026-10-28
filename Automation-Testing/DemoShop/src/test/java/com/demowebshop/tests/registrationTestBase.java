package com.demowebshop.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.demoweb.shop.pages.RegistrationPage;


public class registrationTestBase extends BaseTest{

	@Test
	public void verifyuserregistration()
	{
		RegistrationPage registerpage=new RegistrationPage();
		
		registerpage.clickregisterHeaderLink();
		registerpage.selectGender("male");
		registerpage.enterFirstName("Raj");
		registerpage.enterLastNAme("kori");
		
		String uniqueEmail="rajkori"+System.currentTimeMillis()+"@gmail.com";
		registerpage.enterEmail(uniqueEmail);
		
		registerpage.enterPass("Test@123");
		registerpage.entercnfPass("Test@123");
		registerpage.clickregi();
		
		String actualmessage=registerpage.getMess();
		String expectedmessage = "Your registration completed";
		
		Assert.assertEquals(actualmessage, expectedmessage,"User Registration Test failed!");
	}
}
