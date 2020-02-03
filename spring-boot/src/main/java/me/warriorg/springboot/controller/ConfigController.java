package me.warriorg.springboot.controller;


import me.warriorg.springboot.props.BoneProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * @author warrior
 */
@RestController
@RequestMapping("config")
public class ConfigController {

    @Autowired
    BoneProperty boneProperty;

    @GetMapping
    public SseEmitter handle() {

        SseEmitter emitter = new SseEmitter();

        new Thread(() -> {
            try {
                emitter.send(MessageFormat.format("Externalized Configuration: [{0}]", boneProperty.getDns()));
                Thread.sleep(1000);
                emitter.send(MessageFormat.format("Local Configuration: [{0}]", boneProperty.getIp()));
                Thread.sleep(1000);
                emitter.send("Hello again");
                Thread.sleep(1000);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            emitter.complete();
        }).start();
        return emitter;
    }

}
