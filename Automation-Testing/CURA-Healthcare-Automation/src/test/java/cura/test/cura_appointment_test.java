package cura.test;

import org.testng.annotations.Test;
import cura.pages.Cura_appointmentpage;
import cura.pages.Cura_loginpage;

public class cura_appointment_test extends Cura_Base_Test {
    @Test
    public void verifyappointment() {
        new Cura_loginpage().Login("John Doe", "ThisIsNotAPassword");
        new Cura_appointmentpage().Book_Appointment(
            "Hongkong CURA Healthcare Center",
            "24/12/2026",
            "Welcome to the Test Automation of CURA WebSite"
        );
    }
}