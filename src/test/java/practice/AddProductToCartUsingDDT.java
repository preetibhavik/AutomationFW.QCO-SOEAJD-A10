package practice;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AddProductToCartUsingDDT {
	public static void main(String[] args) throws IOException
	{
		//Read required data
		//Property file - Common Data
		
		//Open the doc in java readable format
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	//Create object of properties class - java util
	Properties p = new Properties();
	
	//Load the file input stream to properties
	p.load(fis);
	
	//Read the data using keys
	String URL = p.getProperty("url");
	String USERNAME = p.getProperty("username");
	String PASSWORD = p.getProperty("password");
	
	//Read the data from Excel file
	//Open the document in java readable format
	FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData1 - Copy (1).xlsx");
	
	//Create a workbook
	Workbook wb = WorkbookFactory.create(fise);
	
	//navigate to sheet
	Sheet sh = wb.getSheet("Products");
	
	//navigate to row
	Row rw = sh.getRow(1);
	
	//navigate to cell
	Cell cl = rw.getCell(2);
	
	//Capture the data inside the cell
	String PRODUCTNAME = cl.getStringCellValue();
	System.out.println(PRODUCTNAME);
	
     //Launch the browser
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
	//Load the Application
	driver.get(URL);
			
	//Login to Application
	 driver.findElement(By.id("user-name")).sendKeys(USERNAME);
	 driver.findElement(By.id("password")).sendKeys(PASSWORD);
	 driver.findElement(By.name("login-button")).click();
	         
	 //Click on a product
	  String productToBeAdded = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
	  driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
	         
	 //Add the product to cart
	  driver.findElement(By.id("add-to-cart")).click();
	         
	         //Navigate to cart
	         driver.findElement(By.id("shopping_cart_container")).click();
	         
	         //Validate for the product
	         String productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
	         if(productInCart.equals(productToBeAdded))
	         {
	        	 System.out.println("pass");
	        	 System.out.println(productInCart);
	        }
	         else
	         {
	        	 System.out.println("Fail");

	         }
	         
	         //Logout of Application
	         driver.findElement(By.xpath("//button[.='Open Menu']")).click();
	         driver.findElement(By.linkText("Logout")).click();
		}

	


	}


