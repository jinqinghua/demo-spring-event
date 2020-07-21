package kim.springevent.transactionaleventlistener.event;

import org.springframework.context.ApplicationEvent;

public class DemoMessageEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String message;

    public DemoMessageEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
