package me.warriorg.easyexcel.sample;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.HashMap;

@Data
@EqualsAndHashCode(callSuper=false)
public class DemoData {

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
}
