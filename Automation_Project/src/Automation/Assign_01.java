package Automation;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assign_01 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            driver.get("https://proleed.academy/exercises/selenium/automate-the-signup-form-using-selenium-webdriver.php");
            System.out.println("--- STARTING FORM AUTOMATION ---\n");
            Thread.sleep(1500);
            // 1. First Name
            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
            firstName.sendKeys("Pandu");
            System.out.println("[LOG] Entered First Name: " + firstName.getAttribute("value"));
            Thread.sleep(1500);

            // 2. Last Name
            WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lastname")));
            lastName.sendKeys("Kumar");
            System.out.println("[LOG] Entered Last Name: " + lastName.getAttribute("value"));
            Thread.sleep(1500);

            // 3. Gender (Radio Button)
            WebElement maleRadio = wait.until(ExpectedConditions.elementToBeClickable(By.id("male")));
            if (!maleRadio.isSelected()) {
                maleRadio.click();
            }
            // Fetch the label text or value associated with the selected radio button
            String genderValue = maleRadio.getAttribute("value") != null ? maleRadio.getAttribute("value") : "Male";
            System.out.println("[LOG] Selected Gender: " + genderValue + " (Selected: " + maleRadio.isSelected() + ")");
            Thread.sleep(1500);

            // 4. Experience (Dropdown)
            WebElement expElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("experience")));
            Select expDropdown = new Select(expElement);
            expDropdown.selectByVisibleText("2");
            System.out.println("[LOG] Selected Experience: " + expDropdown.getFirstSelectedOption().getText());
            Thread.sleep(1500);

            // 5. Date
            WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date")));
            dateField.clear();
            dateField.sendKeys("24/03/2002");
            System.out.println("[LOG] Entered Date: " + dateField.getAttribute("value"));
            Thread.sleep(1500);
           
            // 6. Profession (radio Button)
            WebElement profession = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("automation")));
            profession.click();
            System.out.println("Profession Selected : "+profession.getAttribute("id"));

            // 7. Checkboxes (Skills)
            List<WebElement> checkboxes = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@type='checkbox']")));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            System.out.println("[LOG] Processing Checkboxes:");
            for (WebElement checkbox : checkboxes) {
                if (!checkbox.isSelected()) {
                    js.executeScript("arguments[0].click();", checkbox);
                }
                
                // Fetch the identifier or label text for verification
                String boxId = checkbox.getAttribute("id");
                String boxValue = checkbox.getAttribute("value");
                String displayName = (boxId != null && !boxId.isEmpty()) ? boxId : boxValue;
                
                System.out.println("   -> Skill Checkbox [" + displayName + "] | Selected: " + checkbox.isSelected());
            }
            Thread.sleep(1500);

            // 8. Country (Dropdown)
            WebElement countryElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("country")));
            Select countryDropdown = new Select(countryElement);
            countryDropdown.selectByVisibleText("India");
            System.out.println("[LOG] Selected Country: " + countryDropdown.getFirstSelectedOption().getText());
            Thread.sleep(1500);

            // 9. File Upload
            WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("photo")));
            String filePath = "C:\\Users\\lusif\\Pictures\\elegance-hd-forest-with-plants-minimalist-top-best-free-download-wallpapers-for-macbook-pro-air-and-microsoft-windows-pcs-desktop-4k-07-12-2024-1733638159-hd-wallpaper.png";
            uploadInput.sendKeys(filePath);
            System.out.println("[LOG] Uploaded File Path: " + uploadInput.getAttribute("value"));
            Thread.sleep(1500);

            // 10. Submit Button
            WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add")));
            submitBtn.click();
            System.out.println("[LOG] Clicked Submit Button.");
            Thread.sleep(1500);

            // 11. Alert Handling
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("[LOG] Alert Popup Text Captured: \"" + alert.getText() + "\"");
            alert.accept();
            System.out.println("[LOG] Alert Accepted Successfully.");
            Thread.sleep(1500);

            System.out.println("\n--- ASSIGNMENT COMPLETED SUCCESSFULLY ---");

        } catch (Exception e) {
            System.err.println("[ERROR] Test execution failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}