package cura.pages;

import org.openqa.selenium.By;
import cura.utils.Cura_Elements;

public class Cura_appointmentpage {
    private final By menuToggle = By.id("menu-toggle");
    private final By logoutLink = By.xpath("//a[contains(@href, 'logout')]");
    private final By selectFacility = By.id("combo_facility");
    private final By hospitalReadmission = By.id("chk_hospotal_readmission");
    private final By selectProgram = By.id("radio_program_medicaid");
    private final By enterDate = By.id("txt_visit_date");
    private final By enterComment = By.id("txt_comment");
    private final By submitButton = By.id("btn-book-appointment");

    public void Book_Appointment(String facility, String date, String comment) {
        try {
            Cura_Elements.selectDropdownByValue(selectFacility, facility);
            Cura_Elements.selectCheckbox(hospitalReadmission, true);
            Cura_Elements.selectRadioButton(selectProgram);
            Cura_Elements.selectDate(enterDate, date);
            Cura_Elements.enterText(enterComment, comment);
            Cura_Elements.clickButton(submitButton);
            Cura_Elements.jsClick(menuToggle);
            Cura_Elements.jsClick(logoutLink);
        } catch (Exception e) {
            System.out.println("[Error] Failed during appointment booking: " + e.getMessage());
            throw e;
        }
    }
}