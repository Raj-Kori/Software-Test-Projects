package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoweb.shop.pages.WishlistPage;

public class WishlistTest extends BaseTest {

    @Test
    public void verifyWishlistNavigation() {
        WishlistPage wishlistPage = new WishlistPage();
        
        // Open Wishlist
        wishlistPage.openWishlist();
        String pageTitle = wishlistPage.getWishlistPageTitle();
        Assert.assertEquals(pageTitle, "Wishlist", "Wishlist page header does not match!");

        // Close / Navigate away from Wishlist back to Homepage
        wishlistPage.returnToHomePage();
    }
}