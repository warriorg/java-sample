package me.warriorg.spring.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

@RestController
@RequestMapping(value = "async")
public class AsyncController {
    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    @GetMapping("callable/{name}")
    @ResponseBody
    public Callable<String> asyncCallable(@PathVariable String name) {
        Callable<String> callable = () -> {
            log.info("子线程： [{}] [{}]", Thread.currentThread().getName(), Thread.currentThread().getId());
            return "hello " + name;
        };

        log.info("主线程： [{}] [{}]", Thread.currentThread().getName(), Thread.currentThread().getId());
        return callable;
    }

    @RequestMapping("/quotes")
    @ResponseBody
    public DeferredResult<String> quotes() {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        new Thread(() -> {
            log.info("子线程： [{}] [{}]", Thread.currentThread().getName(), Thread.currentThread().getId());
            deferredResult.setResult("aaaa");
        }).start();

        log.info("主线程： [{}] [{}]", Thread.currentThread().getName(), Thread.currentThread().getId());
        return deferredResult;
    }

}
