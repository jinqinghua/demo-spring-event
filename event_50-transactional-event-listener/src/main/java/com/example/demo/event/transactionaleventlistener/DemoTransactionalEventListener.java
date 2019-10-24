package com.example.demo.event.transactionaleventlistener;

import com.example.demo.event.transactionaleventlistener.event.DemoMessageEvent;
import com.example.demo.event.transactionaleventlistener.event.DemoTimeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class DemoTransactionalEventListener {

    @Async("defaultTaskExecutor")
    @TransactionalEventListener(fallbackExecution = true)
    public void listenDemoMessageEvent(DemoMessageEvent event) {
        log.info("--->{}", event.getMessage());
    }

    @Async("defaultTaskExecutor")
    @TransactionalEventListener(
            classes = {DemoMessageEvent.class, DemoTimeEvent.class},
            fallbackExecution = true
    )
    public void listenSpecificEvent(ApplicationEvent event) {
        if (event instanceof DemoMessageEvent) {
            DemoMessageEvent demoMessageEvent = (DemoMessageEvent) event;
            log.info("--->listenSpecificEvent:={}", demoMessageEvent.getMessage());
        } else if (event instanceof DemoTimeEvent) {
            DemoTimeEvent demoTimeEvent = (DemoTimeEvent) event;
            log.info("--->listenSpecificEvent:={}", demoTimeEvent.getDateTime());
        }
    }
}
