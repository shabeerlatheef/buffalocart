package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ExcelUtils {
	
	
	public static Object[][] readExcelDataTwoDObjectArray(String FilePath, String SheetName) throws Exception
	{
		Object[][] arrObj = readData("E:\\java program\\Excel\\login1.xlsx","Sheet1");
	    return arrObj;
	}
	

	public static Object[][] readData(String f, String sheetName) throws IOException 
	{
		Object[][] ob = null ;
		FileInputStream fis = new FileInputStream(f);
		
		XSSFWorkbook w = new XSSFWorkbook(fis);
		Sheet sh = w.getSheet(sheetName);
		
		Row r = sh.getRow(0);
	    Cell c ;
	
		
		int rowcount = sh.getPhysicalNumberOfRows();
		int colcount = r.getLastCellNum();
		
	    ob = new Object[rowcount][colcount];
		
		for(int i=0;i< rowcount;i++) {
			for(int j =0;j<colcount;j++)
			{
				r=sh.getRow(i);
			    c=r.getCell(j);
			    
				switch(c.getCellType())
				{
				case Cell.CELL_TYPE_NUMERIC :
					
					ob[i][j] = (int)c.getNumericCellValue();
					break;
				
				case Cell.CELL_TYPE_STRING :
					
					ob[i][j] = c.getStringCellValue();
				    break;
				    
				case Cell.CELL_TYPE_BLANK:
					ob[i][j]=" ";
					
				default :
					ob[i][j]=null;
					break;
				}
				
			}
				//System.out.println();
		}		
			
		return ob;	
	}
}
