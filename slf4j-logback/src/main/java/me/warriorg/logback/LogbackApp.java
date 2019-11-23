package me.warriorg.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author warrior
 */
public class LogbackApp {

    private static final Logger log = LoggerFactory.getLogger(LogbackApp.class);

    public static void main(String[] args) {
        // 配置文件优先 groovy > xml
        log.trace("trace");
        if (log.isDebugEnabled()) {
            log.debug("debug");
        }
        log.info("info");
        log.warn("warn");
        log.error("error");
    }

}
