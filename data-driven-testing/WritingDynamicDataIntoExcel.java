package selenium;

import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WritingDynamicDataIntoExcel {

    public static void main(String[] args) throws IOException {

        FileOutputStream file = new FileOutputStream(
                System.getProperty("user.dir") + "\\src\\test\\java\\practice\\userip.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Dynamic_Sheet");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int totalRows = sc.nextInt();

        System.out.print("Enter number of cells: ");
        int totalCells = sc.nextInt();

        for (int r = 0; r <= totalRows; r++) {

            XSSFRow currentRow = sheet.createRow(r);

            for (int c = 0; c < totalCells; c++) {

                XSSFCell currentCell = currentRow.createCell(c);

                currentCell.setCellValue(sc.next());
            }

            System.out.println();
        }

        workbook.write(file);

        workbook.close();
        file.close();

        sc.close();

        System.out.println("File created successfully.");
    }
}