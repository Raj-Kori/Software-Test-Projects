package greenkart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import greenkart.base.GreenKart_Base;
import greenkart.utils.GreenKart_Elements;

public class GreenKart_checkout {
	private By proccedtocheckout = By.xpath("//button[contains(normalize-space(),'PROCEED TO CHECKOUT')]");
private By enterpromo=By.className("promoCode");
private By placeorderbutton= By.xpath("//button[contains(normalize-space(),'Place Order')]");
private By cartdetails= By.id("productCartTables");
private By applycode =By.xpath("//button[contains(normalize-space(),'Apply')]");
public void opencart()
{
	GreenKart_Elements.clickElement(proccedtocheckout);
}
public void promocode(String code) throws InterruptedException
{
GreenKart_Elements.entertext(enterpromo, code);	
Thread.sleep(800);
GreenKart_Elements.clickElement(applycode);
}
public void getcartinfo()
{
	System.out.println("==================================================");
    System.out.println("               CHECKOUT CART DETAILS              ");
    System.out.println("==================================================");
    
    List<WebElement> rows=GreenKart_Base.getDriver().findElements(By.cssSelector("#productCartTables tbody tr"));
    for (int i = 0; i < rows.size(); i++) {
        List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
        
        if (cols.size() >= 5) {
            // Extract details based on your HTML structure
            String productName = cols.get(1).findElement(By.cssSelector("p.product-name")).getText();
            String quantity = cols.get(2).findElement(By.cssSelector("p.quantity")).getText();
            String price = cols.get(3).findElement(By.cssSelector("p.amount")).getText();
            String total = cols.get(4).findElement(By.cssSelector("p.amount")).getText();
            
            System.out.println("Item #" + (i + 1));
            System.out.println("Product Name : " + productName);
            System.out.println("Quantity     : " + quantity);
            System.out.println("Price        : " + price);
            System.out.println("Total Amount : " + total);
            System.out.println("----------------------------------");
        }
    }
    System.out.println("==================================================");
}
public void clickplaceorderbutton()
{
	GreenKart_Elements.clickElement(placeorderbutton);
}
}
