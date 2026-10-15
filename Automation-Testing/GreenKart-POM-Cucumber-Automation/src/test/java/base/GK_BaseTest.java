package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GK_BaseTest {
    protected WebDriver driver;

    public void initializeBrowser(String url) {
        java.util.logging.Logger.getLogger("org.openqa.selenium")
                .setLevel(java.util.logging.Level.WARNING);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("[INFO] Browser launched: " + driver.getTitle());
    }

    public void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("[INFO] Browser closed.");
        }
    }
}