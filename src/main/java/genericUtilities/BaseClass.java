package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

//import com.beust.jcommander.Parameter;
//import com.beust.jcommander.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;
/**
 * This class consists of all basic configuration annotations of TestNG
 * @author DELL
 */
public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriver driver;
	
	//for listeners
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("------Database Connection successful-----");
    
	}
	
    //@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String Bvalue*/) throws IOException
	{
		String URL = fUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();
		
		/*For cross browser execution*/
		
		/*if(Bvalue.equalsIgnoreCase("edge")) 
		  { 
		 driver= new EdgeDriver(); 
		 }
         else if(Bvalue.equalsIgnoreCase("firefox")) 
		  {
	      driver=new FirefoxDriver(); 
		  }
		  else
		   {
		 driver= new EdgeDriver(); 
         }
         */
		 
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		driver.get(URL);
		
		System.out.println("------Browser launch successful-----");
		
		//For listeners
		sdriver=driver;

	}
    @BeforeMethod(alwaysRun=true)
    public void bmConfig() throws IOException
    {
    	String USERNAME = fUtil.readDataFromPropertyFile("username");
    	String PASSWORD = fUtil.readDataFromPropertyFile("password");
    	
    	LoginPage lp = new LoginPage(driver);
    	lp.loginToApp(USERNAME, PASSWORD);
    	System.out.println("------Login to app successful------");
    	
    }
    @AfterMethod(alwaysRun=true)
    public void amConfig()
    {
    	InventoryPage ip = new InventoryPage(driver);
    	ip.logoutOfApp();
    	
    	System.out.println("------Logout of app successful------");
    }
    //@AfterTest
    @AfterClass(alwaysRun=true)
    public void acConfig()
    {
    	driver.quit();
    	System.out.println("-----Browser closure successful-----");
    	
    }
    @AfterSuite(alwaysRun=true)
    public void asConfig()
    {
    	System.out.println("------Database closure successful-----");
    }
}
