package greenkart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import greenkart.pages.GreenKart_ProductSearch;

public class GreenKart_ProductSearch_Test extends GreenKart_BaseTest{
	@Test
	public void verifyProductSearch()
	{
		GreenKart_ProductSearch searchpage=new GreenKart_ProductSearch();
		String productName ="Carrot";
		searchpage.enterProduct(productName);
		searchpage.clickSearchButton();
		String actualProductName= searchpage.getSearchProductTitle(productName);
		Assert.assertTrue(actualProductName.contains(productName),"Product Search Test Failed! Product not found");
	}


}
