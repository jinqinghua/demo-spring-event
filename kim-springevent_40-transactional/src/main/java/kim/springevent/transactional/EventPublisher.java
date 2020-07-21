package kim.springevent.transactional;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class EventPublisher<E extends ApplicationEvent> implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void publishEvent(E applicationEvent) {
        log.debug("--->{}, EventPublisher start to publishEvent", new Date());

        applicationContext.publishEvent(applicationEvent);

        log.debug("--->{}, EventPublisher end to publishEvent", new Date());
    }

}
