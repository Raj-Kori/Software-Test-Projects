package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.LoginPage;

public class LoginTest extends BaseTest {

	@DataProvider(name = "loginTestcasesProvider")
	public Object[][] getLoginTestData()
	{
		return new Object[][]
		{
			{"TC_27", "rajkori@gmail.com", "Test@123", true, "rajkori@gmail.com"},
			{"TC_28", "", "", false, "Login was unsuccessful"}, // Blank submission triggers summary error
			{"TC_29", "unregistered_user999@gmail.com", "Test@123", false, "Login was unsuccessful"},
			{"TC_30", "rajkori@gmail.com", "WrongPassword123", false, "Login was unsuccessful"},
			{"TC_31", "rajkori@gmail.com", "Test@123", true, "rajkori@gmail.com"},
			{"TC_32", "FORGOT_PASS_CLICK", "", false, "passwordrecovery"},
			{"TC_33", "REGISTER_CLICK", "", false, "register"}
		};
	}

	@Test(dataProvider = "loginTestcasesProvider")
	public void verifyLogin(String tcID, String emailInput, String passwordInput, boolean rememberMe, String expectedResult) {
		LoginPage loginpage = new LoginPage();
		loginpage.clickLogin();
		
		if(tcID.equals("TC_32"))
		{
			loginpage.clickForgotPassword();
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains(expectedResult), tcID + " Forgot Password Navigation failed!");
			return;
		}
		
		if(tcID.equals("TC_33"))
		{
			loginpage.clickRegisterButton();
			String currentURL = driver.getCurrentUrl();
			Assert.assertTrue(currentURL.contains(expectedResult), tcID + " Register button navigation failed!");
			return;
		}
		
		loginpage.enteremail(emailInput);
		loginpage.enterpass(passwordInput);
		
		if(rememberMe)
		{
			loginpage.selectcheckbox();
		}
		
		loginpage.submit();
		
		if(tcID.equals("TC_27") || tcID.equals("TC_31"))
		{
			String loggedUser = loginpage.getLoggedInUserEmail();
			Assert.assertEquals(loggedUser, expectedResult, tcID + " Positive login test failed!");
		} 
		else {
			String actualError = "";
			try {
				actualError = loginpage.getFieldError();
			} catch(Exception e) {
				actualError = "";
			}
			if(actualError == null || actualError.isEmpty())
			{
				actualError = loginpage.getErrorMessage();
			}
			Assert.assertTrue(actualError.contains(expectedResult), tcID + " Validation or Error check failed! Got: '" + actualError + "'");
		}
	}
}