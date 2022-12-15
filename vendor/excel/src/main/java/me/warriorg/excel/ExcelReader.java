package me.warriorg.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author warrior
 */
public class ExcelReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelReader.class);

    private Workbook workbook;

    public ExcelReader(InputStream stream) throws IOException {
        workbook = WorkbookFactory.create(stream);
    }

}
