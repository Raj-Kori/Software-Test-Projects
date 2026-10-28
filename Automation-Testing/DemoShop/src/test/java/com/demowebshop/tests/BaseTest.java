package com.demowebshop.tests;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.demoweb.shop.BaseClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup(Method method) {
        System.out.println("\n------------------------------------------------");
        System.out.println(">>> STARTING TEST: " + method.getName());
        System.out.println("------------------------------------------------");
        
        // Initialize the browser driver before every test
        BaseClass.driverconfig();
        
        // Assign the driver instance so child test classes can use it
        driver = BaseClass.getDriver(); // (Ensure BaseClass has a static getDriver() method)
    }

    @AfterMethod
    public void tearDown() {
        BaseClass.tearDownDriver();
    }
}