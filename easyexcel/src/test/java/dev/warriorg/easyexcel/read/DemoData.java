package dev.warriorg.easyexcel.read;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 基础数据类.这里的排序和excel里面的排序一致
 *
 * @author Jiaju Zhuang
 **/
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DemoData {
    private String string;
    private Date date;
    private Double doubleData;
}