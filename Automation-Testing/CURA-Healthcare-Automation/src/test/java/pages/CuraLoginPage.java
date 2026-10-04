package pages;
import org.openqa.selenium.*;
public class CuraLoginPage {
 private final WebDriver d; public CuraLoginPage(WebDriver d){this.d=d;}
 public void login(String user,String pass){d.findElement(By.id("btn-make-appointment")).click(); d.findElement(By.id("txt-username")).sendKeys(user); d.findElement(By.id("txt-password")).sendKeys(pass); d.findElement(By.id("btn-login")).click();}
}