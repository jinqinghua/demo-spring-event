package com.example.demo.event.transactional.listener;

import com.example.demo.event.transactional.user.User;
import org.springframework.context.ApplicationEvent;

public class UserChangedEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private User user;

    public UserChangedEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
