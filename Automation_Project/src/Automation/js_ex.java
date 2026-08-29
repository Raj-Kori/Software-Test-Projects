package Automation;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class js_ex {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://proleed.academy/exercises/selenium/automate-the-signup-form-using-selenium-webdriver.php");
		System.out.println(driver.getTitle());
		
		List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@type='checkbox']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		for(WebElement box :checkboxes)
		{
			String boxTitle =box.getAttribute("id");
			if(!box.isSelected())
				js.executeScript("arguments[0].click()",box);
			System.out.println("Checkbox checked"+boxTitle);
			
		}
		driver.close();
	}

}
