package kim.springevent.transactional.listener;

import kim.springevent.transactional.user.User;
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
