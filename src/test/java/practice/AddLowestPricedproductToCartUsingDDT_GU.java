package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class AddLowestPricedproductToCartUsingDDT_GU {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Create Object of all utilities
		FileUtility fUtil =  new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();
		
		//Read required data
		//property file - common data
	    
	    String URL = fUtil.readDataFromPropertyFile("url");
	    String USERNAME = fUtil.readDataFromPropertyFile("username");
	    String PASSWORD = fUtil.readDataFromPropertyFile("password");
	    
		//Read data from excel file
	    
	    String SORTOPTION = fUtil.readDataFromExcelFile("products", 7, 2);
	    String PRODUCTNAME = fUtil.readDataFromExcelFile("products", 7, 3);
	    System.out.println(PRODUCTNAME);
	    
	    //Launch the browser
	    WebDriver driver = new EdgeDriver();
	    sUtil.maximizeWindow(driver);
	    sUtil.addImplicitlyWait(driver);
	    
	    //Load the application
	    driver.get(URL);
	    
	    //Login to application
	    //driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	    //driver.findElement(By.id("password")).sendKeys(PASSWORD);
	    //driver.findElement(By.id("login-button")).click();
	    
	    LoginPage lp = new LoginPage(driver);
	    //lp.getUsernameEdt().sendKeys(USERNAME);
	    //lp.getPasswordEdt().sendKeys(PASSWORD);
	    //lp.getLoginBtn().click();
	    
	    lp.loginToApp(USERNAME, PASSWORD);
	    
	    //Sort the page for lowest price
	    WebElement prodSort = driver.findElement(By.className("product_sort_container"));
	    
	    sUtil.handleDropDown(SORTOPTION, prodSort);
	    Thread.sleep(2000);
	    
	    //Click on the lowest price product
	    WebElement Product = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
	    String productToBeAdded = Product.getText();
	    Product.click();
	    
	    //Add the product to cart
	    driver.findElement(By.id("add-to-cart")).click();
	    
	    //Navigate to cart and validate
	    driver.findElement(By.id("shopping_cart_container")).click();
	    
	    //Validate
	    String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
	    if(productToBeAdded.equals(productInCart))
	    {
	    	System.out.println("PASS");
	    }
	    else
	    {
	    	System.out.println("FAIL");
	    }
	    //Logout of Application
	    driver.findElement(By.xpath("//button[.='Open Menu']")).click();
	    driver.findElement(By.linkText("Logout")).click();
	    
	    
	    
		
		}

	

	}


