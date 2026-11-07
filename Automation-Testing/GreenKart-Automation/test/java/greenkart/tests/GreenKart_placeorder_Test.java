package greenkart.tests;

import org.testng.annotations.Test;

import greenkart.pages.GreenKart_Cart;
import greenkart.pages.GreenKart_ProductSearch;
import greenkart.pages.GreenKart_checkout;
import greenkart.pages.GreenKart_placeorder;

public class GreenKart_placeorder_Test extends GreenKart_BaseTest{
@Test
public void verifyplaceorder() throws InterruptedException
{
	GreenKart_ProductSearch searchproduct= new GreenKart_ProductSearch();
	GreenKart_Cart cartpage = new GreenKart_Cart();
	GreenKart_checkout checkoutpage= new GreenKart_checkout();
	GreenKart_placeorder order= new GreenKart_placeorder();
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
	
	//placeorder
	order.Terms("India");
}
}
