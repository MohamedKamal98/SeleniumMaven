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
        String [][] dataArray =  new String[sheet.getLastRowNum()+1][numberOfColumns];
        for(int i=0;i<sheet.getLastRowNum()+1;i++)
        {
            for(int j=0;j<numberOfColumns;j++)
            {
                dataArray[i][j]= sheet.getRow(i).getCell(j).toString();
            }
        }
        return dataArray;
    }
}
