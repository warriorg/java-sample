package me.warriorg.springboot.props;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author warrior
 */
@Component
@ConfigurationProperties(prefix="bone")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoneProperty {

//    @Value("${bone.dns}")
    private String dns;

//    @Value("${bone.ip}")
    private String ip;
}
