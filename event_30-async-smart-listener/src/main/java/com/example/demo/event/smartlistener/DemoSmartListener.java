package com.example.demo.event.smartlistener;

import com.example.demo.event.smartlistener.event.DemoMessageEvent;
import com.example.demo.event.smartlistener.event.DemoTimeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoSmartListener implements SmartApplicationListener {
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        log.debug("--->eventType:={}", eventType);
        return eventType == DemoMessageEvent.class || eventType == DemoTimeEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        log.debug("--->sourceType:={}", sourceType);
        return sourceType == AnnotationConfigApplicationContext.class || sourceType == DemoPublisher.class;
    }

    @Async("defaultTaskExecutor")
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof DemoMessageEvent) {
            DemoMessageEvent demoMessageEvent = (DemoMessageEvent) event;
            log.info("--->{}", demoMessageEvent.getMessage());
        } else if (event instanceof DemoTimeEvent) {
            DemoTimeEvent demoTimeEvent = (DemoTimeEvent) event;
            log.info("--->{}", demoTimeEvent.getDateTime());
        }
    }

}
