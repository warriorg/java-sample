package me.warriorg.model;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * @author gao shiyong
 * @since 2023/1/29 10:36
 */
@Data
public abstract class AbstractAnimal {
    /***
     * logger
     */
    protected final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    public void say() {
        logger.info("say");
    }
}
