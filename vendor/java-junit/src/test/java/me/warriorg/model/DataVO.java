package me.warriorg.model;

import lombok.Data;

@Data
public class DataVO {

    /**
     * sdsfsd
     */
    private String name;
    /***
     * 图章ID
     */
    private String imageId;

    /**
     * 印章类型
     */
    private String sealType;

    /***
     * 位置
     */
    private String position;

    /***
     * row1
     */
    private Integer row1;

    /***
     * row2
     */
    private Integer row2;

    /***
     * col1
     */
    private Integer col1;

    /***
     * col2
     */
    private Integer col2;
}
