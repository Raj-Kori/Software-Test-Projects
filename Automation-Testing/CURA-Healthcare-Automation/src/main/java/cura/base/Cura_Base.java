package cura.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Cura_Base {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String BASE_URL = "https://katalon-demo-cura.herokuapp.com/";

    public static void device_config() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-save-password-bubble", "--disable-autofill");

        WebDriver localDriver = new ChromeDriver(options);
        driver.set(localDriver);
        getdriver().manage().window().maximize();
        getdriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        getdriver().get(BASE_URL);
    }

    public static WebDriver getdriver() {
        return driver.get();
    }

    public static void TearDownDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}