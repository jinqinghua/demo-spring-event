package com.example.demo.event.sync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@Order(100)
public class Demo2Listener implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent(DemoEvent event) {
        log.debug("--->{}, Demo2Listener receive the message:{}", new Date(), event.getMessage());
        log.debug("--->{}, Demo2Listener start to handle message", new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("--->{}, Demo2Listener end to handle message", new Date());
    }

}
