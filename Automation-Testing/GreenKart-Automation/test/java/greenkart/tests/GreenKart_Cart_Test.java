package greenkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import greenkart.pages.GreenKart_Cart;
import greenkart.pages.GreenKart_ProductSearch;

public class GreenKart_Cart_Test extends GreenKart_BaseTest{
	@Test
	public void verifyaddtocart() throws InterruptedException
	{
		GreenKart_ProductSearch search_page= new GreenKart_ProductSearch();
		GreenKart_Cart cartpage= new GreenKart_Cart();
		String productname= "Carrot";
		Thread.sleep(1200);
		search_page.enterProduct(productname);
		search_page.clickSearchButton();
		Thread.sleep(1200);
		cartpage.verifyaddtocartbutton();
		String cartproduct = cartpage.getcartdetails();
		
        System.out.println("[INFO] Cart Product Name: " + cartproduct);
        Assert.assertTrue(cartproduct.toLowerCase().contains(productname.toLowerCase()), "Product not in cart");
        
        String cartproductquantity = cartpage.getcartquantity();
        System.out.println("[INFO] Cart Quantity: " + cartproductquantity);
        Assert.assertFalse(cartproductquantity.isEmpty(), "Quantity not found");
        
        String cartproductprice = cartpage.getcartprice();
        System.out.println("[INFO] Cart Price: " + cartproductprice);
        Assert.assertFalse(cartproductprice.isEmpty(), "Price not found");
	}

}
