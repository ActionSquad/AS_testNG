package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import driverFactory.DriverConfig;

public class Home_Page {
WebDriver driver;
	
	@FindBy(xpath = "//a[@class='nav-link dropdown-toggle']") public WebElement dropdownmenu;
	@FindBy(xpath = "//div[@class ='alert alert-primary']") public WebElement LoggedOutAlert;
	@FindBy(linkText ="Sign out")WebElement signoutButton;
	
	
	public Home_Page(WebDriver driver) {
		this.driver = DriverConfig.getDriverInstance();
		PageFactory.initElements(driver, this);
    }
	
	 public void OpenDropDown() {
			dropdownmenu.click();
		}
		
	public void clickOptionDrpdwn(String value) {
	    WebElement optionDrpdwn = driver.findElement(By.xpath("//a[text()='"+ value +"']"));
	    optionDrpdwn.click();
		    }
		 
	 public void clickOptionGetstd(String value) {
		  WebElement optionGetstd = driver.findElement(By.xpath("//a[@href='"+ value +"']"));
		  optionGetstd.click();
				    }
	 public void HomePgTitle()
			{
				driver.getTitle();
			}

	 public void DriverNavigation() {
		    	driver.navigate().back();  	
		    }
	 public void SignOut() {
			  signoutButton.click();
			  String url = common.ConfigReader.getProperty("URL");
			   driver.get(url);
		  }
	
}  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	/*
	 	@FindBy(xpath = "//a[@href='data-structures-introduction']") public WebElement DSIntroGetStartedButton;	
	@FindBy(xpath = "//a[@href='array']") public WebElement ArrayGetStartedButton;	
	@FindBy(xpath = "//a[@href='linked-list']") public WebElement LinkLstGetStartedButton;	
	@FindBy(xpath = "//a[@href='stack']") public WebElement StackGetStartedButton;	
	@FindBy(xpath = "//a[@href='queue']") public WebElement QueueGetStartedButton;	
	@FindBy(xpath = "//a[@href='tree']") public WebElement TreeGetStartedButton;	
	@FindBy(xpath = "//a[@href='graph']") public WebElement GraphGetStartedButton;	
	@FindBy(xpath = "//a[text()='Arrays']") public WebElement Arraydrpdwn;
	@FindBy(xpath = "//a[text()='Linked List']") public WebElement LinkListdrpdwn;
	@FindBy(xpath = "//a[text()='Stack']") public WebElement Stackdrpdwn;
	@FindBy(xpath = "//a[text()='Queue']") public WebElement Queuedrpdwn;
	@FindBy(xpath = "//a[text()='Tree']") public WebElement Treedrpdwn;
	@FindBy(xpath = "//a[text()='Graph']") public WebElement Graphdrpdwn;

	  
	 */
		  
		  
		  
		  
		  
		
		//  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionGetstd);


	

