package selenium;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataIntoSpecificRowAndCell {

    public static void main(String[] args) throws IOException {

        FileOutputStream file = new FileOutputStream(
                System.getProperty("user.dir") + "\\src\\test\\java\\practice\\myFileRandom.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Data");

        XSSFRow row = sheet.createRow(3);

        XSSFCell cell = row.createCell(4);

        cell.setCellValue("WELCOME");

        workbook.write(file);

        workbook.close();
        file.close();

        System.out.println("File is created.....");
    }
}