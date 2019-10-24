package com.example.demo.event.sync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@Order(99)
public class Demo1Listener implements ApplicationListener<DemoEvent> {

    public void onApplicationEvent(DemoEvent event) {
        log.debug("--->{}, Demo1Listener receive the message:{}", new Date(), event.getMessage());
    }

}
