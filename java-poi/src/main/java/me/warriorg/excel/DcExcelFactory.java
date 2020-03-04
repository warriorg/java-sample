package me.warriorg.excel;


import java.io.IOException;
import java.io.InputStream;

/**
 * @author warrior
 */
public class DcExcelFactory {

    public static ExcelReader read(InputStream inputStream) throws IOException {
        return new ExcelReader(inputStream);
    }

}
