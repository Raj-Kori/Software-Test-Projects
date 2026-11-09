package cura.test;

import org.testng.annotations.Test;
import cura.pages.Cura_loginpage;

public class Cura_loginTest extends Cura_Base_Test {
    @Test
    public void verifylogin() {
        new Cura_loginpage().Login("John Doe", "ThisIsNotAPassword");
    }
}