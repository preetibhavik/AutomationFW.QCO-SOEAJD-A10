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
public class AddProductToCartTest extends BaseClass {
     

         @Test(groups="SmokeSuite")
         public void tc_001_addproductToCart() throws IOException
         {

    	//Read the data from files
    	 String PRODUCTNAME = fUtil.readDataFromExcelFile("products", 1, 2);
    	
    	//Click on product
    	InventoryPage ip = new InventoryPage(driver);
    	String productAdded = ip.clickOnProduct(driver, PRODUCTNAME);
    	
    	//Assert.fail();
    	
    	//Add product to cart
    	InventoryItemPage iip = new InventoryItemPage(driver);
    	iip.clickOnAddToCartBtn();
    	
    	//Navigate to cart
    	ip.clickOnCartContainer();
    	
    	//Validate in the cart page
    	CartPage cp = new CartPage(driver);
    	String productInCart = cp.getItemName();
    	
    	Assert.assertEquals(productInCart, productAdded);
    	
    	Assert.assertTrue(productInCart.equals(productAdded));
    	System.out.println(PRODUCTNAME);
    	
    	
    
    	
	}


}
