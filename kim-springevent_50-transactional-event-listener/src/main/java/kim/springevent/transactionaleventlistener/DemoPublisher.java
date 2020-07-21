package kim.springevent.transactionaleventlistener;

import kim.springevent.transactionaleventlistener.event.DemoMessageEvent;
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
        log.debug("--->{}, start to publishEvent", new Date());

        applicationContext.publishEvent(new DemoMessageEvent(this, msg));

        log.debug("--->{}, end to publishEvent", new Date());
    }

}
