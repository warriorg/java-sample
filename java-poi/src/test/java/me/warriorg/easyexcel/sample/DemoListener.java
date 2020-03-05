package me.warriorg.easyexcel.sample;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import me.warriorg.easyexcel.large.LargeDataListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoListener extends AnalysisEventListener<DemoData> {
    private static final Logger LOGGER = LoggerFactory.getLogger(LargeDataListener.class);

    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        LOGGER.info("row:{}", data.toString());
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
