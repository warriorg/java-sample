package me.warriorg.cpu;


import java.time.Duration;
import java.time.Instant;

/**
 * @author gongming
 * @description
 * @date 16/6/4
 */
public class CacheLineEffect {
    //考虑一般缓存行大小是64字节，一个 long 类型占8字节
    static  long[][] arr;

    public static void main(String[] args) {
        arr = new long[1024 * 1024][];
        for (int i = 0; i < 1024 * 1024; i++) {
            arr[i] = new long[8];
            for (int j = 0; j < 8; j++) {
                arr[i][j] = 0L;
            }
        }
        long sum = 0L;
        Instant start = Instant.now();
        for (int i = 0; i < 1024 * 1024; i+=1) {
            for(int j =0; j < 8;j++){
                sum = arr[i][j];
            }
        }
        System.out.println("Loop times:" + Duration.between(start, Instant.now()).toMillis() + "ms");

        start = Instant.now();
        for (int i = 0; i < 8; i+=1) {
            for(int j =0; j < 1024 * 1024;j++){
                sum = arr[j][i];
            }
        }
        System.out.println("Loop times:" + Duration.between(start, Instant.now()).toMillis() + "ms");
    }
}
