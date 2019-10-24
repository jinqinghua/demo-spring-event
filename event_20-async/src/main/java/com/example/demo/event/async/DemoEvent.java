package com.example.demo.event.async;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String message;

    public DemoEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
