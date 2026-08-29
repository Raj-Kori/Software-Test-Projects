package Automation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class First_Automation {

	public static void main(String[] args) throws InterruptedException {

		// 1. Configure ChromeOptions to disable password prompts & run in incognito
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-save-password-bubble");
        
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);

		// 2. Initialize ChromeDriver with configured options
		WebDriver driver = new ChromeDriver(options);
		
		// 3. Launch application and maximize browser window
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		System.out.println("Site Name: " + driver.getTitle());
		
		// 4. Perform User Login
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(500);
		System.out.println("Login Success");
		/*
		// 5. Navigate to Product Details Page
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		*/
		// 6. Add Product to Cart
		List<WebElement> addToCartButtons = driver.findElements(By.className("btn_inventory"));

		System.out.println("Total items found: " + addToCartButtons.size()); // Outputs 6

		// 2. Click every single button in a loop
		for (WebElement button : addToCartButtons) {
		    button.click();
		    Thread.sleep(300); // Small pause between clicks (optional)
		}

		System.out.println("All items added to cart successfully!");
		/*driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
		Thread.sleep(200);*/
		
		// 7. Go back to Inventory and navigate to Shopping Cart
		//driver.navigate().back();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@data-test='shopping-cart-link']")).click();
		Thread.sleep(500);
		
		// 8. Proceed to Checkout Step 1
		driver.findElement(By.xpath("//button[@id='checkout']")).click();

		// 9. Enter Customer Shipping Details
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Romeo");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Kumar");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("400165");
		Thread.sleep(500);
		System.out.println("Detail filled");
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(500);
		System.out.println("Checkout-Complete");

		// 10. Proceed to Checkout Step 2 and Finish Order
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		System.out.println("Purchase Complete");

		// 11. Navigate back to Home / Products Page
		driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
		System.out.println("Back to Home_Page");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		System.out.println("Menu Open");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
		Thread.sleep(1000);
		System.out.println("Logout Success");
		Thread.sleep(1000);
		// 12. Close all browser windows and safely terminate the WebDriver session
		driver.quit();
	}
}