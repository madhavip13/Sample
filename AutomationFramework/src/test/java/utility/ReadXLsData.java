package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXLsData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ReadXLsData red = new ReadXLsData();
		red.getData("login");

	} 

    public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException  
      {
    	 //Create an object of File class to open xlsx file
    	  File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
    	//Create an object of FileInputStream class to read excel file
    	  FileInputStream fis = new FileInputStream(f);
    	//Create object of XSSFWorkbook class
    	  Workbook wb = WorkbookFactory.create(fis);
    	//  Read sheet inside the workbook by its name
    	  Sheet sheetName = wb.getSheet(excelSheetName);
    	//Get the current count of rows in excel file
    	  int totalRows = sheetName.getLastRowNum();
    	  System.out.println(totalRows);
    	//Get the first row from the sheet
    	  Row rowcells = sheetName.getRow(0);
    	  int totalColmns = rowcells.getLastCellNum();
    	  System.out.println(totalColmns);
    	  
    	  DataFormatter format = new DataFormatter();
    	  
    	  String testData[][] = new String[totalRows][totalColmns];
    	  
    	  for(int i=1; i<=totalRows; i++) {
    		  
    		 for(int j=0; j<totalColmns; j++) {
    			  
    			  testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
    			 
    			  System.out.println(testData[i-1][j]);
    		  }
    	  }
    	  
    	  return testData;
     }
      
}
