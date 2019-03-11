package com.example.demo.event.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@Order(99)
@Async("defaultTaskExecutor")
public class Demo1Listener implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent(DemoEvent event) {
        log.debug("--->{}, Demo1Listener receive the message:{}", new Date(), event.getMessage());
    }

}
