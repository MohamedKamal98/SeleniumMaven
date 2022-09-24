package utilities;

import org.apache.commons.compress.compressors.lz4.XXHash32;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadDataFromExcel
{
    private static FileInputStream fileStream;

    private static FileInputStream getFileStream(String fileName)
    {
        File sourceFile = new File("resources/"+ fileName);

        try {
            fileStream = new FileInputStream(sourceFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found");
        }
        return fileStream;
    }

    public static Object [][] getExcelData(String fileName,String sheetName,int numberOfColumns) throws IOException
    {
        fileStream = getFileStream(fileName);
        XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        //XSSFSheet sheet = workbook.getSheetAt(0);
        int numberOfRows = sheet.getLastRowNum()+1;
        String s = sheet.getRow(0).getCell(0).toString();
        String [][] dataArray =  new String[numberOfRows][numberOfColumns];
        for(int i=0;i<numberOfRows;i++)
        {
            for(int j=0;j<numberOfColumns;j++)
            {
                dataArray[i][j]= sheet.getRow(i).getCell(j).toString();
            }
        }
        return dataArray;
    }
}
