package greenkart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import greenkart.base.GreenKart_Base;
import greenkart.utils.GreenKart_Elements;

public class GreenKart_ProductSearch {
private By searchfield = By.className("search-keyword");
private By searchbutton = By.className("search-button");
private By productTitle = By.cssSelector("h4.product-name");

public void enterProduct(String productName)
{
	if(GreenKart_Base.getDriver()!=null)
	{
		GreenKart_Elements.entertext(searchfield, productName);
	}
}
public void clickSearchButton()
{
	GreenKart_Elements.clickElement(searchbutton);
}
public String getSearchProductTitle(String expectedProduct)
{
	WebDriverWait wait= new WebDriverWait(GreenKart_Base.getDriver(),Duration.ofSeconds(10));
	wait.until(ExpectedConditions.textToBePresentInElementLocated(productTitle, expectedProduct));
	return GreenKart_Elements.getElementText(productTitle);
}
}
