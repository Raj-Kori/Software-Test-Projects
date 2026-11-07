package greenkart.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import greenkart.base.GreenKart_Base;

public class GreenKart_BaseTest {
	protected WebDriver driver;
	@BeforeMethod
	public void setup(Method method)
	{
		System.out.println("\n----------------------------------");
		System.out.println(">>> Starting Test : "+ method.getName());
		System.out.println("\n----------------------------------");
	
		GreenKart_Base.device_config();
	}
	@AfterMethod
	public void tearDown()
	{
		GreenKart_Base.tearDownDriver();
	}

}
