package kim.springevent.smartlistener;

import kim.springevent.smartlistener.event.DemoTimeEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);

        // Send with demoPublisher (source is DemoPublisher.class)
        demoPublisher.publish("message event");

        // Send with context (source is Main.class)
        context.publishEvent(new DemoTimeEvent(context, new Date()));

        context.close();
    }
}
