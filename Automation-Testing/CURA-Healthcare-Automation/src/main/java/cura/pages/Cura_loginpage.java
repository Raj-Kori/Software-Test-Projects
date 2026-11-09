package cura.pages;

import org.openqa.selenium.By;
import cura.utils.Cura_Elements;

public class Cura_loginpage {
    private final By menuToggle = By.id("menu-toggle");
    private final By loginLink = By.xpath("//a[text()='Login']");
    private final By usernameField = By.id("txt-username");
    private final By passwordField = By.id("txt-password");
    private final By loginButton = By.id("btn-login");

    public void Login(String username, String password) {
        Cura_Elements.jsClick(menuToggle);
        Cura_Elements.clickButton(loginLink);
        Cura_Elements.enterText(usernameField, username);
        Cura_Elements.enterText(passwordField, password);
        Cura_Elements.clickButton(loginButton);
    }
}