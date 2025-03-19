package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart {

	public static void main(String[] args) {
		
		//Launch the browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Load the Application
		driver.get("https://www.saucedemo.com/");
		
		//Login to Application
         driver.findElement(By.id("user-name")).sendKeys("standard_user");
         driver.findElement(By.id("password")).sendKeys("secret_sauce");
         driver.findElement(By.name("login-button")).click();
         
         //Click on a product
         String productToBeAdded = driver.findElement(By.xpath("//div[.='Sauce Labs Fleece Jacket']")).getText();
         driver.findElement(By.xpath("//div[.='Sauce Labs Fleece Jacket']")).click();
         
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
