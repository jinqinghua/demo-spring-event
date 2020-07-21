package kim.springevent.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.debug("--->{}={}={}", Thread.currentThread().getId(), Main.class, ObjectContext.get());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("demo async event");

        context.close();
    }
}
