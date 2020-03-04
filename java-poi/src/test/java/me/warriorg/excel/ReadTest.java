package me.warriorg.excel;


import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadTest {

    @Test
    public void simpleRead() throws IOException {
        String fileName = ReadTest.class.getResource("/").getPath() + "resources" + File.separator + "demo.xlsx";
        
        try (InputStream inp = new FileInputStream(fileName)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(2);
            Cell cell = row.getCell(3);

            DataFormatter objDefaultFormat = new DataFormatter();
            FormulaEvaluator objFormulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
            System.out.println(objDefaultFormat.formatCellValue(cell, objFormulaEvaluator));
        }
    }
}
