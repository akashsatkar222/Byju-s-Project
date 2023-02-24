package utils;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class Utility {
	
	
	public static void captureScreenshot(WebDriver driver, String testID) throws IOException {
	Calendar cal = Calendar.getInstance();
	Date time = cal.getTime();
	String timestamp = time.toString().replace(":", "").replace(" ", "");
	TakesScreenshot js = (TakesScreenshot) driver ;
	File sroucs = js.getScreenshotAs(OutputType.FILE);
	
	File destination = new File("C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Screenshot by selenium\\"+testID+time+".jpg");
	
	FileHandler.copy(sroucs, destination);
}
	
//	public static void captureScreenshot(WebDriver driver,  String testID) throws IOException  {
//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//    Date date = new Date();
//    String dateFormat = sdf.format(date);
//    String timestamp = dateFormat.toString().replace(":", "").replace(" ", "").replace("/", "");
//	TakesScreenshot js = (TakesScreenshot) driver ;
//	File sroucs = js.getScreenshotAs(OutputType.FILE);
//	
//	File destination = new File("C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Screenshot by selenium\\"+testID+dateFormat+".jpg");
//	
//	FileHandler.copy(sroucs, destination);
//}
	
	public static String getDataFromExcelSheet(String sheet, int row, int cell) throws IOException{
		
		String path = "C:\\Users\\AKASH\\Desktop\\Software testing class\\Automation\\Email & Password in facebook.xlsx" ;
        FileInputStream file = new FileInputStream(path);
//      String Data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
        Double value = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
        String Data = value.toString();
        return Data;
	}
	


}
