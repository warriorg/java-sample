package me.warrior.springboot.service.impl;

import me.warrior.springboot.config.AppConfig;
import me.warrior.springboot.service.FooService;
import org.springframework.scheduling.annotation.Async;

/**
 * @author warrior
 */
public class FooServiceImpl implements FooService {


    @Async(AppConfig.ASYNC_EXECUTOR_NAME)
    public void sendMessageAsync() {

    }

}
