package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {

    public static Map<String, String> readLocators(String filePath) {
        Map<String, String> locators = new HashMap<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell keyCell = row.getCell(0);
                Cell valueCell = row.getCell(1);
                if (keyCell != null && valueCell != null) {
                    locators.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locators;
    }



}
