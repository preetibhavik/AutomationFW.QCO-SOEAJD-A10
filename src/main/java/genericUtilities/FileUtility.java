package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to files
 * @author DELL
 */
 public class FileUtility {
/**
 * This method read data from property file and return value to caller
 * @param key
 * @return
 * @throws IOException
 */
  public String readDataFromPropertyFile(String key) throws IOException
  {
	  FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	  Properties p = new Properties();
	  p.load(fis);
	  String value = p.getProperty(key);
	  return value;
	  
  }
  
  public String readDataFromExcelFile(String sheetName,int rowNo,int celNo ) throws EncryptedDocumentException, IOException
  {
	  FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData4 (1).xlsx");
	  Workbook wb = WorkbookFactory.create(fis);
	  String value = wb.getSheet(sheetName).getRow(rowNo).getCell(celNo).getStringCellValue();
	  return value;
	  
  }
	 
}
