package Utility_Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.io.FileHandler;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Util1 {
	public static void screenshot(WebDriver driver, String str) throws IOException {
		
		SimpleDateFormat dtf=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date(); 
		  System.out.println(dtf.format(date));
		  String data=(dtf.format(date).replace('/','-')).replace(':','.');
		  
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("test-output\\Screenshots\\"+str+"- "+data+".jpeg");
		FileHandler.copy(src, dest);
		
	}
	public static String excelsheet(String sheet,int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream file= new FileInputStream("src\\main\\resources\\Testdata\\Testdata.xlsx");
		
		Workbook book= WorkbookFactory.create(file);
		
		//Sheet sheet=book.getSheetAt(0);
		
		//Row row=sheet.getRow(0);
		
		//Cell cell=row.getCell(0);
		
		try {
		String a=book.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		System.out.println(a);
		return a;
		//System.out.println(a);
		}
		catch(Exception e) {
			System.out.println("Catched exception");
			double a= book.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue();
			System.out.println(a);
		}
		return null;
	}
	
	
}
