package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
/**
 * This method will maximize window
 * @param driver
 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * This method will minimize window
 * @param driver
 */
public void minimizeWindow(WebDriver driver)
{
	driver.manage().window().minimize();
}
/**
 * This method will add implicitly wait of 10 seconds
 * @param driver
 */
public void addImplicitlyWait(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * This method will wait for 10 seconds for element to be visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}
 /**
  * This method will wait for 10 seconds for element to be clickable
  * @param driver
  * @param element
  */
public void waitForElementToBeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will handle dropdown by index
 * @param element
 * @param index
 */
public void handleDropDown(WebElement element,int index)
{
	Select sel =new Select(element);
	sel.selectByIndex(index);
}
/**
 * This method will handle dropdown by value
 * @param element
 * @param value
 */
public void handleDropDown(WebElement element ,String value)
{
	Select sel = new Select(element);
	sel.selectByValue(value);
}
/**
 * This method will handle dropdown by visible text
 * @param element
 * @param visibleText
 */
public void handleDropDown(String visibleText,WebElement element)
{
	Select sel = new Select(element);
	sel.selectByVisibleText(visibleText);
}
/**
 * This method will perform mouse over action on web element
 * @param driver
 * @param element
 */
public void mouseOverAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * This method perform drag and drop action on webelement
 * @param driver
 * @param element
 */
public void dragAndDropAction(WebDriver driver,WebElement srcelement,WebElement trgelement)
{
	Actions act = new Actions(driver);
	act.dragAndDrop(srcelement, trgelement).perform();
}
/**
 * This method will perform double click action on webelement
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * This method will perform right click action on web element
 * @param driver
 * @param element
 */
public void rightClickAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method will scroll to particular webelement
 * @param driver
 * @param element
 */
public void scrollToElementAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.scrollToElement(element).perform();
}
/**
 * This method will switch to frame based on index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method will switch to frame based on Name or ID
 * @param driver
 * @param nameOrID
 */
public void handleFrame(WebDriver driver,String nameOrID)
{
	driver.switchTo().frame(nameOrID);
}
/**
 * This method will switch to frame based on webelement
 */
public void handleFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * This method will switch the control to parent frame
 * @param driver
 */
public void switchtoParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}
/**
 * This method will switch to window
 * @param driver
 * @param windowID
 */
public void switchToWindow(WebDriver driver,String windowID)
{
	driver.switchTo().window(windowID);
}
/**
 * This method will accept the alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method will dismiss the alert popup
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method will get the alert text
 * @param driver
 * @return
 */
public String getAlertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}
/**
 * This method will enter the data to alert popup
 * @param driver
 * @param data
 */
public void enterDataToAlert(WebDriver driver,String data)
{
	driver.switchTo().alert().sendKeys(data);
}
/**
 * This method will capture the screenshot and return the path to caller
 * @param driver
 * @param screenShotName
 * @return
 * @throws IOException
 */
public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File(".\\ScreenShots\\"+screenShotName+".png");
	FileHandler.copy(src, dst);
	
	return dst.getAbsolutePath();//For Extent reports
}

}
