package me.warriorg.easyexcel.sample;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

@Data
@EqualsAndHashCode(callSuper=false)
public class DemoData {

    @ExcelProperty(value = "提单内部编号")
    private String erpListNo;
}
