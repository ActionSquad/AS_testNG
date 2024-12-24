package common;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	
	 @DataProvider(name = "loginData")
	    public static Object[][] getDataLogin() throws IOException {
	        return DataProviderClass.getExcelData("login"); //sheet name
	    }

	 @DataProvider(name = "homedrpData")
	    public static Object[][] getDataDrpHome() throws IOException {
	        return DataProviderClass.getExcelData("home"); //sheet name
	    }

	 @DataProvider(name = "homegetstdData")
	    public static Object[][] getDataHomeGetstd() throws IOException {
	        return DataProviderClass.getExcelData("homegetstd"); //sheet name 
	    }    
	 
	 
	 @DataProvider(name = "RegisterData")
	    public static Object[][] getDataRegister() throws IOException {
	        return DataProviderClass.getExcelData("register"); //sheet name 
	    }
	 
	 @DataProvider(name = "tryeditorData")
	    public static Object[][] getDataTryeditor() throws IOException {
	        return DataProviderClass.getExcelData("tryeditor"); //sheet name 
	    } 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
//***********************************************************************************************************************************
	 public static Object[][] getExcelData(String sheetName) throws IOException {
		    FileInputStream excel = null;
		    XSSFWorkbook workbook = null;
		    Object[][] data = null;

		    try {
		        excel = new FileInputStream("src/test/resources/TestData/dataprovider.xlsx");
		        workbook = new XSSFWorkbook(excel);
		        XSSFSheet sheet = workbook.getSheet(sheetName);

		        if (sheet == null) {
		            throw new IllegalArgumentException("Sheet \"" + sheetName + "\" does not exist in the workbook.");
		        }

		        // Get the total number of rows and columns
		        int totalRows = sheet.getPhysicalNumberOfRows(); // Use getPhysicalNumberOfRows to get the actual row count
		        int totalCols = sheet.getRow(0).getLastCellNum();

		        // Initialize the data array with the correct size
		        data = new Object[totalRows - 1][totalCols]; // -1 to exclude the header row

		        // Loop to read each row and cell
		        int rowIndex = 0;
		        for (int i = 1; i < totalRows; i++) { // Skip header row, so start from 1
		            XSSFRow row = sheet.getRow(i);

		            if (row == null) {
		                continue; // Skip null rows
		            }

		            for (int j = 0; j < totalCols; j++) {
		                XSSFCell cell = row.getCell(j);

		                // Handle null cells
		                if (cell == null) {
		                    data[rowIndex][j] = ""; // Assign empty string for null cells
		                } else {
		                    // Handle different cell types
		                    switch (cell.getCellType()) {
		                        case STRING:
		                            data[rowIndex][j] = cell.getStringCellValue();
		                            break;
		                        case NUMERIC:
		                            data[rowIndex][j] = Integer.toString((int) cell.getNumericCellValue());
		                            break;
		                        case BOOLEAN:
		                            data[rowIndex][j] = cell.getBooleanCellValue();
		                            break;
		                        case BLANK:
		                            data[rowIndex][j] = ""; // Treat blank cells as empty strings
		                            break;
		                        default:
		                            data[rowIndex][j] = ""; // Default to empty string for unknown cell types
		                            break;
		                    }
		                }
		            }
		            rowIndex++;
		        }
		    } finally {
		        if (workbook != null) {
		            workbook.close();
		        }
		        if (excel != null) {
		            excel.close();
		        }
		    }

		    return data;
		}
}