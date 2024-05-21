package me.warriorg.vo;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author warriorg
 */
@Data
public class TestVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String bone;

    private List<String> strings;

    private transient List<String> transientStrings;

    /***
     * 印章
     */
    private List<DocumentTemplateSealVO> seals;
}
