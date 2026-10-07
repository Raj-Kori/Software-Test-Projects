package stepdefinations;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenKart_Automation {

    private WebDriver driver;
    private WebDriverWait wait;

    private final By searchBox = By.xpath("//input[@class='search-keyword']");
    private final By searchBtn = By.xpath("//button[@class='search-button']");
    private final By cartIcon = By.xpath("//a[@class='cart-icon']");
    private final By promoCodeInput = By.xpath("//input[@class='promoCode']");
    private final By promoBtn = By.xpath("//button[@class='promoBtn']");
    private final By promoInfo = By.xpath("//span[@class='promoInfo']");
    private final By countryDropdown = By.xpath("//div/select");
    private final By termsCheckbox = By.xpath("//input[@type='checkbox']");

    @Given("User navigates to the GreenKart home page {string}")
    public void user_navigates_to_the_green_kart_home_page(String webLink) {
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get(webLink);
        System.out.println("[CONSOLE] Browser launched: " + driver.getTitle());
    }

    @When("User searches for product {string}")
    public void user_searches_for_product(String productName) {
        System.out.println("[CONSOLE] Product search initiated for: " + productName);

        WebElement name = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox));

        name.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        name.sendKeys(productName);
        driver.findElement(searchBtn).click();

        WebElement target = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h4[contains(@class,'product-name') and contains(text(),'" + productName + "')]")));

        System.out.println("[CONSOLE] Element visible: " + target.getText());
        Assert.assertTrue(target.isDisplayed(), "Product was not displayed after search.");
    }

    @When("User clicks on {string} for {string}")
    public void user_clicks_on_for(String action, String productName) {
        System.out.println("[CONSOLE] Clicking '" + action + "' for product: " + productName);

        By dynamicAddToCart = By.xpath(
                "//h4[contains(text(),'" + productName + "')]/parent::div//button[contains(text(),'" + action + "')]");

        wait.until(ExpectedConditions.elementToBeClickable(dynamicAddToCart)).click();
    }

    @When("User clicks on the cart icon")
    public void user_clicks_on_the_cart_icon() {
        System.out.println("[CONSOLE] Opening cart overlay");
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String buttonText) {
        System.out.println("[CONSOLE] Clicking button: " + buttonText);

        By dynamicButton = By.xpath("//button[contains(normalize-space(),'" + buttonText + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(dynamicButton)).click();
    }

    @When("User clicks {string}")
    public void user_clicks_without_on(String buttonText) {
        System.out.println("[CONSOLE] Clicking button: " + buttonText);

        By dynamicButton = By.xpath("//button[contains(normalize-space(),'" + buttonText + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(dynamicButton)).click();
    }

    @Then("User should be navigated to the Order Checkout page")
    public void user_should_be_navigated_to_the_order_checkout_page() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(promoCodeInput));

        System.out.println("[CONSOLE] Navigated to Order Checkout page");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart") || driver.findElement(promoCodeInput).isDisplayed(),
                "Order Checkout page was not displayed.");
    }

    @When("User applies promo code {string}")
    public void user_applies_promo_code(String code) {
        System.out.println("[CONSOLE] Applying promo code: " + code);

        WebElement promoField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(promoCodeInput));

        promoField.sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        promoField.sendKeys(code);
        driver.findElement(promoBtn).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(promoInfo));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(promoInfo, "Code applied"));

        WebElement promoMessage = driver.findElement(promoInfo);
        System.out.println("[CONSOLE] Promo code applied successfully: " + promoMessage.getText());

        Assert.assertTrue(promoMessage.getText().contains("Code applied"),
                "Promo code was not applied successfully.");
    }

    @When("User selects country {string} and accepts Terms & Conditions")
    public void user_selects_country_and_accepts_terms_conditions(String countryName) {
        WebElement selectElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(countryDropdown));

        Select select = new Select(selectElement);
        select.selectByVisibleText(countryName);

        System.out.println("[CONSOLE] Country selected: " + countryName);

        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(termsCheckbox));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        Assert.assertTrue(checkbox.isSelected(),
                "Terms & Conditions checkbox was not selected.");
    }

    @Then("User should see the order confirmation message")
    public void user_should_see_the_order_confirmation_message() {
        By successMsg = By.xpath(
                "//*[contains(text(),'Thank you, your order has been placed successfully')]");

        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMsg));

        System.out.println("[CONSOLE] Order confirmation message: " + message.getText());

        Assert.assertTrue(message.isDisplayed(),
                "Order confirmation message not displayed.");

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
