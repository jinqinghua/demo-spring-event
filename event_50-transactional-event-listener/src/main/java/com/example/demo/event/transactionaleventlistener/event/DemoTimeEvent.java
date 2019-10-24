package com.example.demo.event.transactionaleventlistener.event;

import org.springframework.context.ApplicationEvent;

import java.util.Date;

public class DemoTimeEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private Date dateTime;


    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DemoTimeEvent(Object source, Date dateTime) {
        super(source);
        this.dateTime = dateTime;
    }

    public Date getDateTime() {
        return dateTime;
    }
}
