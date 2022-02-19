package me.warriorg.basic;

/**
 * @author warriorg
 * @date 2022/2/17 10:07
 */
public class Records  {

    public record Foo(String name, int value) {

    }


    public static void main(String[] args) {
        Foo foo = new Foo("张三", 12);
        System.out.println(foo);
    }
}
