package me.warriorg.easyexcel.sample;

import com.alibaba.excel.EasyExcel;
import me.warrior.common.json.JSONMapper;
import me.warriorg.excel.ReadTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

public class DemoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoTest.class);
    String fileName = ReadTest.class.getResource("/").getPath() + "resources" + File.separator + "unyfone.xlsx";
    @Test
    public void read() throws Exception {
        long start = System.currentTimeMillis();
        EasyExcel.read(new FileInputStream(fileName), DemoData.class, new DemoListener())
                .headRowNumber(1).sheet().doRead();
        LOGGER.info("Large data total time spent:{}", (System.currentTimeMillis() - start) / 1000);
    }


    @Test
    public void noModleRead() {
        // 这里 只要，然后读取第一个sheet 同步读取会自动finish
//        EasyExcel.read(fileName, new NoModleDataListener()).sheet().doRead();

        List<Map<Integer,String>> list = EasyExcel.read(fileName).headRowNumber(2).sheet().doReadSync();
        System.out.println(JSONMapper.toJSONString(list));
    }

    /**
     * 同步的返回，不推荐使用，如果数据量大会把数据放到内存里面
     */
    @Test
    public void synchronousRead() {
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 同步读取会自动finish
        List<DemoData> list = EasyExcel.read(fileName).head(DemoData.class).sheet().doReadSync();
        for (DemoData data : list) {
            LOGGER.info("读取到头数据:{}", JSONMapper.toJSONString(data));
        }

        // 这里 也可以不指定class，返回一个list，然后读取第一个sheet 同步读取会自动finish
        List<Map<Integer, String>> listMap = EasyExcel.read(fileName).sheet().doReadSync();
        for (Map<Integer, String> data : listMap) {
            // 返回每条数据的键值对 表示所在的列 和所在列的值
            LOGGER.info("读取到数据:{}", JSONMapper.toJSONString(data));
        }
    }
}
