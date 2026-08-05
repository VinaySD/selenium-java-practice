package selenium;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingDataFromExcel {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir") + "\\src\\test\\java\\practice\\test.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        // XSSFSheet sheet = workbook.getSheet("Sheet1");
        XSSFSheet sheet = workbook.getSheetAt(0);

        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(1).getLastCellNum();

        System.out.println("Rows : " + totalRows);
        System.out.println("Columns : " + totalCols);

        for (int r = 0; r <= totalRows; r++) {

            XSSFRow row = sheet.getRow(r);

            for (int c = 0; c < totalCols; c++) {

                XSSFCell cell = row.getCell(c);

                System.out.print(cell.toString() + "\t");
            }

            System.out.println();
        }

        workbook.close();
        file.close();
    }
}