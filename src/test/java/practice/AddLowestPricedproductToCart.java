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

public class AddLowestPricedproductToCart {

	public static void main(String[] args) throws IOException, InterruptedException {
		
	//Read required data
	//property file - common data
    FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
    Properties p = new Properties();
    p.load(fis);
    String URL = p.getProperty("url");
    String USERNAME = p.getProperty("username");
    String PASSWORD = p.getProperty("password");
    
	//Read data from excel file
    FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData1 - Copy (1).xlsx");
    Workbook wb = WorkbookFactory.create(fise);
    Sheet sh = wb.getSheet("Products");
    String SORTOPTION = sh.getRow(7).getCell(2).getStringCellValue();
    String PRODUCTNAME = sh.getRow(7).getCell(3).getStringCellValue();
    System.out.println(PRODUCTNAME);
    
    //Launch the browser
    WebDriver driver = new EdgeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    //Load the application
    driver.get(URL);
    
    //Login to application
    driver.findElement(By.id("user-name")).sendKeys(USERNAME);
    driver.findElement(By.id("password")).sendKeys(PASSWORD);
    driver.findElement(By.id("login-button")).click();
    
    //Sort the page for lowest price
    WebElement prodSort = driver.findElement(By.className("product_sort_container"));
    Select sel = new Select(prodSort);
    sel.selectByVisibleText(SORTOPTION);
    Thread.sleep(1000);
    
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
