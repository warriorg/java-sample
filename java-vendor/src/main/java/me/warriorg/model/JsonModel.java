package me.warriorg.model;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JsonModel implements Serializable {

    private String gNo;
    private String GModel;
    private String gName;
    private String gname;


    public static JsonModel builderJsonMode() {
        return JsonModel.builder().GModel("GModel").gNo("gNo").gName("gName").gname("gname").build();
    }
}
