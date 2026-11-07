package greenkart.pages;

import org.openqa.selenium.By;

import greenkart.utils.GreenKart_Elements;

public class GreenKart_placeorder {
private By selectcountry = By.xpath("//select[option[text()='Select']]");
private By tickbox = By.className("chkAgree");
private By proceed = By.xpath("//button[contains(normalize-space(),'Proceed')]");

public void Terms(String country_code) throws InterruptedException
{
	Thread.sleep(800);
	GreenKart_Elements.selectDropDownvalue(selectcountry,country_code);
	Thread.sleep(800);
	GreenKart_Elements.SelectCheckbox(tickbox);
	Thread.sleep(800);
	GreenKart_Elements.clickElement(proceed);
	
}
}
