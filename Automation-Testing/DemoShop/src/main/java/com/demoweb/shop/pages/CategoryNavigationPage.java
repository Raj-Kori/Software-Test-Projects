package com.demoweb.shop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.demoweb.shop.utils.ElementUtils;

public class CategoryNavigationPage {

    // TC_50: Top Navigation Categories (e.g., Computers, Books, Electronics)
    public void clickTopCategory(String categoryName) {
        By categoryLink = By.xpath("//ul[@class='top-menu']//a[normalize-space()='" + categoryName + "']");
        ElementUtils.clickElement(categoryLink);
    }

    // TC_51: Left Sidebar Sub-categories (e.g., Cell phones, Notebooks)
    public void clickLeftSubCategory(String subCategoryName) {
        By subCategoryLink = By.xpath("//div[@class='listbox']//a[normalize-space()='" + subCategoryName + "']");
        ElementUtils.clickElement(subCategoryLink);
    }

    // TC_52: Product Catalog Sorting (e.g., "Name: A to Z", "Price: Low to High")
    public void selectSortingOption(String visibleText) {
        WebElement sortDropdownElement = ElementUtils.waitForElementToBeVisible(By.id("products-orderby"));
        Select select = new Select(sortDropdownElement);
        select.selectByVisibleText(visibleText);
    }

    public String getPageTitle() {
        return ElementUtils.getElementText(By.cssSelector("div.page-title h1"));
    }
}