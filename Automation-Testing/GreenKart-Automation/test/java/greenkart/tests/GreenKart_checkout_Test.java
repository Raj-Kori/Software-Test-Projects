package greenkart.tests;

import org.testng.annotations.Test;

import greenkart.pages.GreenKart_Cart;
import greenkart.pages.GreenKart_ProductSearch;
import greenkart.pages.GreenKart_checkout;

public class GreenKart_checkout_Test extends GreenKart_BaseTest{
@Test
public void verifycheckout() throws InterruptedException
{
	GreenKart_ProductSearch searchproduct= new GreenKart_ProductSearch();
	GreenKart_Cart cartpage = new GreenKart_Cart();
	GreenKart_checkout checkoutpage= new GreenKart_checkout();
	
	String productname="Carrot";
	
	//search-item
	searchproduct.enterProduct(productname);
	searchproduct.clickSearchButton();
	searchproduct.getSearchProductTitle(productname);
	
	//addtocart
	cartpage.verifyaddtocartbutton();
	cartpage.getcartdetails();
	cartpage.getcartquantity();
	cartpage.getcartprice();
	
	
	//checkout
	checkoutpage.opencart();
	checkoutpage.promocode("rahulshettyacademy");
	checkoutpage.getcartinfo();
	checkoutpage.clickplaceorderbutton();
}
}
