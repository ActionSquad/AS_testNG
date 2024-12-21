package common;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import driverFactory.DriverConfig;

		public class Screenshot {
	    public static void takeScreenshot() {
	        WebDriver driver = DriverConfig.getDriverInstance();
	        if (driver == null) {
	            LoggerLoad.warn("WebDriver instance is null. Cannot take screenshot.");
	            return;
	        }
	        if (driver instanceof TakesScreenshot) {
	        	Date currentDate = new Date();
	        	String SSFileName = currentDate.toString().replace(" ", "-").replace(":", "-");
	        	File SSFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        	try {
	        		FileUtils.copyFile(SSFile, new File(".//Screenshot//"+SSFileName+".png"));
	        	} catch (IOException e) {
	        		// TODO Auto-generated catch block
	        		e.printStackTrace();
	        	}

	        } else {
	          //  System.out.println("WebDriver does not support taking screenshots");
	            LoggerLoad.warn("Driver is not supporting to take the Screenshot");
	        }
	    }
	}




