package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    public static void readExelFile(String path,String sheetName)
    {
        try(FileInputStream file=new FileInputStream(path);) {
            workbook =new XSSFWorkbook(file);
            sheet=workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String getCellData(int row,int col)
    {
        if(sheet.getRow(row).getCell(col)==null)return "" ;
        else return String.valueOf(sheet.getRow(row).getCell(col));

    }

    public static int getNumOfRow()
    {
        return sheet.getPhysicalNumberOfRows();
    }
    public static int getNumOfColumn()
    {
        return sheet.getRow(0).getLastCellNum();
    }


}
