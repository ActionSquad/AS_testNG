package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.BaseTest;
import common.DataProviderClass;
import driverFactory.DriverConfig;
import pages.Home_Page;
import pages.Login_Page;
import pages.Tree_Page;

public class Tree_TestCase extends BaseTest {
	Tree_Page tree_page;
	Login_Page login_page;
	Home_Page home_page;
	
	
	@BeforeMethod
	public void setup() {
		 login_page = new Login_Page(DriverConfig.getDriverInstance());
		 tree_page = new Tree_Page(DriverConfig.getDriverInstance());
		 home_page = new Home_Page(DriverConfig.getDriverInstance());
		 login_page.LoginValid();
		 tree_page.GetStdButton();
		
	}
	@AfterMethod
	public void closeup() {
		
		home_page.SignOut();
	}
	@Test
	public void NavtoOverviewofTrees() {
		tree_page.OverviewBtn();	
	
	}
	@Test
	public void NavtoTryherepg() {
		tree_page.OverviewBtn();
		tree_page.TryhereBtn();
		
	}
    @Test(dataProvider = "tryeditorData", dataProviderClass = DataProviderClass.class)
	public void InvalidTryHereFunctionality(String Code, String alert, String error) {
    
		tree_page.OverviewBtn();
		tree_page.TryhereBtn();
		tree_page.TextEditor(Code);
		tree_page.RunBtn();
    		    
	    
		if(error== "syntax") {
			
			String expectedalert = alert;
			String actualalert = tree_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));
		}
		else {
			String expectedalert = alert;
			String actualalert = tree_page.AlertText();
			Assert.assertTrue(actualalert.contains(expectedalert));	
		}
		tree_page.AcceptAlert();
	    home_page.DriverNavigation();
	}
    @Test
    public void ValidTryHereFunctionality() {
    	tree_page.OverviewBtn();
		tree_page.TryhereBtn();
		tree_page.ValidTextEditor();
		tree_page.RunBtn();
		String actualcode = tree_page.OutputTxtEditorField();
		String expectedcode = Login.get(0).get("output");
		Assert.assertEquals(actualcode,expectedcode );
		 home_page.DriverNavigation();
		
    }

}
