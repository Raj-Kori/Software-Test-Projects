package pages.GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.GK_BasePage;

public class GK_AddToCart extends GK_BasePage {
    private final By cartCount = By.xpath("//div[@class='cart-info']//tr[1]//td[3]/strong");
    private final By cartPrice = By.xpath("//div[@class='cart-info']//tr[2]//td[3]/strong");
    private final By cartIcon = By.cssSelector("a.cart-icon");
    private final By proceedToCheckout = By.xpath("//button[contains(.,'PROCEED TO CHECKOUT')]");
    private final By promoCodeInput = By.cssSelector("input.promoCode");
    private final By promoButton = By.cssSelector("button.promoBtn");
    private final By promoInfo = By.cssSelector("span.promoInfo");
    private final By countryDropdown = By.cssSelector("select");
    private final By termsCheckbox = By.cssSelector("input[type='checkbox']");
    private final By placeOrderButton = By.xpath("//button[normalize-space()='Place Order']");
    private final By proceedButton = By.xpath("//button[normalize-space()='Proceed']");
    private final By orderSuccess = By.xpath("//*[contains(.,'Thank you, your order has been placed successfully')]");

    public GK_AddToCart(WebDriver driver) {
        super(driver);
    }

    public int getCartCount() {
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(cartCount))
                .getText().trim();
        return Integer.parseInt(value);
    }

    public int getCartPrice() {
        String value = wait.until(ExpectedConditions.visibilityOfElementLocated(cartPrice))
                .getText().trim().replaceAll("[^0-9]", "");
        return Integer.parseInt(value);
    }

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout)).click();
    }

    public boolean isCheckoutPageLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(promoCodeInput)).isDisplayed();
    }

    public void applyPromoCode(String code) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(promoCodeInput));
        field.sendKeys(Keys.CONTROL, "a");
        field.sendKeys(Keys.BACK_SPACE);
        field.sendKeys(code);
        wait.until(ExpectedConditions.elementToBeClickable(promoButton)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(promoInfo, "Code applied"));
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public void selectCountryAndAcceptTerms(String countryName) {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown));
        new Select(dropdown).selectByVisibleText(countryName);

        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void clickProceed() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton)).click();
    }

    public boolean isOrderSuccessDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderSuccess)).isDisplayed();
    }
}