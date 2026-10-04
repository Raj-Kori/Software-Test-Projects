package pages;
import org.openqa.selenium.*;
public class CuraAppointmentPage {
 private final WebDriver d; public CuraAppointmentPage(WebDriver d){this.d=d;}
 public void selectFacility(String value){new org.openqa.selenium.support.ui.Select(d.findElement(By.id("combo_facility"))).selectByVisibleText(value);}
 public void chooseMedicare(){d.findElement(By.id("radio_program_medicaid")).click();}
 public void setDate(String date){WebElement e=d.findElement(By.id("txt_visit_date")); e.clear(); e.sendKeys(date);}
 public void comment(String text){d.findElement(By.id("txt_comment")).sendKeys(text);}
 public void book(){d.findElement(By.id("btn-book-appointment")).click();}
 public boolean confirmationVisible(){return d.findElement(By.tagName("h2")).getText().contains("Appointment Confirmation");}
}