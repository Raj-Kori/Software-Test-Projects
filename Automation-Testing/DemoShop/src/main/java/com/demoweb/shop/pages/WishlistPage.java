package com.demoweb.shop.pages;

import org.openqa.selenium.By;
import com.demoweb.shop.utils.ElementUtils;

public class WishlistPage {

    private By wishlistHeaderLink = By.cssSelector("a.ico-wishlist");
    private By wishlistPageTitle = By.cssSelector("div.page-title h1");
    private By homeLogo = By.cssSelector("img[alt='Tricentis Demo Web Shop']");

    public void openWishlist() {
        ElementUtils.clickElement(wishlistHeaderLink);
    }

    public String getWishlistPageTitle() {
        return ElementUtils.getElementText(wishlistPageTitle);
    }

    public void returnToHomePage() {
        ElementUtils.clickElement(homeLogo);
    }
}