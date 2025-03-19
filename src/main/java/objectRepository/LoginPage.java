package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Rule 1:create POM class for every web page
	
	//Rule 2:Identify the WebElements -Declaration
	
	@FindBy(id="user-name")
	private WebElement usernameEdt;
	
	@FindBy(id="password")
	private WebElement passwordEdt;
	
	@FindBy(name="login-button")
	private WebElement loginBtn;
	
	//Rule 3: Initialization
public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

    //Rule 4:Utilization
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Rule 5: Business library
   /**
    * This method will perform login operation
    * @param USERNAME
    * @param PASSWORD
    */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}
