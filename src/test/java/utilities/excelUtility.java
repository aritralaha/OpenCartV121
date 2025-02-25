package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excelUtility {

    FileInputStream file;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;



    public int getTotalRows(String path,String s) throws IOException {

        file = new FileInputStream(path);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(s);
        int totalRows = sheet.getLastRowNum();
        workbook.close();
        file.close();
        return totalRows;
    }

    public int getTotalCols(String path,String s,int row) throws IOException {
       file = new FileInputStream(path);
       workbook = new XSSFWorkbook(file);
       sheet = workbook.getSheet(s);
       int getTotalColums = sheet.getRow(row).getLastCellNum();
        workbook.close();
        file.close();
       return getTotalColums;
    }

   public String getCellData(String path, String s,int row,int col) throws IOException {

       file = new FileInputStream(path);
       workbook = new XSSFWorkbook(file);
       sheet = workbook.getSheet(s);
       String cellValue = sheet.getRow(row).getCell(col).toString();
       workbook.close();
       file.close();
       return cellValue;
   }


}
