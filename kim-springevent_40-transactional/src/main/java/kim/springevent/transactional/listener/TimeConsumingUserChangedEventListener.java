package kim.springevent.transactional.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Date;

@Slf4j
@Component
@Async("defaultTaskExecutor")
public class TimeConsumingUserChangedEventListener {

    @TransactionalEventListener
    public void afterSavedUser(UserChangedEvent event) {
        log.debug("--->{}, TimeConsumingUserChangedEventListener receive the event:={}", new Date(), event.getUser());
        log.debug("--->{}, TimeConsumingUserChangedEventListener start to handle event", new Date());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("--->{}, TimeConsumingUserChangedEventListener end to handle event", new Date());
    }

}
