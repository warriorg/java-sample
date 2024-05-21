/*
 * Copyright (c) 2011 longnows.cn. All rights reserved.
 */
package me.warriorg.vo;

import java.io.Serial;
import java.io.Serializable;

import lombok.Data;

/**
 * @author gao shiyong
 * @since 2023/1/16 10:27
 */
@Data
public class DocumentTemplateSealVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
