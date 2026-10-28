package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.LoginPage;

public class LogintestBase extends BaseTest {

	@Test
	public void verifyLogin() {
		LoginPage loginpage = new LoginPage();
		loginpage.clickLogin();
		loginpage.enteremail("rajkori@gmail.com");
		loginpage.enterpass("Test@123");
		loginpage.selectcheckbox();
		loginpage.submit();
		
		String loggedUser = loginpage.getLoggedInUserEmail();
		Assert.assertEquals(loggedUser, "rajkori@gmail.com", "User Login Test failed!");
	}
}