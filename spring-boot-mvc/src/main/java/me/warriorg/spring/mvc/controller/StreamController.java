package me.warriorg.spring.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;

@RestController
@RequestMapping(value = "stream")
public class StreamController {

    @RequestMapping("/events")
    public ResponseBodyEmitter handle() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                emitter.send("Hello once");
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
