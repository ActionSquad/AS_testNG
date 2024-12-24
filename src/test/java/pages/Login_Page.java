package pages;


import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import Base.BaseTest;
import driverFactory.DriverConfig;

public class Login_Page {
	
	WebDriver driver;
	WebDriverWait wait;
	List<Map<String, String>> Login = BaseTest.Login;
   
	
	@FindBy(className ="btn") WebElement getStdButton;
	@FindBy(linkText="Sign in") WebElement signInButton;
	@FindBy(id="id_username")public WebElement usernameField;
	@FindBy(id="id_password")public WebElement passwordField;
	@FindBy(xpath="//input[@type='submit']") WebElement loginButton;
	@FindBy(xpath="//div[@class='alert alert-primary']") WebElement validandnvalidcredAlert;
	@FindBy(linkText ="Sign out") WebElement logoutButton;
	@FindBy(xpath="//a[text()='NumpyNinja']") WebElement numpyninja;
	@FindBy(linkText ="Register!") WebElement regButton;
	
	
	
	public Login_Page( WebDriver driver) {
   		 this.driver = DriverConfig.getDriverInstance();
   	  this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterButton()
	{
		regButton.click();
	}
	public void LoginButton() {
		
		loginButton.click();
	}
	public void LogoutButton() {
		logoutButton.click();
	}
	
	public String PageTitle() {
		return driver.getTitle();	
	}
	
	public String errmsg(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor)driver;
    return (String)js.executeScript("return arguments[0].validationMessage;",element);
    }
	
   public void emptyPassword(String username) {
	usernameField.sendKeys(username);
   }
   
   public void emptyUsername(String username ,String password) {
	  usernameField.sendKeys(username);
	passwordField.sendKeys(password);
   }	
   
   public void Credentials(String username, String password) {
	usernameField.sendKeys(username);
	passwordField.sendKeys(password);
   }
  public void GetstdButton() {
	   getStdButton.click();
   }
   public void SigninButton() {
	   signInButton.click();
   }
   
   public String ValidandInvalidcredAlert() {
	   return validandnvalidcredAlert.getText().trim();  
   }
   
   public void NumpyNinja() {
	
	  numpyninja.click();
   }
 //*******************************************************************************************  
   public void LoginValid() {
	   getStdButton.click();
	   signInButton.click();
	    String username = Login.get(0).get("username");
		String password = Login.get(0).get("password");
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	} 
 //*************************************************************************************************  
   public void  GetStdPage() {
	   String url = common.ConfigReader.getProperty("URL");
	   driver.get(url);
	   
   }
   
   public void SignInPage() {
	   getStdButton.click();
	   signInButton.click();
   }
   
   public void SignInwithCred()
   {
	   String username = Login.get(0).get("username");
		String password = Login.get(0).get("password");
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
   }
   
}




















/* public  String url() {
String url = PropertyFileReader.getProperty("dsAlgoSign.URL");
String currenturl = driver.getCurrentUrl();
if(!currenturl.equals(url))
{
throw new AssertionError("User is not in sign in page");						
}
return currenturl;		
} 

public String gturrentUrl() {
return driver.getCurrentUrl();
}
public String alert() {
Alert alert =driver.switchTo().alert();
String alertmsg =alert.getText();

return alertmsg;
}*/


//String username = ConfigReader.getProperty("Username");  
	 //String password = ConfigReader.getProperty("Password");


//((JavascriptExecutor) driver).executeScript("arguments[0].click();", numpyninja);
