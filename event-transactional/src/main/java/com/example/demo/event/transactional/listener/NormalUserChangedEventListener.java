package com.example.demo.event.transactional.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@Async("defaultTaskExecutor")
public class NormalUserChangedEventListener implements ApplicationListener<UserChangedEvent> {

    public void onApplicationEvent(UserChangedEvent event) {
        log.debug("--->{}, NormalUserChangedEventListener receive the event:={}", new Date(), event.getUser());
    }

}
