package me.warriorg.easyexcel.large;

import com.alibaba.excel.EasyExcel;
import me.warriorg.excel.ReadTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;

public class TempLargeDataTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TempLargeDataTest.class);
    String fileName = ReadTest.class.getResource("/").getPath() + "resources" + File.separator + "large.xlsx";
    @Test
    public void read() throws Exception {
        long start = System.currentTimeMillis();
        EasyExcel.read(new FileInputStream(fileName), LargeData.class, new LargeDataListener()).headRowNumber(2).sheet().doRead();
        LOGGER.info("Large data total time spent:{}", (System.currentTimeMillis() - start) / 1000);
    }
}
