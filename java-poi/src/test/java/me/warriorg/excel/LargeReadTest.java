package me.warriorg.excel;

import me.warriorg.easyexcel.large.TempLargeDataTest;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LargeReadTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LargeReadTest.class);
    @Test
    public void read() throws IOException {
        String fileName = ReadTest.class.getResource("/").getPath() + "resources" + File.separator + "large.xlsx";

        long start = System.currentTimeMillis();
        try (InputStream inp = new FileInputStream(fileName)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0);


            for (Row row : sheet) {
                Cell cell = row.getCell(3);

                DataFormatter objDefaultFormat = new DataFormatter();
                FormulaEvaluator objFormulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
                System.out.println(objDefaultFormat.formatCellValue(cell, objFormulaEvaluator));
            }


            LOGGER.info("Large data total time spent:{}", (System.currentTimeMillis() - start) / 1000);
        }
    }
}
