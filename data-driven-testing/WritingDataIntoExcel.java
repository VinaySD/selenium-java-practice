package selenium;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataIntoExcel {

    public static void main(String[] args) throws IOException {

        FileOutputStream file = new FileOutputStream(
                System.getProperty("user.dir") + "\\src\\test\\java\\practice\\test2.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Data");

        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("01");
        row1.createCell(1).setCellValue("Selenium");
        row1.createCell(2).setCellValue("2026");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("19");
        row2.createCell(1).setCellValue("Java");
        row2.createCell(2).setCellValue("2026");

        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("25");
        row3.createCell(1).setCellValue("Python");
        row3.createCell(2).setCellValue("2026");

        workbook.write(file);

        workbook.close();
        file.close();

        System.out.println("File created successfully.");
    }
}