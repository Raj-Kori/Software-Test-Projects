package tests;
import base.BaseTest; import pages.*; import org.testng.Assert; import org.testng.annotations.Test;
public class CuraAppointmentTest extends BaseTest {
 @Test public void validAppointmentCanBeBooked(){
  CuraLoginPage login=new CuraLoginPage(driver); login.login("John Doe","ThisIsNotAPassword");
  CuraAppointmentPage appt=new CuraAppointmentPage(driver); appt.selectFacility("Tokyo CURA Healthcare Center"); appt.chooseMedicare(); appt.setDate("30/10/2026"); appt.comment("Automation test"); appt.book();
  Assert.assertTrue(appt.confirmationVisible(),"Appointment confirmation was not displayed");
 }
}