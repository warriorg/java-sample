package dev.warrior.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class Demo {


    public static void main(String[] args) throws InterruptedException {
        Flux.range(1, 6)
                .doOnRequest(n -> log.info("Request {} number", n)) // 注意顺序造成的区别
//				.publishOn(Schedulers.elastic())
                .doOnComplete(() -> log.info("Publisher COMPLETE 1"))
                .map(i -> {
                    log.info("Publish {}, {}", Thread.currentThread(), i);
                    return 10 / (i - 3);
//					return i;
                })
                .doOnComplete(() -> log.info("Publisher COMPLETE 2"))
//				.subscribeOn(Schedulers.single())
//				.onErrorResume(e -> {
//					log.error("Exception {}", e.toString());
//					return Mono.just(-1);
//				})
//				.onErrorReturn(-1)
                .subscribe(i -> log.info("Subscribe {}: {}", Thread.currentThread(), i),
                        e -> log.error("error {}", e.toString()),
                        () -> log.info("Subscriber COMPLETE"),
						s -> s.request(4)
                );
        Thread.sleep(2000);
    }
}
