package Base;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import common.ConfigReader;
import common.ExcelReader;
import common.LoggerLoad;
import driverFactory.DriverConfig;


public class BaseTest {
	 public WebDriver driver;
	    
	    public static List<Map<String, String>> Login;
	    public static List<Map<String, String>> Code;
	    public static List<Map<String, String>> Python;
	    @BeforeClass
	   // @Parameters({"browser"})
	   // public  void setUpDriver(String browser) {
	    public void setUpDriver(){
	    	{
	    		DriverConfig.getdriver(ConfigReader.getProperty("Browser"));
	        //    DriverConfig.getdriver(browser);
	            LoggerLoad.info("Browser is opened" );
	        }
	    }
	    	
	    @BeforeClass
	    public void setUpExcel() {
	        try {
	        	String Path = "src/test/resources/TestData/ExcelData.xlsx" ;         
	        	LoggerLoad.info("Excel is Initialised and Path :" + Path);
	            ExcelReader excelreader= new ExcelReader();
	            Login = excelreader.getData(Path, "login");
	             Code = excelreader.getData(Path, "code");
	             Python = excelreader.getData(Path, "python");
	          } catch (Exception e) {
	           e.printStackTrace();
	           LoggerLoad.error("Error initializing Excel data: " + e.getMessage());
	           throw new RuntimeException("Error initializing Excel data: " + e.getMessage());
	           
	       }
	    }
	 
	    
	   @AfterClass
	  public static void tearDown() {
		   LoggerLoad.info("Closing the WebDriver instance");
	
	        DriverConfig.quitdriver();
	        
}
}
