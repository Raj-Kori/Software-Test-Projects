package Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo_Automation {

	public static void main(String[] args) {
		
		// 1. Initialize the Chrome Browser
		WebDriver driver = new ChromeDriver();
		
		try {
			// Maximize the browser window so everything is visible
			driver.manage().window().maximize();
			
			// 2. Open the first link
			System.out.println("Navigating to first website...");
			driver.get("https://www.youtube.com/@CyborXGamingG69");
			
			// Optional: Wait for 3 seconds so you can see it load
			Thread.sleep(3000);
			
			// 3. Open the second link in the same window
			System.out.println("Navigating to second website...");
			driver.get("https://www.selenium.dev");
			
			// Wait another 3 seconds
			Thread.sleep(3000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 4. Close the browser session cleanly
			System.out.println("Closing browser...");
			driver.quit();
		}
	}
}