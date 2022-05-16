package me.warriorg.juc.executor;

import java.time.LocalDateTime;
import java.util.concurrent.*;

/**
 * @author gao shiyong
 * @since 2022/5/16 15:59
 */
public class Scheduled {

    public static void main(String[] args) {
        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture future = executorService.scheduleAtFixedRate(() -> {
            System.out.println("1s " + LocalDateTime.now());
        }, 1, 2, TimeUnit.SECONDS);
        ScheduledFuture future1 = executorService.schedule(() -> {
            System.out.println("一次执行" + LocalDateTime.now());
        }, 1, TimeUnit.SECONDS);
    }
}
