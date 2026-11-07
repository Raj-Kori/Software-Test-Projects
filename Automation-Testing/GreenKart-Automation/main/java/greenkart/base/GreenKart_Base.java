package greenkart.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart_Base {

	private static ThreadLocal<WebDriver>driver= new ThreadLocal<>();
	private static final String Base_URL= "https://rahulshettyacademy.com/seleniumPractise/#/";
	
	public static void device_config()
	{
		WebDriver localdriver = new ChromeDriver();
		driver.set(localdriver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		getDriver().get(Base_URL);
		
	}
	public static WebDriver getDriver()
	{
		return driver.get();
		}
	
	public static void tearDownDriver()

	{
		if(driver.get()!=null)
		{
			driver.get().quit();
			driver.remove();
		}
	}
}
