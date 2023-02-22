package me.warriorg.model;

/**
 * @author gao shiyong
 * @since 2023/1/29 10:38
 */
public class Dog extends AbstractAnimal {

    @Override
    public void say() {
        logger.info("woof");
    }
}
