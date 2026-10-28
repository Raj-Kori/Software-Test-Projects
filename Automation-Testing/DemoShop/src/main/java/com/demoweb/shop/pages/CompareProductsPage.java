package com.demoweb.shop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.demoweb.shop.BaseClass;
import com.demoweb.shop.utils.ElementUtils;
import java.util.List;

public class CompareProductsPage {

    private By productTitleLink = By.cssSelector("h2.product-title a");
    private By addToCompareButton = By.cssSelector("input.add-to-compare-list-button");
    private By compareProductsFooterLink = By.xpath("//a[text()='Compare products list']");
    private By comparisonTablePageTitle = By.cssSelector("div.page-title h1");
    private By clearListButton = By.cssSelector("input.clear-list-button");

    public void clickProductTitle() {
        ElementUtils.clickElement(productTitleLink);
    }

    public void clickAddToCompare() {
        ElementUtils.clickElement(addToCompareButton);
    }

    public void openCompareProductsPage() {
        ElementUtils.clickElement(compareProductsFooterLink);
    }

    public String getComparisonPageTitle() {
        return ElementUtils.getElementText(comparisonTablePageTitle);
    }

    public void clearComparisonList() {
        // Safe check to clear list only if the button is present in the DOM
        List<WebElement> clearBtn = BaseClass.getDriver().findElements(clearListButton);
        if (!clearBtn.isEmpty() && clearBtn.get(0).isDisplayed()) {
            clearBtn.get(0).click();
        }
    }
}