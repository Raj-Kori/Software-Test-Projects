package cura.test;

import java.lang.reflect.Method;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import cura.base.Cura_Base;

public class Cura_Base_Test {
    @BeforeMethod
    public void verifybase(Method method) {
        System.out.println("\n==========================");
        System.out.println(">>> Starting Test: " + method.getName());
        System.out.println("==========================");
        Cura_Base.device_config();
    }

    @AfterMethod
    public void teardown() {
        Cura_Base.TearDownDriver();
    }
}