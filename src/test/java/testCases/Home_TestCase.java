package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Base.BaseTest;
import common.DataProviderClass;
import driverFactory.DriverConfig;
import pages.Home_Page;
import pages.Login_Page;

public class Home_TestCase extends BaseTest{
	Home_Page home_page;
	Login_Page login_page;
	
	@BeforeMethod
	public void setup() {
		 login_page = new Login_Page(DriverConfig.getDriverInstance());
		 home_page = new Home_Page(DriverConfig.getDriverInstance());
		 login_page.LoginValid();
	}
	@AfterMethod
	public void closeup() {
		home_page.SignOut();
	}
	
	 @Test(dataProvider = "homedrpData", dataProviderClass = DataProviderClass.class)
	public void HomeDrpdwn(String values, String title) {
		home_page.OpenDropDown();
		home_page.clickOptionDrpdwn(values);
//have to write assertion		
		
		}
	 
	 @Test(dataProvider = "homegetstdData", dataProviderClass = DataProviderClass.class)
		public void HomeGetstd(String values, String title) {
			login_page.LoginValid();
			home_page.clickOptionGetstd(values);
	//have to write assertion	
			
			
			}
	 
	}

