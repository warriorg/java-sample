package me.warriorg.mybatisplus.crud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("me.warriorg.**.mapper")
public class MybatisPlusConfig {

}
