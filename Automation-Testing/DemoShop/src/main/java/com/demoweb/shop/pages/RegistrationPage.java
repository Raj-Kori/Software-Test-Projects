package com.demoweb.shop.pages;

import org.openqa.selenium.By;

import com.demoweb.shop.utils.ElementUtils;
public class RegistrationPage {
private By registrationlink =By.cssSelector("a.ico-register");
private By genderMale=By.id("gender-male");
private By genderFemale=By.id("gender-female");
private By firstname=By.id("FirstName");
private By lastname=By.id("LastName");
private By email=By.id("Email");
private By password=By.id("Password");
private By cnfpassword=By.id("ConfirmPassword");
private By registerBtn=By.id("register-button");
private By successMessage = By.cssSelector("div.result");
private By fieldValidationError = By.cssSelector(".field-validation-error");

public String getFieldError() {
    return ElementUtils.getElementText(fieldValidationError);
}
public void clickregisterHeaderLink()
{
	ElementUtils.clickElement(registrationlink);
}
public void selectGender(String gender)
{
	if(gender.equalsIgnoreCase("male"))
	{
		ElementUtils.clickElement(genderMale);
	}else {
		ElementUtils.clickElement(genderFemale);
	}
}
public void enterFirstName(String firstName)
{
	ElementUtils.enterText(firstname, firstName);
}
public void enterLastNAme(String lastName)
{
	ElementUtils.enterText(lastname, lastName);
}
public void enterEmail(String Email)
{
	ElementUtils.enterText(email, Email);
}
public void enterPass(String pass)
{
	ElementUtils.enterText(password, pass);
}
public void entercnfPass(String cnfPass)
{
	ElementUtils.enterText(cnfpassword, cnfPass);
}
public void clickregi()
{
	ElementUtils.clickElement(registerBtn);
}
public String getMess()
{
	return ElementUtils.getElementText(successMessage);
}
}
