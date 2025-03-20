package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListenersImplementation.class)
public class AddLowestPriceproductToCartTest extends BaseClass {
	
@Test(groups="RegressionSuite")
public void tc_002_AddLowestPriceproductToCartTest() throws IOException
{
		
   	 
   	 String SORTOPTION = fUtil.readDataFromExcelFile("products", 7, 2);
   	 String PRODUCTNAME = fUtil.readDataFromExcelFile("products", 7, 3);
   	 
   		
	//Click on product
	InventoryPage ip = new InventoryPage(driver);
	String productAdded = ip.clickOnSortedProduct(driver, PRODUCTNAME, SORTOPTION);
	
	//Assert.fail();
	//Add product to cart
	InventoryItemPage iip = new InventoryItemPage(driver);
	iip.clickOnAddToCartBtn();
	
	//Navigate to cart
	ip.clickOnCartContainer();
	
	//Validate the cart page
	CartPage cp = new CartPage(driver);
	String productInCart = cp.getItemName();
	
	Assert.assertEquals(productInCart,productAdded );
	System.out.println(PRODUCTNAME);
	
	System.out.println("PREETI");

	
	}

}
