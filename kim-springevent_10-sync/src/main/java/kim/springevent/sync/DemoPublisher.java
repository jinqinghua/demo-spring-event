package kim.springevent.sync;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg) {
        log.debug("--->{}<-{}", Thread.currentThread().getId(), this.getClass());
        log.debug("--->{}, start to publishEvent", new Date());

        applicationContext.publishEvent(new DemoEvent(this, msg));

        log.debug("--->{}<-{}", Thread.currentThread().getId(), this.getClass());
        log.debug("--->{}, end to publishEvent", new Date());
    }

}
