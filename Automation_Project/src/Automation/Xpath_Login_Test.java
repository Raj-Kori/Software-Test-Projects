package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath_Login_Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lusif\\Downloads\\Personal_P\\Automation_Project\\src\\Driver\\chrome.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"submit\"]")).click();
		

	}

}
