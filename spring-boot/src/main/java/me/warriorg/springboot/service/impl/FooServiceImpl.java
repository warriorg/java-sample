package me.warriorg.springboot.service.impl;

import me.warriorg.springboot.config.AppConfig;
import me.warriorg.springboot.service.FooService;
import org.springframework.scheduling.annotation.Async;

/**
 * @author warrior
 */
public class FooServiceImpl implements FooService {


    @Async(AppConfig.ASYNC_EXECUTOR_NAME)
    public void sendMessageAsync() {

    }

}
