package pages.GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.GK_BasePage;

public class GK_SearchField extends GK_BasePage {
    private final By searchBox = By.cssSelector("input.search-keyword");
    private final By searchButton = By.cssSelector("button.search-button");

    public GK_SearchField(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        WebElement field = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox));
        field.sendKeys(Keys.CONTROL, "a");
        field.sendKeys(Keys.BACK_SPACE);
        field.sendKeys(productName);
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();

        String productXpath = "//h4[contains(translate(normalize-space(.),"
                + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"
                + productName.toLowerCase() + "')]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productXpath)));
    }

    public void clickAddToCart(String productName) {
        By addButton = By.xpath("//h4[contains(translate(normalize-space(.),"
                + "'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"
                + productName.toLowerCase()
                + "')]/ancestor::div[contains(@class,'product')][1]"
                + "//button[contains(.,'ADD TO CART')]");
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }
}