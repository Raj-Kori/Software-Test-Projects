package greenkart.pages;

import org.openqa.selenium.By;

import greenkart.utils.GreenKart_Elements;

public class GreenKart_Cart {
private By addtocartbutton = By.xpath("//button[contains(normalize-space(),'ADD TO CART')]");
private By addtocarticon= By.xpath("//img[@alt='Cart']");
private By proccedtocheckout = By.xpath("//button[contains(normalize-space(),'PROCEED TO CHECKOUT')]");
private By cartproductname = By.cssSelector("li.cart-item p.product-name");
private By cartproductquantity = By.cssSelector("li.cart-item p.quantity");
private By cartproductprice = By.cssSelector("li.cart-item p.product-price");
public void verifyaddtocartbutton() throws InterruptedException
{
	Thread.sleep(1200);
	GreenKart_Elements.clickElement(addtocartbutton);
	Thread.sleep(1200);
	GreenKart_Elements.clickElement(addtocarticon);
	Thread.sleep(1200);
	GreenKart_Elements.waitForElementToBeClickable(proccedtocheckout);
}
public String getcartdetails()
{
	return GreenKart_Elements.getElementText(cartproductname);
}
public String getcartquantity()
{
	return GreenKart_Elements.getElementText(cartproductquantity);
}
public String getcartprice()
{
	return GreenKart_Elements.getElementText(cartproductprice);
}
}
