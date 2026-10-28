package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.RegistrationPage;

public class RegistrationTest extends BaseTest {

    private static String registeredEmail = "";

    @DataProvider(name = "registrationTestcasesProvider")
    public Object[][] getRegistrationTestData() {
        return new Object[][] {
            { "TC_21", "Male", "Raj", "Kori", "valid", "Test@123", "Your registration completed" },
            { "TC_22", "Male", "", "", "blank", "", "First name is required." },
            { "TC_23", "Male", "Raj", "Kori", "invalid-email-format", "Test@123", "Wrong email" },
            { "TC_24", "Male", "Raj", "Kori", "valid", "MismatchPass", "The password and confirmation password do not match" },
            { "TC_25", "Male", "Raj", "Kori", "duplicate", "Test@123", "The specified email already exists" },
            { "TC_26", "Male", "Raj", "Kori", "valid", "123", "The password should have at least 6 characters" }
        };
    }

    @Test(dataProvider = "registrationTestcasesProvider")
    public void verifyRegistrationScenarios(String tcId, String gender, String firstName, String lastName, String emailType, String password, String expectedMessage) {
        RegistrationPage registerpage = new RegistrationPage();
        
        // Special Pre-step for TC_25: Register the email once so it becomes a duplicate
        if (tcId.equals("TC_25")) {
            if (registeredEmail.isEmpty()) {
                registeredEmail = "dup_user" + System.currentTimeMillis() + "@gmail.com";
                registerpage.clickregisterHeaderLink();
                registerpage.selectGender(gender);
                registerpage.enterFirstName(firstName);
                registerpage.enterLastNAme(lastName);
                registerpage.enterEmail(registeredEmail);
                registerpage.enterPass(password);
                registerpage.entercnfPass(password);
                registerpage.clickregi();
                
                // Clear cookies and navigate back to register page cleanly
                driver.manage().deleteAllCookies();
                driver.get("https://demowebshop.tricentis.com/register");
            }
        }

        // Ensure we are on the registration page before running each test case
        try {
            registerpage.clickregisterHeaderLink();
        } catch (Exception e) {
            driver.get("https://demowebshop.tricentis.com/register");
        }

        registerpage.selectGender(gender);
        registerpage.enterFirstName(firstName);
        registerpage.enterLastNAme(lastName);
        
        String emailToUse;
        if (emailType.equals("valid")) {
            emailToUse = "rajkori" + System.currentTimeMillis() + "@gmail.com";
        } else if (emailType.equals("duplicate")) {
            emailToUse = registeredEmail; 
        } else if (emailType.equals("invalid-email-format")) {
            emailToUse = "rajkori.com";
        } else {
            emailToUse = "";
        }
        
        registerpage.enterEmail(emailToUse);
        registerpage.enterPass(password);
        
        if (tcId.equals("TC_24")) {
            registerpage.entercnfPass("DifferentPass");
        } else {
            registerpage.entercnfPass(password);
        }
        
        registerpage.clickregi();
        
        if (tcId.equals("TC_21")) {
            String actualMessage = registerpage.getMess();
            Assert.assertTrue(actualMessage.contains(expectedMessage), tcId + " Positive Registration Failed!");
        } else {
            String actualError = "";
            
            // For duplicate email (TC_25), grab the validation summary error message from the top panel
            if (tcId.equals("TC_25")) {
                try {
                    actualError = driver.findElement(By.cssSelector("div.message-error")).getText();
                } catch (Exception e) {
                    actualError = registerpage.getMess();
                }
            } else {
                try {
                    actualError = registerpage.getFieldError();
                } catch (Exception e) {
                    actualError = registerpage.getMess();
                }
            }
            
            if (actualError == null || actualError.isEmpty()) {
                actualError = registerpage.getMess(); 
            }
            
            Assert.assertTrue(actualError.contains(expectedMessage), 
                tcId + " Validation Error check failed! Expected to find: '" + expectedMessage + "', but got: '" + actualError + "'");
        }
    }
}