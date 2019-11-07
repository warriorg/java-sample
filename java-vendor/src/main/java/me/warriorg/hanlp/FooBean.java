package me.warriorg.hanlp;

import com.hankcs.hanlp.HanLP;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FooBean {

    private String simplified;
    private String traditional;

    public void setTraditional(String traditional) {
        this.traditional = traditional;
        this.simplified = HanLP.convertToSimplifiedChinese(traditional);
    }

}
