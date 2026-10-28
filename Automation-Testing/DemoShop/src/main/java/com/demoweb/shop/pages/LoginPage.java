package com.demoweb.shop.pages;

import org.openqa.selenium.By;
import com.demoweb.shop.utils.ElementUtils;

public class LoginPage {

	private By loginlink = By.cssSelector("a.ico-login");
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By rememberMe = By.id("RememberMe");
	private By loginbtn = By.cssSelector("input.login-button");
	private By userAccountHeader = By.cssSelector("a.account");
	private By errorMessageSummary = By.cssSelector("div.message-error");
	private By fieldValidationError = By.id("Email-error");
	private By forgotPasswordLink = By.cssSelector("a[href*='passwordrecovery']");
	private By registerButton = By.cssSelector("input[value='Register']"); // Reliable selector for the Register button on login page
	
	public void clickLogin() {
		ElementUtils.clickElement(loginlink);
	}
	public void enteremail(String Email) {
		ElementUtils.enterText(email, Email);
	}
	public void enterpass(String Pass) {
		ElementUtils.enterText(password, Pass);
	}
	public void selectcheckbox() {
		ElementUtils.clickElement(rememberMe);
	}
	public void submit() {
		ElementUtils.clickElement(loginbtn);
	}
	public String getLoggedInUserEmail() {
		return ElementUtils.getElementText(userAccountHeader);
	}
	public String getErrorMessage() {
		return ElementUtils.getElementText(errorMessageSummary);
	}
	public String getFieldError() {
		return ElementUtils.getElementText(fieldValidationError);
	}
	public void clickForgotPassword() {
		ElementUtils.clickElement(forgotPasswordLink);
	}
	public void clickRegisterButton() {
		ElementUtils.clickElement(registerButton);
	}
}